package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;


public class DAOCurso{

	private Connection conexao;

	public DAOCurso(Connection conexao){
		this.conexao = conexao;
	}

	public boolean adiciona(Curso c){

		String sql = "insert into curso(idCurso, nome, creditoTotal)"
				+ "values(?, ?, ?)";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, c.getIdCurso());
			stmt.setString(2, c.getNome());
			stmt.setInt(3, c.getCreditoTotal());

			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}
	}

	public boolean remove(int id){

		String sql = "delete from curso where id = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}
	}

	public boolean atualiza(Curso c){

		String sql = "update curso set nome = ?, creditoTotal = ? where id = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getCreditoTotal());
			stmt.setInt(3, c.getIdCurso());


			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}	
	}

	public List<Curso> lista(){

		String sql = "select * from disciplina";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Curso> resultado = new ArrayList<Curso>();

			while(rs.next()){

				Curso c= new Curso();
				c.setIdCurso(rs.getInt("idCurso"));
				c.setCreditoTotal(rs.getInt("creditoTotal"));
				c.setNome(rs.getString("nome"));
				
				resultado.add(c);
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

	public Curso buscaPorId(int id) {

		String sql = "select * from curso where id = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			Curso resultado = new Curso();

			while(rs.next()){

				resultado.setIdCurso(rs.getInt("idCurso"));
				resultado.setCreditoTotal(rs.getInt("creditoTotal"));
				resultado.setNome(rs.getString("nome"));
				
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
