package team.java.controllers.Item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.dao.ItemDAO;
import team.java.domain.Item;

@WebServlet(name = "ItemIndex", urlPatterns = "/item/index")
public class Index extends HttpServlet{

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
		
		String term = req.getParameter("nome");
		
		try {
			
			ItemDAO itemDAO = new ItemDAO();
			List<Item> itens = itemDAO.getAll(term);
			
			req.setAttribute("itensCadastrados", itens );
			req.getRequestDispatcher("index.jsp").forward(req,resp);

		} catch (Exception e) {
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
