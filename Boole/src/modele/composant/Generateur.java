package modele.composant;

import java.util.LinkedHashSet;

import exception.EndException;
import modele.Composant;
import modele.Port;
import modele.port.Sortie;

public abstract class Generateur extends Composant implements _Generateur {

	protected LinkedHashSet<Port> OutList;

	public void tryTraitement() throws EndException {
		traitement();
	}

	@Override
	public void traitement() throws EndException {
		boolean result = this.calcul();
		for (Port port : this.getOutList())
			((Sortie) port).setEtat(result);
	}

	protected abstract boolean calcul();

	public Generateur(String nom) {
		super(nom);
		this.OutList = new LinkedHashSet<Port>();
	}

	public LinkedHashSet<Port> getOutList() {
		return OutList;
	}

}
