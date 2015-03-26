package modele.composant.transformateur;

import modele.composant.Transformateur;
import modele.port.Entree;

public final class Ou extends Transformateur {

	@Override
	protected boolean calcul() {
		for (Entree entree : InList) {
			if (entree.getEtat() == true) {
				return true;
			}
		}
		return false;
	}

}
