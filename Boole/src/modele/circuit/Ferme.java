package modele.circuit;

import modele.Circuit;
import modele.Composant;
import exception.*;

public class Ferme extends Circuit {


	public Ferme(String nom, Composant... composant) {
		super(nom, composant);
	}
	
	@Override
	public void traitement() {
		for (Composant c : this.premiers) {
			try {
				traitement(c);
			} catch (StateException e) {
				System.out.println(e);
				
			}
		}
	}

	public Ferme(Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);

		}
	}

}
