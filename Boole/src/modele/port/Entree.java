package modele.port;

import modele.Port;

public class Entree extends Port implements _Entree {

	protected Sortie emetteur;

	public Sortie getEmetteur() {
		return new Sortie(emetteur);
	}

	public void setEmetteur(Sortie emetteur) {
		this.emetteur = emetteur;
	}

	public void setEtat(boolean e) {
		this.etat = e;
	}

}
