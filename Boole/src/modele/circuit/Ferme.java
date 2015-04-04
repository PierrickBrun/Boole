package modele.circuit;

import java.util.LinkedHashSet;

import modele.Circuit;
import modele.Composant;

public class Ferme extends Circuit {

	public Ferme(Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);
		}
	}

	public Ferme(LinkedHashSet<Composant> composants) {
		this.premiers = composants;
	}

}
