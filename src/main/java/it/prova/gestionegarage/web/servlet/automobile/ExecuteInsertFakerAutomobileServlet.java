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

import com.github.javafaker.Faker;

import it.prova.gestionegarage.model.Automobile;
import it.prova.gestionegarage.service.automobile.AutomobileService;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/ExecuteInsertFakerAutomobileServlet")
public class ExecuteInsertFakerAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;

	@Autowired
	private AutomobileService automobileService;

	public ExecuteInsertFakerAutomobileServlet() {
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
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Faker faker = new Faker();

		for (int i = 0; i < 100; i++) {
			String targa = "";
			String marca = faker.lordOfTheRings().character();
			String modello = faker.lordOfTheRings().location();
			targa += marca.charAt(faker.number().numberBetween(0, marca.length()));
			targa += marca.charAt(faker.number().numberBetween(0, marca.length()));
			targa += faker.number().numberBetween(100, 999);
			targa += marca.charAt(faker.number().numberBetween(0, marca.length()));
			targa += marca.charAt(faker.number().numberBetween(0, marca.length()));
			Automobile autoTemp = new Automobile(marca, modello, faker.number().numberBetween(1000, 5000),
					StringUtils.upperCase(targa), garageService.caricaSingoloGarage(1L));
			automobileService.inserisciNuovo(autoTemp);
		}

		RequestDispatcher rd = request.getRequestDispatcher("PrepareListAutomobileServlet");
		rd.forward(request, response);

	}

}
