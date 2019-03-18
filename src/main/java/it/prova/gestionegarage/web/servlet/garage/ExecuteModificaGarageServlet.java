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

@WebServlet("/ExecuteModificaGarageServlet")
public class ExecuteModificaGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;

	// @Autowired
	// private AutomobileService automobileService;

	public ExecuteModificaGarageServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long garageId = Long.parseLong(request.getParameter("garageId"));

		String descrizioneInput = request.getParameter("descrizioneInput");
		String nomeInput = request.getParameter("nomeInput");
		String indirizzoInput = request.getParameter("indirizzoInput");
		
		GarageDTO garageDTO = new GarageDTO(garageId, nomeInput, descrizioneInput, indirizzoInput);
		
		List<String> validationMessageStrings = garageDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("garageDTO", garageDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/garage/modificaForm.jsp");
			rd.forward(request, response);
			return;
		}

		Garage garageTrovato = garageService.caricaSingoloGarage(garageId);

		garageTrovato.setDescrizione(descrizioneInput);
		garageTrovato.setNome(nomeInput);
		garageTrovato.setIndirizzo(indirizzoInput);

		garageService.aggiorna(garageTrovato);

		request.setAttribute("garageSingolo", garageTrovato);

		RequestDispatcher rd = request.getRequestDispatcher("/garage/dettaglio.jsp");
		rd.forward(request, response);

	}

}
