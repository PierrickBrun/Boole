package modele.port;

import java.util.List;

import modele.Port;

public class Sortie extends Port {

	protected List<Entree> recepteurs;

	public List<Entree> getRecepteurs() {
		return recepteurs;
	}

	public void setRecepteurs(List<Entree> recepteurs) {
		this.recepteurs = recepteurs;
	}

	public Sortie(Sortie s) {
		this.setEtat(s.getEtat());
		this.setRecepteurs(s.getRecepteurs());
	}

	public Sortie() {
	}

	public void setEtat(boolean e) {
		this.etat = e;
		this.propagation();
	}

	public void propagation() {
		recepteurs.forEach((Entree) -> setEtat(this.getEtat()));
	}
}
