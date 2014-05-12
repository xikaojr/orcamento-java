package team.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.java.conection.Conexao;
import team.java.domain.Item;

public class ItemDAO {

	public ItemDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();

	public List<Item> getAll(String nome) throws Exception {

		String sql = "";
		if (nome == null) {

			sql = "SELECT i.*,"
					+ " r.nome as rubrica, r.tipo as tipo_rubrica, r.id as rubrica_id"
					+ " FROM itens as i"
					+ " JOIN rubricas as r on i.rubrica_id = r.id";
		} else {
			sql = "SELECT i.*,"
					+ " r.nome as rubrica, r.tipo as tipo_rubrica, r.id as rubrica_id"
					+ " FROM itens as i"
					+ " JOIN rubricas as r on i.rubrica_id = r.id"
					+ " WHERE i.nome ilike '%" + nome + "%'";
		}

		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		return getAll(stmt, rs);

	}

	public List<Item> getAll(PreparedStatement stmt, ResultSet rs) throws Exception {

		try {

			List<Item> itens = new ArrayList<Item>();


			while (rs.next()) {
				Item item = new Item();
				setAttribsItem(item, rs);
				itens.add(item);
			}

			rs.close();
			stmt.close();

			return itens;

		} catch (SQLException e) {
			stmt.close();
			throw e;
		}
	}

	public static void setAttribsItem(Item item, ResultSet res) throws Exception {
		try {

			item.setId(res.getLong("id"));
			item.setNome(res.getString("nome"));
			item.setRubricaId(res.getLong("rubrica_id"));
			item.setRubricaNome(res.getString("rubrica"));
			item.setRubricaTipo(res.getString("tipo_rubrica"));
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
