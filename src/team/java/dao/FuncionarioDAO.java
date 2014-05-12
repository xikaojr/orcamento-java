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
			throw e;
		}

		return funcionario;
	}

	private PreparedStatement prepareFields(PreparedStatement preparador,
			Funcionario f) throws Exception {

		try {

			preparador.setLong(1, f.getDeptoId());
			preparador.setString(2, f.getNome());
			preparador.setString(3, f.getEmail());
			preparador.setString(4, f.getEndereco());
			preparador.setDate(5, f.getDataNascimento());
			preparador.setString(6, f.getLogin());
			preparador.setString(7, f.getSenha());
			preparador.setString(8, f.getCpf());

		} catch (SQLException e) {
			preparador.close();
			throw e;
		}

		return preparador;
	}
	
	public List<Funcionario> getAll() throws Exception {

		String sql = "SELECT f.*, d.nome as departamento FROM funcionarios as f "
				+ "LEFT JOIN  departamentos as d on f.departamento_id = d.id";

		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				
				this.setAttribsFuncionario(funcionario, rs);
				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();

			return funcionarios;

		} catch (SQLException e) {
			throw e;
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
			throw e;
		}

		return res.next() ? true : false;

	}

	public List<Funcionario> getAll(String param) throws Exception {

		String sql = "SELECT f.*, d.nome as departamento "
				+ " FROM funcionarios as f "
				+ " LEFT JOIN  departamentos as d on f.departamento_id = d.id"
				+ " WHERE f.nome ilike '%" + param
				+ "%' ";
		
		try {

			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();

				this.setAttribsFuncionario(funcionario, rs);
				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();

			return funcionarios;

		} catch (Exception e) {
			throw e;
		}
	}

	public Funcionario getById(Integer objeto) throws Exception {

		String sql = "SELECT f.*, d.nome as departamento FROM funcionarios as f"
				+ " LEFT JOIN  departamentos as d on f.departamento_id = d.id "
				+ " WHERE f.id = " + objeto + "";
		try {

			Funcionario funcionario = new Funcionario();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				this.setAttribsFuncionario(funcionario, rs);
			}

			rs.close();
			stmt.close();

			return funcionario;

		} catch (Exception e) {
			throw e;
		}
	}

	public void setAttribsFuncionario(Funcionario funcionario, ResultSet res)
			throws Exception {
		try {

			funcionario.setId(res.getLong("id"));
			funcionario.setLogin(res.getString("login"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setEndereco(res.getString("endereco"));
			funcionario.setEmail(res.getString("email"));
			funcionario.setDeptoId(res.getLong("departamento_id"));
			funcionario.setDepartamento(res.getString("departamento"));
			funcionario.setDataNascimento(res.getDate("nascimento"));
			funcionario.setCpf(res.getString("cpf"));

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Funcionario edit(Funcionario funcionario,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		String sql = "UPDATE funcionarios SET "
				+ " departamento_id = ? ,  nome = ?, "
				+ " email = ? ,  endereco = ?, "
				+ " nascimento = ?,  login = ?, " + " cpf = ? "
				+ " WHERE id = ?";

		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (funcionario.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");
			if (funcionario.getLogin().isEmpty())
				throw new Exception("Login é obrigatório");

			if (funcionario.getLogin() != request.getParameter("login")) {
				if (verificaLogin(funcionario.getLogin())) {
					throw new Exception("Este Login (" + funcionario.getLogin()
							+ ") já esta sendo usado, por favor escolha outro!");
				}
			}
			
			preparador.setLong(1, funcionario.getDeptoId());
			preparador.setString(2, funcionario.getNome().trim());
			preparador.setString(3, funcionario.getEmail().trim());
			preparador.setString(4, funcionario.getEndereco().trim());
			preparador.setDate(5, funcionario.getDataNascimento());
			preparador.setString(6, funcionario.getLogin().trim());
			preparador.setString(7, funcionario.getCpf().trim());
			preparador.setLong(8, funcionario.getId());
			
			preparador.execute();			
			preparador.close();

		} catch (SQLException e) {
			preparador.close();
			throw e;
		}

		return funcionario;
	}

}
