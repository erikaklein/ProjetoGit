package controller;

import model.Aluno;
import model.comboBoxModel.HospedeBoxModel;
import dao.DAOAluno;
import model.tableModel.AlunoTableModel;

public class ControllerAluno {
	
	DAOAluno dao;
	AlunoTableModel tableModel;
	AlunoBoxModel boxModel;
	
	public ControllerAluno(AlunoTableModel tableModel, AlunoBoxModel boxModel,DAOAluno dao) {
		this.dao = dao;
		this.tableModel = tableModel;
		this.boxModel = boxModel;
	}
	
	public Object obtemCelula(int linha, int coluna) {
		return tableModel.getValueAt(linha, coluna);
	}
	
	public boolean removeAluno(int linha) {
		
		//Captura o id do hospede
		int matricula = (int) tableModel.getValueAt(linha, 0);
		
		//Remove o hospede das listas
		tableModel.removeAluno(linha);
		boxModel.removeAluno(linha);
		
		//Executa a operação no banco retornando o sucesso ou falha
		return dao.remove(matricula);
		
	}
	
	public boolean atualizaAluno(int linha, String nome, String cpf, String email) {
		
		int id = (int) tableModel.getValueAt(linha, 0);
		
		Hospede h = new Hospede(id, nome, cpf, email);
		
		tableModel.atualizaHospede(linha, h);
		boxModel.atualizaHospede(linha, h);
		
		return dao.atualiza(h);
		
	}
	
	public boolean novoHospede(String nome, String cpf, String email) {
		
		//Instancia um novo hóspede com os dados fornecidos na view
		Hospede h = new Hospede(nome, cpf, email);
		
		
		//Solicita a persistência do hospede e armazena o retorno
		boolean retorno = dao.adiciona(h);
		
		//Verifica se o hospede foi adicionado com sucesso
		if(retorno) {
			//Invoca os métodos do tableModel e boxModel responsáveis 
			//por atualizar a tabela e a combobox
			tableModel.atualizaLista(dao.lista());
			boxModel.atualizaLista(dao.lista());
			
			//Retorna para a view o sucesso da operação
			return retorno;
		} else {
			
			//Retorna para a view a falha na operação
			return false;
		}
		
	}

}
