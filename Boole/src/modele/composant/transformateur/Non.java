package modele.composant.transformateur;

import modele.Port;
import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public final class Non extends Transformateur {

	@Override
	/*Dafuck ?*/
	protected boolean calcul() {
		for (Port entree : InList.keySet()) {
			if (entree.getEtat() == true) {
				return false;
			}
		}
		return true;
	}
	

	public Non(String nom) {
		super(nom);
		this.InList.put(new Entree(0, this), false);
		this.OutList.add(new Sortie(0, this));
	}

}
