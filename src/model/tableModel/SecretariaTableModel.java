package model.tableModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Secretaria;


	@SuppressWarnings("serial")
	public class SecretariaTableModel extends AbstractTableModel{
		
		private List< Secretaria> secretarias;
		private String[] colunas = {"Nome", "CPF", "E-mail", "Endereço", "Telefone","Matricula"};
		
		public SecretariaTableModel(List< Secretaria> secretarias) {
			this.secretarias = secretarias;
		}

		@Override
		public int getColumnCount() {
			return colunas.length;
		}
		
		@Override
		public int getRowCount() {
			return secretarias.size();
		}
		
		@Override
		public Object getValueAt(int indiceLinha, int indiceColuna) {
			
			switch(indiceColuna){
			
				case 0:
					return secretarias.get(indiceLinha).getNome();
					
				case 1:
					return secretarias.get(indiceLinha).getCpf();
					
				case 2:
					return secretarias.get(indiceLinha).getEmail();
					
				case 3:
					return secretarias.get(indiceLinha).getEndereco();
					
				case 4:
					return secretarias.get(indiceLinha).getTelefone();
					
				case 5:
					return secretarias.get(indiceLinha).getMatricula();
					
			}
			
			return null;
			
		}
		
		@Override
		public String getColumnName(int indiceColuna) {
			
			return colunas[indiceColuna];
			
		}
		
		public int getAlunoIndex(Secretaria secretariaSelecionada) {
			
			int indice = 0;
			
			for(Secretaria s : secretarias) {
				if(s.getMatricula() == secretariaSelecionada.getMatricula()) {
					return indice;
				}
				indice++;	
			}
			
			return -1;
			
		}
		
		public void atualizaLista(List<Secretaria> listaAtualizada) {
			
			
			this.secretarias = listaAtualizada;
			
			
			int ultimoIndice = getRowCount() - 1;

			
			fireTableRowsInserted(ultimoIndice, ultimoIndice);
		}
		
		public void atualizaSecretaria(int indiceLinha, Secretaria s) {
			
			
			secretarias.set(indiceLinha, s);
			
			
			fireTableRowsUpdated(indiceLinha, indiceLinha);
			
		}
		
		public void removeSecretaria(int indiceLinha) {

			
			secretarias.remove(indiceLinha);

			
			fireTableRowsDeleted(indiceLinha, indiceLinha);

		}


	}



