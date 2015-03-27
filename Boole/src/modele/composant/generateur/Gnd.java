package modele.composant.generateur;

import modele.composant.Generateur;
import modele.port.Sortie;

public final class Gnd extends Generateur {

	@Override
	protected boolean calcul() {
		return false;
	}

	public Gnd() {
		this.OutList.add(new Sortie(0, this));
	}

}
