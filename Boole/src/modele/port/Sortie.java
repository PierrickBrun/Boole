package modele.port;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.EndException;
import modele.Composant;
import modele.Port;

public class Sortie extends Port {

	protected Set<Entree> recepteurs;

	public Set<Entree> getRecepteurs() {
		return recepteurs;
	}

	public void setRecepteurs(Set<Entree> recepteurs) {
		this.recepteurs = recepteurs;
	}

	public Sortie(int num, Composant c) {
		super(num, c);
		this.recepteurs = new LinkedHashSet<Entree>();
	}

	public void setEtat(boolean e) throws EndException {
		this.etat = e;
		this.propagation();
	}

	public void propagation() throws EndException {
		throw new EndException(this);
	}
}
