package it.prova.gestionegarage.web.servlet.garage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/ExecuteEliminaGarageServlet")
public class ExecuteEliminaGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;

	// @Autowired
	// private AutomobileService automobileService;

	public ExecuteEliminaGarageServlet() {
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
		
		Long garageId = Long.parseLong(request.getParameter("garageId"));
		Garage garageTrovato = garageService.caricaSingoloGarage(garageId);
		
		garageService.rimuovi(garageTrovato);
		
		RequestDispatcher rd = request.getRequestDispatcher("PrepareSearchGarageServlet");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
