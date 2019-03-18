package it.prova.gestionegarage.web.servlet.automobile;

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

import it.prova.gestionegarage.service.automobile.AutomobileService;

@WebServlet("/PrepareListAutomobileServlet")
public class PrepareListAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private GarageService garageService;
	
	@Autowired
	private AutomobileService automobileService;

	public PrepareListAutomobileServlet() {
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
		
		request.setAttribute("listaAutomobile", automobileService.listAllAutomobili());
		
		RequestDispatcher rd = request.getRequestDispatcher("/automobile/searchResult.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
