package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ConexaoBD;

@WebServlet(urlPatterns = {"/Controller", "/main"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getServletPath();
		
		switch(action) {
		
		case "/main":
			listarContatos(request, response);
			break;
		}
	}
	
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			
		response.sendRedirect("jsp/agenda.jsp");
	}
}