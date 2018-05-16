package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;


public class DAOProfessor {

	private Connection conexao;

	public DAOProfessor(Connection conexao){
		this.conexao = conexao;
	}

	public boolean adiciona(Professor p){

		String sql = "insert into professor(nome, cpf, email, endereço, telefone, matricula, graduacao)"
				+ "values(?, ?, ?,?, ?, ?, ?)";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getEmail());
			stmt.setString(4, p.getEndereco());
			stmt.setInt(5, p.getTelefone());
			stmt.setInt(5, p.getMatricula());
			stmt.setString(6, p.getGraduacao());

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

		String sql = "delete from professor where matricula = ?";

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

	public boolean atualiza(Professor p){

		String sql = "update professor set nome = ?, cpf = ?, email = ?, endereço = ?, telefone = ?, graduacao = ? where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getEmail());
			stmt.setString(4, p.getEndereco());
			stmt.setInt(5, p.getTelefone());
			stmt.setString(6, p.getGraduacao());
			stmt.setInt(7, p.getMatricula());


			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}	
	}

	public List<Professor> lista(){

		String sql = "select * from professor";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Professor> resultado = new ArrayList<Professor>();

			while(rs.next()){

				Professor p= new Professor();
				p.setMatricula(rs.getInt("matricula"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				p.setEndereco(rs.getString("endereço"));
				p.setTelefone(rs.getInt("telefone"));
				p.setGraduacao(rs.getString("graduacao"));

				resultado.add(p);
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

	public Professor buscaPorMatricula(int matricula) {

		String sql = "select * from professor where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, matricula);

			ResultSet rs = stmt.executeQuery();

			Professor resultado = new Professor();

			while(rs.next()){

				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setNome(rs.getString("nome"));
				resultado.setCpf(rs.getString("cpf"));
				resultado.setEmail(rs.getString("email"));
				resultado.setEndereco(rs.getString("endereço"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setGraduacao(rs.getString("graduacao"));

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

