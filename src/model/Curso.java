package model;

public class Curso {
	
	private int idCurso;
	private String nome;
	private int creditoTotal;
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCreditoTotal() {
		return creditoTotal;
	}
	public void setCreditoTotal(int creditoTotal) {
		this.creditoTotal = creditoTotal;
	}
	
}