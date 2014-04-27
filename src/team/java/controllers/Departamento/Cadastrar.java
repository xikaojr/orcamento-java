package team.java.controllers.Departamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.dao.DepartamentoDAO;
import team.java.domain.Departamento;

@WebServlet(name = "Departamento", urlPatterns = "/departamento/cadastrar")

public class Cadastrar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	DepartamentoDAO ObjDao = new DepartamentoDAO();
	
	public Cadastrar() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");	
//		String descricao = request.getParameter("descricao");

		Departamento departamento = new Departamento();
		
		departamento.setNome(nome);
//		departamento.setDescricao(descricao);

		try {
			
			ObjDao.create(departamento, request, response);
			request.setAttribute("successMessage",
					"Departamento cadastrado com sucesso!");
			
			getServletConfig().getServletContext()
			.getRequestDispatcher("index")
			.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("departamento", departamento);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/departamento/cadastrar.jsp")
					.forward(request, response);
		}
	}
	
	

}
