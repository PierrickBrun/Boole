package modele.port;

import modele.Composant;

public class Hermaphrodite extends Sortie implements _Entree {

	public Hermaphrodite(int num, Composant c) {
		super(num, c);
	}

	protected Sortie emetteur;

	public Sortie getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Sortie emetteur) {
		this.emetteur = emetteur;
	}

}
