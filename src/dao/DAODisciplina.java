package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Disciplina;


public class DAODisciplina{

	private Connection conexao;

	public DAODisciplina(Connection conexao){
		this.conexao = conexao;
	}

	public boolean adiciona(Disciplina d){

		String sql = "insert into disciplina(idDisciplina, credito, descricao, nome)"
				+ "values(?, ?, ?, ?)";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, d.getIdDisciplina());
			stmt.setInt(2, d.getCredito());
			stmt.setString(3, d.getDescricao());
			stmt.setString(4, d.getNome());
			

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

		String sql = "delete from disciplina where id = ?";

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

	public boolean atualiza(Disciplina d){

		String sql = "update disciplina set nome = ?, credito = ?, descricao = ? where id = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, d.getNome());
			stmt.setInt(2, d.getCredito());
			stmt.setString(3, d.getDescricao());
			stmt.setInt(4, d.getIdDisciplina());


			stmt.execute();

			stmt.close();

			return true;

		} catch (SQLException e) {

			System.out.println("Problemas com o comando SQL");
			e.printStackTrace();

			return false;
		}	
	}

	public List<Disciplina> lista(){

		String sql = "select * from disciplina";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Disciplina> resultado = new ArrayList<Disciplina>();

			while(rs.next()){

				Disciplina d= new Disciplina();
				d.setIdDisciplina(rs.getInt("idDisciplina"));
				d.setCredito(rs.getInt("credito"));
				d.setDescricao(rs.getString("descricao"));
				d.setNome(rs.getString("nome"));
				
				resultado.add(d);
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

	public Disciplina buscaPorId(int id) {

		String sql = "select * from disciplina where id = ?";

		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			Disciplina resultado = new Disciplina();

			while(rs.next()){

				resultado.setIdDisciplina(rs.getInt("idDisciplina"));
				resultado.setCredito(rs.getInt("credito"));
				resultado.setDescricao(rs.getString("descricao"));
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
