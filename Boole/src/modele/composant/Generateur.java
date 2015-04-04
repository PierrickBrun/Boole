package modele.composant;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.EndException;
import modele.Composant;
import modele.port.Sortie;

public abstract class Generateur extends Composant implements _Generateur {

	protected Set<Sortie> OutList;

	public void tryTraitement() throws EndException {
		traitement();
	}

	@Override
	public void traitement() throws EndException {
		boolean result = this.calcul();
		for (Sortie s : this.getOutList())
			s.setEtat(result);
	}

	protected abstract boolean calcul();

	public Generateur() {
		this.OutList = new LinkedHashSet<Sortie>();
	}

	public Set<Sortie> getOutList() {
		return new LinkedHashSet<Sortie>(OutList);
	}

}
