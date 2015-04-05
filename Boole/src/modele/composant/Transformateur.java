package modele.composant;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.EndException;
import modele.Port;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Transformateur extends Generateur implements _Recepteur {

	protected LinkedHashMap<Port, Boolean> InList;

	public LinkedHashMap<Port, Boolean> getInList() {
		return InList;
	}

	public Transformateur(String nom) {
		super(nom);
		this.InList = new LinkedHashMap<Port, Boolean>();
	}

	@Override
	public void traitement() throws EndException {
		boolean result = this.calcul();
		for (Port sortie : this.getOutList())
			((Sortie)sortie).setEtat(result);
	}

	public void tryTraitement() throws EndException {
		for (Entry<Port, Boolean> entry : this.InList.entrySet()) {
			if (entry.getValue().booleanValue() == false) {
				return;
			}
		}
		traitement();
	}

	public void modified(Entree e) {
		for (Entry<Port, Boolean> entry : this.InList.entrySet()) {
			if (entry.getKey().equals(e)) {
				entry.setValue(new Boolean(true));
				return;
			}
		}
	}

}
