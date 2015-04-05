package modele.port;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.EndException;
import modele.Composant;
import modele.Port;

public class Sortie extends Port {

	protected Set<Port> recepteurs;

	public Set<Port> getRecepteurs() {
		return recepteurs;
	}

	public void setRecepteurs(Set<Port> recepteurs) {
		this.recepteurs = recepteurs;
	}

	public Sortie(int num, Composant c) {
		super(num, c);
		this.recepteurs = new LinkedHashSet<Port>();
	}

	public void setEtat(boolean e) throws EndException {
		this.etat = e;
		this.propagation();
	}

	public void propagation() throws EndException {
		throw new EndException(this);
	}
}
