package model;

import java.util.Date;
import java.util.List;

public class Turma {
	private Professor professor;
	private List<Aluno> Aluno;
	private Disciplina disciplina;
	private Date horario;
	private int duracao;
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAluno() {
		return Aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		Aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	

}
