package model.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;


@SuppressWarnings("serial")
public class AlunoTableModel extends AbstractTableModel{
	
	private List<Aluno> alunos;
	private String[] colunas = {"Nome", "CPF", "E-mail", "Endereço", "Telefone","Matricula", "IdCurso"};
	
	public AlunoTableModel(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public int getRowCount() {
		return alunos.size();
	}
	
	@Override
	public Object getValueAt(int indiceLinha, int indiceColuna) {
		
		switch(indiceColuna){
		
			case 0:
				return alunos.get(indiceLinha).getNome();
				
			case 1:
				return alunos.get(indiceLinha).getCpf();
				
			case 2:
				return alunos.get(indiceLinha).getEmail();
				
			case 3:
				return alunos.get(indiceLinha).getEndereco();
				
			case 4:
				return alunos.get(indiceLinha).getTelefone();
				
			case 5:
				return alunos.get(indiceLinha).getMatricula();
				
			case 6:
				return alunos.get(indiceLinha).getIdCurso();
				
		}
		
		return null;
		
	}
	
	@Override
	public String getColumnName(int indiceColuna) {
		
		return colunas[indiceColuna];
		
	}
	
	public int getAlunoIndex(Aluno alunoSelecionado) {
		
		int indice = 0;
		
		for(Aluno a : alunos) {
			if(a.getMatricula() == alunoSelecionado.getMatricula()) {
				return indice;
			}
			indice++;	
		}
		
		return -1;
		
	}
	
	public void atualizaLista(List<Aluno> listaAtualizada) {
		
		
		this.alunos = listaAtualizada;
		
		
		int ultimoIndice = getRowCount() - 1;

		
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void atualizaAluno(int indiceLinha, Aluno a) {
		
		
		alunos.set(indiceLinha, a);
		
		
		fireTableRowsUpdated(indiceLinha, indiceLinha);
		
	}
	
	public void removeAluno(int indiceLinha) {

		
		alunos.remove(indiceLinha);

		
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}


}
