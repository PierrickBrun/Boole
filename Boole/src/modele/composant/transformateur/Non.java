package modele.composant.transformateur;

import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Non extends Transformateur {

	@Override
	protected boolean calcul() {

		return false;
	}

	public Non() {
		this.InList.add(new Entree(0, this));
		this.OutList.add(new Sortie(0, this));
	}

}
