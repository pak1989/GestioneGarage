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

@WebServlet("/ExecuteSearchGarageServlet")
public class ExecuteSearchGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchGarageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descrizioneInput = request.getParameter("descrizioneInput");
		String nomeInput = request.getParameter("nomeInput");
		String indirizzoInput = request.getParameter("indirizzoInput");

		request.setAttribute("listaGarage", garageService.findByExample(new Garage(descrizioneInput, nomeInput, indirizzoInput)));

		RequestDispatcher rd = request.getRequestDispatcher("/garage/results.jsp");
		rd.forward(request, response);
	}

}
