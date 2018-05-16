package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	private Connection conexao;
	
	public FabricaConexao() {
		conexao = null;
	}
	
	public Connection getConexao() {
		
		if(conexao == null) {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/escolaDB", "root", "");
				
				return conexao;
				
			} catch (ClassNotFoundException e) {
				System.out.println("Problemas ao instanciar o driver");
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				System.out.println("Problemas ao conectar com o banco");
				e.printStackTrace();
				return null;
			}
			
		} else {
			
			return conexao;
			
		}
		
	}

}
