package team.java.dao;

import java.sql.Connection;
import java.sql.Date;
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

		String sql = "INSERT INTO funcionarios"
				+ "(departamento_id, nome, email, endereco,"
				+ " nascimento, login, senha, cpf) "
				+ " VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (funcionario.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");
			if (funcionario.getLogin().isEmpty())
				throw new Exception("Login é obrigatório");
			if (funcionario.getSenha().isEmpty())
				throw new Exception("Senha é obrigatório");
			
			preparador = prepareFields(preparador, funcionario);
			
			if (verificaLogin(funcionario.getLogin())) {
				throw new Exception("Este Login (" + funcionario.getLogin()
						+ ") já esta sendo usado por favor escolha outro!");
			}

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			preparador.close();
			throw new Exception(e.getMessage());
		}

		return funcionario;
	}

	private PreparedStatement prepareFields(PreparedStatement preparador
			, Funcionario f) throws Exception {
		
		try {
			
			preparador.setLong  (1, f.getDeptoId());
			preparador.setString(2, f.getNome());
			preparador.setString(3, f.getEmail());
			preparador.setString(4, f.getEndereco());
			preparador.setDate(5, f.getDataNascimento());
			preparador.setString(6, f.getLogin());
			preparador.setString(7, f.getSenha());
			preparador.setString(8, f.getCpf());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}
		
		return preparador;
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
		
		String sql = "SELECT * FROM funcionarios WHERE nome ilike '%"+param+"%' ";
		try {
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = con.prepareStatement(sql);
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
