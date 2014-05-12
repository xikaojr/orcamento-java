package team.java.controllers.Departamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import team.java.dao.DepartamentoDAO;
import team.java.domain.Departamento;
import team.java.domain.Funcionario;

@WebServlet(name = "Departamento", urlPatterns = { "/departamento/cadastrar",
		"/departamento/editar" })
public class Cadastrar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DepartamentoDAO ObjDao = new DepartamentoDAO();

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
		case "edit":
			this.edit(request, response);
			break;
		default:
			break;
		}

	}

	protected void create(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String chefe_id = request.getParameter("chefe_id");
		String descricao = request.getParameter("descricao");

		Departamento departamento = new Departamento();

		departamento.setNome(nome);
		departamento.setChefeId(Long.parseLong(chefe_id));
		departamento.setDescricao(descricao);

		try {

			departamento = ObjDao.create(departamento, request, response);

			request.setAttribute("typeAlert", "success!");

			request.setAttribute("message",
					"Departamento cadastrado com sucesso!");

			getServletConfig().getServletContext()
					.getRequestDispatcher("/departamento/index.jsp")
					.forward(request, response);

		} catch (Exception e) {

			request.setAttribute("typeAlert", "error");

			request.setAttribute("message",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("departamento", departamento);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/departamento/cadastrar.jsp")
					.forward(request, response);
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		Departamento departamento = null;
		DepartamentoDAO dptoDAO = new DepartamentoDAO();

		try {

			departamento = new Departamento(request);

			dptoDAO.edit(departamento, request, response);

			request.setAttribute("typeAlert", "success");
			request.setAttribute("message", "Departamento editado com sucesso!");

			getServletConfig().getServletContext()
					.getRequestDispatcher("/departamento/index.jsp")
					.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("typeAlert", "error");
			request.setAttribute("message", e.getMessage().toString());

			getServletConfig().getServletContext()
					.getRequestDispatcher("/departamento/editar.jsp?departemento="+id)
					.forward(request, response);

		}

	}

}
