package it.prova.gestionegarage.web.servlet.garage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionegarage.dto.GarageDTO;
import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/ExecuteInsertGarageServlet")
public class ExecuteInsertGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GarageService garageService;
	
//	@Autowired
//	private AutomobileService automobileService;

	public ExecuteInsertGarageServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String descrizioneInput = request.getParameter("descrizioneInput");
		String nomeInput = request.getParameter("nomeInput");
		String indirizzoInput = request.getParameter("indirizzoInput");
		
		GarageDTO garageDTO = new GarageDTO(nomeInput, descrizioneInput, indirizzoInput);
		List<String> validationMessageStrings = garageDTO.validate();
		
		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("garageDTO", garageDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/garage/inserisciNuovo.jsp");
			rd.forward(request, response);
			return;
		}
		
		Garage nuovoGarage = new Garage(descrizioneInput, nomeInput, indirizzoInput);
		
		garageService.inserisciNuovo(nuovoGarage);
		
		request.setAttribute("garageSingolo",
				garageService.caricaSingoloGarage(nuovoGarage.getId()));

		RequestDispatcher rd = request.getRequestDispatcher("/garage/dettaglio.jsp");
		rd.forward(request, response);

//		response.getWriter().append("Parametri =====>>> ").append("\nmarcaInput: " + marcaInput)
//				.append("\nmodelloInput: " + modelloInput).append("\ncilindrataInput: " + cilindrataInput)
//				.append("\ngarageId: " + garageId);

	}

}
