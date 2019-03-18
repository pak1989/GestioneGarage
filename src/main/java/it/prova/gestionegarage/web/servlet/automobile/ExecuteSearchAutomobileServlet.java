package it.prova.gestionegarage.web.servlet.automobile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionegarage.model.Automobile;
import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.service.automobile.AutomobileService;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/ExecuteSearchAutomobileServlet")
public class ExecuteSearchAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;
	
	@Autowired
	private AutomobileService automobileService;
	
	public ExecuteSearchAutomobileServlet() {
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

		Automobile example = new Automobile();
		
		if (StringUtils.isNotEmpty(marcaInput)){
			example.setMarca(marcaInput);
		}

		if (StringUtils.isNotEmpty(modelloInput)){
			example.setMarca(modelloInput);
		}	

		try {			
			int cilindrataInput = Integer.parseInt(request.getParameter("cilindrataInput"));			
			example.setCilindrata(cilindrataInput);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		try {			
			Long garageId = Long.parseLong(request.getParameter("garageId"));
			Garage garageTrovato = garageService.caricaSingoloGarage(garageId);
			example.setGarage(garageTrovato);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listaAutomobile", automobileService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/automobile/searchResult.jsp");
		rd.forward(request, response);

	}

}
