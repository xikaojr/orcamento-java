package team.java.controllers.FuncionarioController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.dao.FuncionarioDAO;
import team.java.domain.Funcionario;

@WebServlet(name = "ListFuncionario", urlPatterns = "/funcionario/index")
public class Index extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Index() {
		// TODO Auto-generated constructor stub
	}
	
	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = req.getParameter("nome");
		

		try {
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			
			List<Funcionario> funcionarios = funcDAO.getAll();
			
			req.setAttribute("funcionarios", funcionarios);
			req.getRequestDispatcher("index.jsp").forward(req,resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			System.out.println(e.getMessage());			
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
