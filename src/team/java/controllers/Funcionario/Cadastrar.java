package team.java.controllers.Funcionario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.domain.Funcionario;
import team.java.dao.FuncionarioDAO;

@WebServlet(name = "Funcionario", urlPatterns = "/funcionario/cadastrar")
public class Cadastrar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FuncionarioDAO funcDAO = new FuncionarioDAO();
	
	public Cadastrar(){
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");	
		String login = request.getParameter("login");
		String senha = request.getParameter("password");

		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(nome);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);

		try {
			
			funcDAO.create(funcionario, request, response);
			request.setAttribute("successMessage",
					"Funcionário cadastrado com sucesso!");
			
			response.sendRedirect("/login.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("funcionario", funcionario);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/funcionario/cadastrar.jsp")
					.forward(request, response);
		}
	}
	

}
