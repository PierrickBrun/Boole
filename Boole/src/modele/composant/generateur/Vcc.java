package modele.composant.generateur;

import modele.composant.Generateur;
import modele.port.Sortie;

public final class Vcc extends Generateur {

	@Override
	protected boolean calcul() {
		return true;
	}

	public Vcc() {
		this.OutList.add(new Sortie(0, this));
	}

}
