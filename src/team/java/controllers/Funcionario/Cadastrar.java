package team.java.controllers.Funcionario;

import team.java.domain.Departamento;
import team.java.dao.DepartamentoDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.domain.Funcionario;
import team.java.dao.FuncionarioDAO;

@WebServlet(name = "Funcionario"
	, urlPatterns = {"/funcionario/cadastrar", "/funcionario/editar"})
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
		
			Funcionario funcionario = null;
		try {
			
			funcionario = new Funcionario(request);
			
			funcDAO.create(funcionario, request, response);
			
			request.setAttribute("successMessage",
					"Funcionário cadastrado com sucesso!");
			
			response.sendRedirect("/orcamento-java/login.jsp");
			
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
