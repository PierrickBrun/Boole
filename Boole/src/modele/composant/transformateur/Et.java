package modele.composant.transformateur;

import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Et extends Transformateur {

	public Et() {
		Entree e0 = new Entree();
		Entree e1 = new Entree();
		Sortie s0 = new Sortie();
	}

	@Override
	protected boolean calcul() {
		for (Entree entree : InList) {
			if (entree.getEtat() == false) {
				return false;
			}
		}
		return true;
	}

}
