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
import team.java.domain.Rubrica;

public class RubricaDAO {

	public RubricaDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();
	
	public Rubrica create(Rubrica rubrica, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String sql = "INSERT INTO rubricas (nome, tipo) VALUES (?,?)";
		PreparedStatement preparador = con.prepareStatement(sql);

		try {
			preparador.setString(1, rubrica.getNome());
			preparador.setString(2, rubrica.getTipo());

			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			preparador.close();
			throw e;
		}
		
		return rubrica;
	}
	
	public List<Rubrica> getAll() throws Exception{
	    
		String sql = "SELECT * FROM rubricas";
		
	    try{
	    	List<Rubrica> rubricas = new ArrayList<Rubrica>();
	        
	    	PreparedStatement stmt = this.con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	         
	        while (rs.next()){
	        	Rubrica rubrica = new Rubrica();
	            
	        	rubrica.setNome(rs.getString("nome"));
	        	rubrica.setId(rs.getLong("tipo"));
	            rubricas.add(rubrica);
	        }
	        
	        rs.close();
	        stmt.close();
	        
	        return rubricas;
	        
	    }catch(SQLException e){
	        throw e;
	    }
	}
}
