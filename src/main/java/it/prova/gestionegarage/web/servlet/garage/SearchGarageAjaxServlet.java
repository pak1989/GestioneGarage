package it.prova.gestionegarage.web.servlet.garage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.service.garage.GarageService;

@WebServlet("/SearchGarageAjaxServlet")
public class SearchGarageAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GarageService garageService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchGarageAjaxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String term = request.getParameter("term");

		List<Garage> listaGrageByTerm = garageService.cercaByNomeILike(term);
		String json = buildJsonResponse(listaGrageByTerm);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
	}

	private String buildJsonResponse(List<Garage> listaGarage) {
		JsonArray ja = new JsonArray();

		for (Garage garageElement : listaGarage) {
			JsonObject jo = new JsonObject();
			jo.addProperty("value", garageElement.getId());
			jo.addProperty("label", garageElement.getNome());
			ja.add(jo);
		}

		return new Gson().toJson(ja);
	}

}
