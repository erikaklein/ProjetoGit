package model.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Professor;


@SuppressWarnings("serial")
public class ProfessorTableModel extends AbstractTableModel{
	
	private List<Professor> professores;
	private String[] colunas = {"Nome", "CPF", "E-mail", "Endereço", "Telefone","Matricula", "Graduacao"};
	
	public ProfessorTableModel(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public int getRowCount() {
		return professores.size();
	}
	
	@Override
	public Object getValueAt(int indiceLinha, int indiceColuna) {
		
		switch(indiceColuna){
		
			case 0:
				return professores.get(indiceLinha).getNome();
				
			case 1:
				return professores.get(indiceLinha).getCpf();
				
			case 2:
				return professores.get(indiceLinha).getEmail();
				
			case 3:
				return professores.get(indiceLinha).getEndereco();
				
			case 4:
				return professores.get(indiceLinha).getTelefone();
				
			case 5:
				return professores.get(indiceLinha).getMatricula();
				
			case 6:
				return professores.get(indiceLinha).getGraduacao();
				
		}
		
		return null;
		
	}
	
	@Override
	public String getColumnName(int indiceColuna) {
		
		return colunas[indiceColuna];
		
	}
	
	public int getProfessorIndex(Professor professorSelecionado) {
		
		int indice = 0;
		
		for(Professor p : professores) {
			if(p.getMatricula() == professorSelecionado.getMatricula()) {
				return indice;
			}
			indice++;	
		}
		
		return -1;
		
	}
	
	public void atualizaLista(List<Professor> listaAtualizada) {
		
		
		this.professores = listaAtualizada;
		
		
		int ultimoIndice = getRowCount() - 1;

		
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void atualizaProfessor(int indiceLinha,Professor p) {
		
		
		professores.set(indiceLinha, p);
		
		
		fireTableRowsUpdated(indiceLinha, indiceLinha);
		
	}
	
	public void removeProfessor(int indiceLinha) {

		
		professores.remove(indiceLinha);

		
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}


}
