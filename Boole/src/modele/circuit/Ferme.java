package modele.circuit;

import modele.Circuit;
import modele.Composant;

public class Ferme extends Circuit {

<<<<<<< HEAD
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
=======
	public Ferme(Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);

>>>>>>> branch 'master' of https://github.com/pierrickBrun/Boole.git
		}
	}

}
