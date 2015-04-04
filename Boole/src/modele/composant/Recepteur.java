package modele.composant;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele.port.Entree;

public abstract class Recepteur extends Composant implements _Recepteur {

	protected LinkedHashMap<Entree, Boolean> InList;

	public Recepteur() {
		this.InList = new LinkedHashMap<Entree, Boolean>();
	}

	public void tryTraitement() throws StateException, EndException {
		for (Entry<Entree, Boolean> entry : this.InList.entrySet()) {
			if (entry.getValue().booleanValue() == false) {
				return;
			}
		}
		traitement();
	}

	public void modified(Entree e) {
		for (Entry<Entree, Boolean> entry : this.InList.entrySet()) {
			if (entry.getKey().equals(e)) {
				entry.setValue(new Boolean(true));
				return;
			}
		}
	}

	public LinkedHashMap<Entree, Boolean> getInList() {
		return this.InList;
	}

}
