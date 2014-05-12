package team.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.java.conection.Conexao;
import team.java.domain.Departamento;
import team.java.domain.Funcionario;

public class DepartamentoDAO {

	public DepartamentoDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();

	public Departamento create(Departamento departamento,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String sql = "INSERT INTO departamentos (nome, descricao, chefe_id) VALUES (?,?,?)";
		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (departamento.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");

			preparador.setString(1, departamento.getNome());
			preparador.setString(2, departamento.getDescricao());
			preparador.setLong(3, departamento.getChefeId());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			preparador.close();
			e.printStackTrace();
		}

		return departamento;
	}

	public Departamento edit(Departamento departamento,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		String sql = "UPDATE departamentos SET " + " nome = ?, "
				+ " descricao = ?,  chefe_id = ?" + " WHERE id = ?";

		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (departamento.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");

			preparador.setString(1, departamento.getNome().trim());
			preparador.setString(2, departamento.getDescricao().trim());
			preparador.setLong(3, departamento.getChefeId());
			preparador.setLong(4, departamento.getId());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			preparador.close();
			throw e;
		}

		return departamento;
	}

	public List<Departamento> getAll() throws Exception {

		String sql = "SELECT " + "d.nome as departamento, d.id as depto_id, "
				+ "f.nome as funcionario, " + "f.id as func_id "
				+ "FROM departamentos as d "
				+ "LEFT JOIN funcionarios as f ON d.chefe_id = f.id";

		try {
			List<Departamento> departamentos = new ArrayList<Departamento>();

			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Departamento departamento = new Departamento();

				departamento.setId(rs.getLong("depto_id"));
				departamento.setNome(rs.getString("departamento"));
				departamento.setChefeNome(rs.getString("funcionario"));
				departamento.setChefeId(rs.getLong("func_id"));
				departamentos.add(departamento);
			}

			rs.close();
			stmt.close();

			return departamentos;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Departamento> getAll(String term) throws Exception {

		String sql = "SELECT " + "d.nome as departamento, d.id as depto_id, "
				+ "f.nome as funcionario, " + "f.id as func_id "
				+ "FROM departamentos as d "
				+ "LEFT JOIN funcionarios as f ON d.chefe_id = f.id "
				+ "WHERE d.nome ilike '%" + term + "%'";

		try {

			List<Departamento> departamentos = new ArrayList<Departamento>();

			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Departamento departamento = new Departamento();

				departamento.setId(rs.getLong("depto_id"));
				departamento.setNome(rs.getString("departamento"));
				departamento.setChefeNome(rs.getString("funcionario"));
				departamento.setChefeId(rs.getLong("func_id"));
				departamentos.add(departamento);
			}

			rs.close();
			stmt.close();

			return departamentos;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public Departamento getById(Integer objeto) throws Exception {

		String sql = "SELECT d.*, f.nome as chefe FROM departamentos as d "
				+ " LEFT JOIN funcionarios as f on f.id = d.chefe_id"
				+ " WHERE d.id = " + objeto + "";
		try {

			Departamento dpto = new Departamento();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				setAttribsDepartamento(dpto, rs);
			}

			rs.close();
			stmt.close();

			return dpto;

		} catch (Exception e) {
			throw e;
		}
	}

	public static void setAttribsDepartamento(Departamento dpto, ResultSet res)
			throws Exception {
		try {

			dpto.setId(res.getLong("id"));
			dpto.setNome(res.getString("nome"));
			dpto.setChefeId(res.getLong("chefe_id"));
			dpto.setChefeNome(res.getString("chefe"));
			dpto.setDescricao(res.getString("descricao"));
			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
