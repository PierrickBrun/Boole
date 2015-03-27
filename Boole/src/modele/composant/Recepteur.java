package modele.composant;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.StateException;
import modele.Composant;
import modele.port.Entree;

public abstract class Recepteur extends Composant implements _Recepteur {

	protected Set<Entree> InList;

	public Recepteur() {
		this.InList = new LinkedHashSet<Entree>();
	}

	@Override
	public void traitement() throws StateException {
		// TODO Auto-generated method stub
	}

	public Set<Entree> getInList() {
		return this.InList;
	}

}
