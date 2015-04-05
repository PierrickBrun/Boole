package modele.composant.transformateur;

import modele.Port;
import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Ou extends Transformateur {

	@Override
	protected boolean calcul() {
		for (Port entree : InList.keySet()) {
			if (entree.getEtat() == true) {
				return true;
			}
		}
		return false;
	}

	public Ou(String nom) {
		super(nom);
		this.InList.put(new Entree(0, this), false);
		this.InList.put(new Entree(1, this), false);
		this.OutList.add(new Sortie(0, this));
	}

}
