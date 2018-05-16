package model.ComboBoxModel;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Secretaria;


@SuppressWarnings("serial")
public class SecretariaComboBoxModel extends AbstractListModel<Secretaria> implements ComboBoxModel<Secretaria> {
	
	List<Secretaria> secretarias;
	Secretaria secretariaSelecionada;
	
	public SecretariaComboBoxModel(List<Secretaria> secretarias) {
		this.secretarias = secretarias;
		//System.out.println(this.hospedes.toString());
		if (!this.secretarias.isEmpty()) {
			secretariaSelecionada = secretarias.get(0);
		}
	}

	@Override
	public Secretaria getElementAt(int indice) {
		return secretarias.get(indice);
	}

	@Override
	public int getSize() {
		return secretarias.size();
	}

	@Override
	public Object getSelectedItem() {
		
		return secretariaSelecionada;
		
	}

	@Override
	public void setSelectedItem(Object hospede) {
		
		secretariaSelecionada = (Secretaria) secretarias;
		
	}
	
	public void atualizaLista(List<Secretaria> listaAtualizada) {
		
		this.secretarias = listaAtualizada;
		
		int ultimoIndice = getSize() - 1;
		
		fireIntervalAdded(this, ultimoIndice, ultimoIndice);
		
	}
	
	public void atualizaSecretaria(int indice, Secretaria s) {
		
		secretarias.set(indice, s);
		
		fireContentsChanged(this, indice, indice);
		
	}
	
	public void removeSecretaria(int indice) {

		secretarias.remove(indice);
		
		fireIntervalRemoved(this, indice, indice);

	}

}
