package controller;

import model.Secretaria;
import model.ComboBoxModel.SecretariaComboBoxModel;
import dao.DAOSecretaria;
import model.tableModel.SecretariaTableModel;

public class ControllerSecretaria{
	
	DAOSecretaria dao;
	SecretariaTableModel tableModel;
	SecretariaComboBoxModel ComboBoxModel;
	
	public ControllerSecretaria(SecretariaTableModel tableModel,SecretariaComboBoxModel ComboBoxModel, DAOSecretaria dao) {
		this.dao = dao;
		this.tableModel = tableModel;
		this.ComboBoxModel = ComboBoxModel;
	}
	
	public Object obtemCelula(int linha, int coluna) {
		return tableModel.getValueAt(linha, coluna);
	}
	
	public boolean removeSecretaria(int linha) {
		
		
		int matricula = (int) tableModel.getValueAt(linha, 0);
		
		
		tableModel.removeSecretaria(linha);
		ComboBoxModel.removeSecretaria(linha);
		
		
		return dao.remove(matricula);
		
	}
	
	public boolean atualizaSecretaria(int linha, String nome, String cpf, String email, String endereco, String telefone) {
		
		int matricula= (int) tableModel.getValueAt(linha, 0);
		
		Secretaria s = new Secretaria (matricula, nome, cpf, email, endereco, telefone);
		
		tableModel.atualizaSecretaria(linha, s);
		ComboBoxModel.atualizaSecretaria(linha, s);
		
		return dao.atualiza(s);
		
	}
	
	public boolean novoSecretaria(String nome, String cpf, String email,  String endereco, String telefone) {
		
		
		Secretaria s = new Secretaria(0, nome, cpf, email, endereco, telefone);
		
		
		
		boolean retorno = dao.adiciona(s);
		
		if(retorno) {
			
			tableModel.atualizaLista(dao.lista());
			ComboBoxModel.atualizaLista(dao.lista());
			
				return retorno;
		} else {
			
		
			return false;
		}
		
	}

}
