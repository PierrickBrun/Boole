package modele.composant.recepteur;

import exception.StateException;
import modele.composant.Recepteur;
import modele.port.Entree;

public final class Led extends Recepteur {

	public Led() {
		this.InList.add(new Entree(0, this));
	}

	public void traitement() throws StateException {
		if (this.InList.iterator().next().getEtat() == true) {
			throw new StateException("La led est allumée");
		} else {
			throw new StateException("La led est éteinte");
		}

	}

}
