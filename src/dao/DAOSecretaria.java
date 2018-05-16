package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Secretaria;


public class DAOSecretaria {

	private Connection conexao;

	public DAOSecretaria(Connection conexao){
		this.conexao = conexao;
	}

	public boolean adiciona(Secretaria s){

		String sql = "insert into Secretaria(nome, cpf, email, endereço, telefone, matricula)"
				+ "values(?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, s.getNome());
			stmt.setString(2, s.getCpf());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getEndereco());
			stmt.setInt(5, s.getTelefone());
			stmt.setInt(5, s.getMatricula());

			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}
	}

	public boolean remove(int matricula){

		String sql = "delete from secretaria where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, matricula);

			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}
	}

	public boolean atualiza(Secretaria s){

		String sql = "update aluno set nome = ?, cpf = ?, email = ?, endereço = ?, telefone = ? where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, s.getNome());
			stmt.setString(2, s.getCpf());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getEndereco());
			stmt.setInt(5, s.getTelefone());
			stmt.setInt(6, s.getMatricula());


			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}	
	}

	public List<Secretaria> lista(){

		String sql = "select * from aluno";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Secretaria> resultado = new ArrayList<Secretaria>();

			while(rs.next()){

				Secretaria s= new Secretaria();
				s.setMatricula(rs.getInt("matricula"));
				s.setNome(rs.getString("nome"));
				s.setCpf(rs.getString("cpf"));
				s.setEmail(rs.getString("email"));
				s.setEndereco(rs.getString("endereço"));
				s.setTelefone(rs.getInt("telefone"));
				

				resultado.add(s);
			}

			stmt.close();
			rs.close();

			return resultado;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return null;
		}
	}

	public Secretaria buscaPorMatricula(int matricula) {

		String sql = "select * from secretaria where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, matricula);

			ResultSet rs = stmt.executeQuery();

			Secretaria resultado = new Secretaria();

			while(rs.next()){

				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setNome(rs.getString("nome"));
				resultado.setCpf(rs.getString("cpf"));
				resultado.setEmail(rs.getString("email"));
				resultado.setEndereco(rs.getString("endereço"));
				resultado.setTelefone(rs.getInt("telefone"));
				
			}

			stmt.close();
			rs.close();

			return resultado;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return null;
		}

	}

}
