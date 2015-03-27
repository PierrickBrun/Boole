package modele.composant;

import java.util.LinkedHashSet;
import java.util.Set;

import exception.EndException;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Transformateur extends Generateur implements _Recepteur {

	protected Set<Entree> InList;

	public Set<Entree> getInList() {
		return InList;
	}

	public Transformateur(){
		super();
		this.InList = new LinkedHashSet<Entree>();
	}

	@Override
	public void traitement() throws EndException {
		boolean result = this.calcul();
		for (Sortie s : this.getOutList())
			s.setEtat(result);
	}


}
