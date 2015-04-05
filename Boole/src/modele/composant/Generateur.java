package modele.composant;

import java.util.LinkedHashSet;

import exception.EndException;
import modele.Composant;
import modele.port.Sortie;

public abstract class Generateur extends Composant implements _Generateur {

	protected LinkedHashSet<Sortie> OutList;

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

	public LinkedHashSet<Sortie> getOutList() {
<<<<<<< HEAD
		return new LinkedHashSet<Sortie>(OutList);

=======
		return OutList;
>>>>>>> branch 'master' of https://github.com/pierrickBrun/Boole.git
	}

}
