package controller;

import java.util.List;

import dao.DAODisciplina;
import model.Disciplina;

public class ControllerDisciplina {
	
	public boolean cadastrarDisciplina(Disciplina disciplina){
		return false;
		
	}
	
	public boolean atualizarDisciplina(Disciplina disciplina){
		return false;
		
	}
	
	public boolean excluirDisciplina(Disciplina disciplina){
		return false;
		
	}
	
	public List<Disciplina> listarDisciplina(){
		
		List<Disciplina> listaDisciplina = new DAODisciplina().readTodasDisciplinas();
		
		for (int i = 0; i < listaDisciplina.size(); i++) {
			listarDisciplina().get(i).getNome();
		}
		
		return listaDisciplina;
		
	}
}
