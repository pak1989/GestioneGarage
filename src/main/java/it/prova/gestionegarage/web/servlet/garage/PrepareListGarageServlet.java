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

@WebServlet("/PrepareListGarageServlet")
public class PrepareListGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareListGarageServlet() {
        super();
    }
    
	@Autowired
	private GarageService garageService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		request.setAttribute("listaGarage", garageService.listAllGarage());
		
		RequestDispatcher rd = request.getRequestDispatcher("/garage/results.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
