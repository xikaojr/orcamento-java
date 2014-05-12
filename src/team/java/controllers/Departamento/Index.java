package team.java.controllers.Departamento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.dao.DepartamentoDAO;
import team.java.domain.Departamento;

@WebServlet(name = "DepartamentoIndex", urlPatterns = "/departamento/index")
public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public Index() {
		// TODO Auto-generated constructor stub
	}
	
	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = req.getParameter("nome");

		try {
			
			DepartamentoDAO ObjDAO = new DepartamentoDAO();
			List<Departamento> departamentos = null;
			
			if(nome == null){
				departamentos = ObjDAO.getAll();				
			}else{
				departamentos = ObjDAO.getAll(nome);
			}
			
			req.setAttribute("departamentosCadastrados", departamentos);
			req.getRequestDispatcher("index.jsp").forward(req,resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
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
