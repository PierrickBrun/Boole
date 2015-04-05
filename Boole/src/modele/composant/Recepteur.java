package modele.composant;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele.Port;
import modele.port.Entree;

public abstract class Recepteur extends Composant implements _Recepteur {

	protected LinkedHashMap<Port, Boolean> InList;

	public Recepteur(String nom) {
		super(nom);
		this.InList = new LinkedHashMap<Port, Boolean>();
	}

	public void tryTraitement() throws StateException, EndException {
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

	public LinkedHashMap<Port, Boolean> getInList() {
		return this.InList;
	}

}
