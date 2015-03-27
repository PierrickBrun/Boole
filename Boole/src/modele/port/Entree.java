package modele.port;

import exception.StartException;
import modele.Composant;
import modele.Port;

public class Entree extends Port implements _Entree {

	public Entree(int num, Composant c) {
		super(num, c);
		// TODO Auto-generated constructor stub
	}

	protected Sortie emetteur;

	public Sortie getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Sortie emetteur) {
		this.emetteur = emetteur;
	}

	public void setEtat(boolean e) throws StartException {
		this.etat = e;
		this.propagation();
	}

	public void propagation() throws StartException {
		throw new StartException(this);
	}

}
