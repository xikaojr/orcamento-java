package team.java.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Conexao() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {

		Connection con = null;

		try {

			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/orcamento", "postgres",
					"postgres");
			
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar se conectar " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {

	}

}
