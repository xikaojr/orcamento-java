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

public class DepartamentoDAO {

	public DepartamentoDAO() {
		// TODO Auto-generated constructor stub
	}

	
private Connection con = Conexao.getConnection();
	
	public Departamento create(Departamento departamento, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		
		String sql = "INSERT INTO departamentos (nome) VALUES (?)";
		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (departamento.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");

			preparador.setString(1, departamento.getNome());
//			preparador.setString(2, departamento.getDescricao().toString());

			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			preparador.close();
			e.printStackTrace();
		}
		
		return departamento;
	}
	
	public List<Departamento> getAll() throws Exception{
	    
		String sql = "SELECT "
					+ "d.nome as departamento, d.id as depto_id, "
					+ "f.nome as funcionario, "
					+ "f.id as func_id "
					+ "FROM departamentos as d "
					+ "LEFT JOIN funcionarios as f ON d.chefe_id = f.id";
		System.out.println(sql);
	    try{
	    	List<Departamento> departamentos = new ArrayList<Departamento>();
	        
	    	PreparedStatement stmt = this.con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	         
	        while (rs.next()){
	        	Departamento departamento = new Departamento();
	            
	        	departamento.setNome(rs.getString("departamento"));
	        	departamento.setId(rs.getLong("depto_id"));
	        	departamento.setChefeNome(rs.getString("funcionario"));
	        	departamento.setChefeId(rs.getLong("func_id"));
	            departamentos.add(departamento);
	        }
	        
	        rs.close();
	        stmt.close();
	        
	        return departamentos;
	        
	    }catch(SQLException e){
	        throw new Exception(e.getMessage());
	    }
	}
	

}
