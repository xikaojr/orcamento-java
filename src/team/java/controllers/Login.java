package team.java.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.java.conection.Conexao;
import team.java.domain.Funcionario;

@WebServlet("/login")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	
	private Connection con = Conexao.getConnection();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Funcionario funcionario = new Funcionario();
		
		try {

			funcionario.setLogin(login);
			funcionario.setSenha(senha);

			auth(funcionario, request, response);

		} catch (Exception e) {
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("funcionario", funcionario);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);

		}
	}

	private void auth(Funcionario funcionario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";
		PreparedStatement preparador = con.prepareStatement(sql);

		if (funcionario.getLogin().isEmpty())
			throw new Exception("Login é obrigatório");
		if (funcionario.getSenha().isEmpty())
			throw new Exception("Senha é obrigatório");

		try {
			
			preparador.setString(1, funcionario.getLogin());
			preparador.setString(2, funcionario.getSenha());

			ResultSet res = preparador.executeQuery();

			if (res.next()) {

				request.setAttribute("successMessage",
						"Login realizado com sucesso, bom jogo!");
				
				//setando os valores para o objeto funcionário.
				setAttribsFuncionario(funcionario, res);
				
				newSession(request, response, funcionario);
				preparador.close();
				
				response.sendRedirect("funcionario/index.jsp");
			} else {
				throw new Exception(
						"Usuário não encontrado, verifique seus dados  tente novamente!");
			}
			preparador.close();
		} catch (Exception e) {
			preparador.close();
			request.setAttribute("errorMessage", "Erro: " + e.getMessage());

			getServletConfig().getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}

	}
	
	public void setAttribsFuncionario(Funcionario funcionario, ResultSet res) throws Exception{
		try {
			
			funcionario.setId(res.getLong("id"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setEndereco(res.getString("endereco"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setDeptoId(res.getLong("departamento_id"));
			funcionario.setDataNascimento(res.getDate("nascimento"));
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void newSession(HttpServletRequest request,
			HttpServletResponse response, Funcionario funcionario) throws Exception {

		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("AUTHENTICATED", new Boolean(true));
		session.setAttribute("funcionario", funcionario);
	}

	public void logOut(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		session.setAttribute("AUTHENTICATED", new Boolean(false));
		session.setAttribute("funcionario", null);
		
	}

}
