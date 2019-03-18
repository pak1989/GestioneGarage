package it.prova.gestionegarage.web.servlet.automobile;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionegarage.service.automobile.AutomobileService;

@WebServlet("/ExecuteTestSpringDataAutomobileServlet")
public class ExecuteTestSpringDataAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AutomobileService automobileService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteTestSpringDataAutomobileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codiceOperazione = request.getParameter("codop");
		String queryInput = request.getParameter("queryInput");

		Object resultFromQuery = null;

		switch (codiceOperazione) {
		case "findByMarca":
			resultFromQuery = automobileService.findByMarca(queryInput);
			break;
		case "findByCilindrataGreaterThan":
			resultFromQuery = automobileService.cercaAutomobiliConCilindrataMaggioreDi(Integer.parseInt(queryInput));
			break;

		case "findByModelloAndCilindrata":
		
			resultFromQuery = automobileService.cercaAutomobiliPerModelloAndCilindrata(queryInput, Integer.parseInt(request.getParameter("queryInputCilindrata")));
			break;
		case "findByCilindrataOrderByMarcaDesc":

			resultFromQuery = automobileService.cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(Integer.parseInt(request.getParameter("queryInputCilindrata")));
			break;
		case "findByMarcaStartsWith":
			resultFromQuery = automobileService.cercaPerMarcaCheIniziaCon(queryInput);
			break;

		case "findByGarageId":
			Long queryInputLong = Long.parseLong(queryInput);
			resultFromQuery = automobileService.cercaPerGarageId(queryInputLong);
			break;
			
		default:
			break;
		}

		String result = resultFromQuery == null ? "" : resultFromQuery.toString();

		response.getWriter().append("Risultato: =====>>> " + codiceOperazione).append("\n").append(result);
	}

}
