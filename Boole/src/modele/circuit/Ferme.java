package modele.circuit;

import modele.Circuit;
import modele.Composant;

public class Ferme extends Circuit {

	public Ferme(Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);

		}
	}

}
