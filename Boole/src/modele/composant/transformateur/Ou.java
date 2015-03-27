package modele.composant.transformateur;

import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

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

	public Ou() {
		this.InList.add(new Entree(0, this));
		this.InList.add(new Entree(1, this));
		this.OutList.add(new Sortie(0, this));
	}

}
