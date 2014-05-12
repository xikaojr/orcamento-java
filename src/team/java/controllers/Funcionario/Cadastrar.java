package team.java.controllers.Funcionario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.StopTask;

import team.java.dao.FuncionarioDAO;
import team.java.domain.Funcionario;

@WebServlet(name = "Funcionario", urlPatterns = { "/funcionario/cadastrar",
		"/funcionario/editar" })
public class Cadastrar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FuncionarioDAO funcDAO = new FuncionarioDAO();

	public Cadastrar() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "create":
			this.create(request, response);
			break;
		case "editar":
			this.editar(request, response);
			break;
		default:
			break;
		}

	}

	protected void create(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Funcionario funcionario = null;

		try {

			funcionario = new Funcionario(request);

			funcDAO.create(funcionario, request, response);

			request.setAttribute("message",
					"Funcionário cadastrado com sucesso!");

			request.setAttribute("tipoAlerta", "success");

			getServletConfig().getServletContext()
					.getRequestDispatcher("/funcionario/index.jsp")
					.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("dados", funcionario);

			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/funcionario/cadatrar.jsp")
					.forward(request, response);
		}
	}

	protected void editar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Funcionario funcionario = null;
		Long id = Long.parseLong(request.getParameter("id"));

		try {

			funcionario = new Funcionario(request);
			funcionario.setId(id);

			funcDAO.edit(funcionario, request, response);

			request.setAttribute("message", "Funcionário editado com sucesso!");

			request.setAttribute("tipoAlerta", "success");

			getServletConfig().getServletContext()
					.getRequestDispatcher("/funcionario/index.jsp")
					.forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			getServletConfig()
					.getServletContext()
					.getRequestDispatcher(
							"/funcionario/editar.jsp?funcionario="
									+ id.toString()).forward(request, response);
		}

	}
}
