package modele.composant.transformateur;

import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Non extends Transformateur {

	@Override
	protected boolean calcul() {

		return false;
	}

	public Non(String nom) {
		super(nom);
		this.InList.put(new Entree(0, this), false);
		this.OutList.add(new Sortie(0, this));
	}

}
