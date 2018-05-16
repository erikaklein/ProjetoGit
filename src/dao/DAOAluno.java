package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;


public class DAOAluno {

	private Connection conexao;

	public DAOAluno(Connection conexao){
		this.conexao = conexao;
	}

	public boolean adiciona(Aluno a){

		String sql = "insert into aluno(nome, cpf, email, endereço, telefone, matricula, idCurso)"
				+ "values(?, ?, ?,?, ?, ?, ?)";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getCpf());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getEndereco());
			stmt.setInt(5, a.getTelefone());
			stmt.setInt(5, a.getMatricula());
			stmt.setInt(6, a.getIdCurso());

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

		String sql = "delete from aluno where matricula = ?";

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

	public boolean atualiza(Aluno a){

		String sql = "update aluno set nome = ?, cpf = ?, email = ?, endereço = ?, telefone = ?, idCurso = ? where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getCpf());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getEndereco());
			stmt.setInt(5, a.getTelefone());
			stmt.setInt(6, a.getIdCurso());
			stmt.setInt(7, a.getMatricula());


			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}	
	}

	public List<Aluno> lista(){

		String sql = "select * from aluno";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Aluno> resultado = new ArrayList<Aluno>();

			while(rs.next()){

				Aluno a= new Aluno();
				a.setMatricula(rs.getInt("matricula"));
				a.setNome(rs.getString("nome"));
				a.setCpf(rs.getString("cpf"));
				a.setEmail(rs.getString("email"));
				a.setEndereco(rs.getString("endereço"));
				a.setTelefone(rs.getInt("telefone"));
				a.setIdCurso(rs.getInt("idCurso"));

				resultado.add(a);
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

	public Aluno buscaPorMatricula(int matricula) {

		String sql = "select * from aluno where matricula = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, matricula);

			ResultSet rs = stmt.executeQuery();

			Aluno resultado = new Aluno();

			while(rs.next()){

				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setNome(rs.getString("nome"));
				resultado.setCpf(rs.getString("cpf"));
				resultado.setEmail(rs.getString("email"));
				resultado.setEndereco(rs.getString("endereço"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setIdCurso(rs.getInt("idCurso"));

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
