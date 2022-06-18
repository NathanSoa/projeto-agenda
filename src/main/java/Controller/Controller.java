package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ImplContatoDAO;
import Model.ContatoBean;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insertBD"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ContatoBean contato = new ContatoBean();
	ImplContatoDAO contatoDAO = new ImplContatoDAO();
	
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getServletPath();
		
		switch(action) {
		
		case "/main":
			listarContatos(request, response);
			break;
			
		case "/insertBD":
			criarContato(request, response);
			break;
		}
	}
	
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			
		ArrayList<ContatoBean> listaContatos = contatoDAO.retornaTodosContatos();

		request.setAttribute("contatos", listaContatos);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void criarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		
		contatoDAO.insereContato(contato);
		
		response.sendRedirect("main");
	}
}