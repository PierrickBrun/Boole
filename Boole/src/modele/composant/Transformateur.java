package modele.composant;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.EndException;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Transformateur extends Generateur implements _Recepteur {

	protected LinkedHashMap<Entree, Boolean> InList;

	public LinkedHashMap<Entree, Boolean> getInList() {
		return InList;
	}

	public Transformateur() {
		super();
		this.InList = new LinkedHashMap<Entree, Boolean>();
	}

	@Override
	public void traitement() throws EndException {
		boolean result = this.calcul();
		for (Sortie s : this.getOutList())
			s.setEtat(result);
	}

	public void tryTraitement() throws EndException {
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

}
