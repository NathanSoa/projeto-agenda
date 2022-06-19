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

@WebServlet(urlPatterns = {"/Controller", "/main", "/insertBD", "/editarBD", "/update"})
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
			
		case "/editarBD":
			editarContatos(request, response);
			break;
			
		case "/update":
			editarContatoBD(request, response);
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
	
	protected void editarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String codigo = request.getParameter("con_codigo");
		
		contato = contatoDAO.buscaContatoPorCodigo(codigo);
		
		request.setAttribute("codigo", contato.getCodigo());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarContatoBD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		contato.setCodigo(request.getParameter("codigo"));
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		
		contatoDAO.alteraContato(contato);
		
		response.sendRedirect("main");
	}
}