package it.prova.gestionegarage.web.servlet.automobile;

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

import it.prova.gestionegarage.dto.AutomobileDTO;
import it.prova.gestionegarage.model.Automobile;
import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.service.automobile.AutomobileService;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/ExecuteModificaAutomobileServlet")
public class ExecuteModificaAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GarageService garageService;
	
	@Autowired
	private AutomobileService automobileService;

	public ExecuteModificaAutomobileServlet() {
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
		
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		String marcaInput = request.getParameter("marcaInput");
		String modelloInput = request.getParameter("modelloInput");
		String targaInput = request.getParameter("targaInput");
		
		AutomobileDTO automobileDTO = new AutomobileDTO(marcaInput, modelloInput, targaInput);

		try {			
			Long automobileId = Long.parseLong(request.getParameter("automobileId"));			
			automobileDTO.setId(automobileId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			automobileDTO.setId(null);
		}

		try {			
			int cilindrataInput = Integer.parseInt(request.getParameter("cilindrataInput"));			
			automobileDTO.setCilindrata(cilindrataInput);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			automobileDTO.setCilindrata(-1);
		}
		
		try {			
			Long garageId = Long.parseLong(request.getParameter("garageId"));
			Garage garageTrovato = garageService.caricaSingoloGarage(garageId);
			automobileDTO.setGarage(garageTrovato);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		List<String> validationMessageStrings = automobileDTO.validate();

		if (!validationMessageStrings.isEmpty()) {
			request.setAttribute("messaggiErrore", validationMessageStrings);
			request.setAttribute("automobileDTO", automobileDTO);
			RequestDispatcher rd = request.getRequestDispatcher("/automobile/modificaForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		Automobile autoDaModificare = automobileService.caricaSingoloAutomobile(automobileDTO.getId());
		
		autoDaModificare.setMarca(marcaInput);
		autoDaModificare.setModello(modelloInput);
		autoDaModificare.setCilindrata(automobileDTO.getCilindrata());
		autoDaModificare.setGarage(automobileDTO.getGarage());
		
		automobileService.aggiorna(autoDaModificare);
		
		request.setAttribute("automobileSingola", autoDaModificare);

		RequestDispatcher rd = request.getRequestDispatcher("/automobile/dettaglio.jsp");
		rd.forward(request, response);

	}

}
