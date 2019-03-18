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

@WebServlet("/PrepareDettaglioAutomobileServlet")
public class PrepareDettaglioAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDettaglioAutomobileServlet() {
		super();
	}

	@Autowired
	private AutomobileService automobileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controllo utente in sessione (va fatto in tutte le servlet)
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Long idAutomobile = Long.parseLong(request.getParameter("idAutomobile"));

		request.setAttribute("automobileSingola", automobileService.caricaSingoloAutomobile(idAutomobile));

		RequestDispatcher rd = request.getRequestDispatcher("/automobile/dettaglio.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
