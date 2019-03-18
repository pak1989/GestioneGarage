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

import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/PrepareModificaGarageServlet")
public class PrepareModificaGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareModificaGarageServlet() {
		super();
	}

	@Autowired
	private GarageService garageService;
	
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

		Long idGarage = Long.parseLong(request.getParameter("idGarage"));

		request.setAttribute("garageSingolo", garageService.caricaSingoloGarage(idGarage));

		RequestDispatcher rd = request.getRequestDispatcher("/garage/modificaForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
