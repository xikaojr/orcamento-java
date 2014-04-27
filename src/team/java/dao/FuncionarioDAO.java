package team.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.conection.Conexao;
import team.java.domain.Funcionario;

public class FuncionarioDAO {

	public FuncionarioDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();

	public Funcionario create(Funcionario funcionario,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String sql = "INSERT INTO funcionarios (nome, login, senha) VALUES (?, ?, ?)";
		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (funcionario.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");
			if (funcionario.getLogin().isEmpty())
				throw new Exception("Login é obrigatório");
			if (funcionario.getSenha().isEmpty())
				throw new Exception("Senha é obrigatório");

			preparador.setString(1, funcionario.getNome());
			preparador.setString(2, funcionario.getLogin());
			preparador.setString(3, funcionario.getSenha());

			if (verificaLogin(funcionario.getLogin())) {
				throw new Exception("Este Login (" + funcionario.getLogin()
						+ ") já esta sendo usado por favor escolha outro!");
			}

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			preparador.close();
			e.printStackTrace();
		}

		return funcionario;
	}

	public List<Funcionario> getAll() throws Exception {

		String sql = "SELECT * FROM funcionarios";

		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setNome(rs.getString("nome"));
				funcionario.setLogin(rs.getString("login"));
				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();

			return funcionarios;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	private boolean verificaLogin(String login) throws Exception {

		ResultSet res = null;

		try {

			String sql = "SELECT id FROM funcionarios WHERE login = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			res = preparador.executeQuery();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return res.next() ? true : false;

	}

	public List<Funcionario> getAll(String param) throws Exception {
		
		String sql = "SELECT * FROM funcionarios WHERE nome ILIKE '%?%' ";

		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, param);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();

			return funcionarios;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}
