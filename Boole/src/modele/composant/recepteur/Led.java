package modele.composant.recepteur;

import exception.StateException;
import modele.composant.Recepteur;
import modele.port.Entree;

public final class Led extends Recepteur {

	public Led(String nom) {
		super(nom);
		this.InList.put(new Entree(0, this), false);
	}

	public void traitement() throws StateException {
		if (this.InList.keySet().iterator().next().getEtat() == true) {
			throw new StateException("La led est allum�e");
		} else {
			throw new StateException("La led est �teinte");
		}

	}

}
