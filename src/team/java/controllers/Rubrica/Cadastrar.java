package team.java.controllers.Rubrica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.dao.RubricaDAO;
import team.java.domain.Rubrica;

@WebServlet(name = "Rubrica", urlPatterns = { "/rubrica/cadastrar",
		"/rubrica/editar" })
public class Cadastrar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RubricaDAO ObjDao = new RubricaDAO();

	public Cadastrar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {

			Rubrica rubrica = new Rubrica();
			
		try {
			
			String nome = request.getParameter("nome");
			String tipo = request.getParameter("tipo");


			rubrica.setNome(nome);
			rubrica.setTipo(tipo);

			if (rubrica.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");
			if (rubrica.getTipo().isEmpty())
				throw new Exception("Tipo de Rubrica é obrigatório");

			rubrica = ObjDao.create(rubrica, request, response);

			request.setAttribute("successMessage",
					"Rubrica cadastrada com sucesso!");

			getServletConfig().getServletContext()
					.getRequestDispatcher("/rubrica/index")
					.forward(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("rubrica", rubrica);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/rubrica/cadastrar.jsp")
					.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("rubrica", rubrica);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/rubrica/cadastrar.jsp")
					.forward(request, response);
		}
	}

}
