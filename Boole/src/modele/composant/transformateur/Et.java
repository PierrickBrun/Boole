package modele.composant.transformateur;

import java.util.Map.Entry;

import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Et extends Transformateur {

	public Et() {
		this.InList.put(new Entree(0, this), false);
		this.InList.put(new Entree(1, this), false);
		this.OutList.add(new Sortie(0, this));
	}

	@Override
	protected boolean calcul() {
		for (Entry<Entree, Boolean> entry : InList.entrySet()) {
			if (entry.getKey().getEtat() == false) {
				return false;
			}
		}
		return true;
	}

}
