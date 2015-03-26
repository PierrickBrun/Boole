package modele.composant;

import java.util.Set;

import modele.Composant;
import modele.port.Sortie;

public abstract class Generateur extends Composant {

	protected Set<Sortie> OutList;

	@Override
	public void traitement() {
		boolean result = this.calcul();
		this.getOutList().forEach(Sortie -> Sortie.setEtat(result));
	}

	protected abstract boolean calcul();

	public Set<Sortie> getOutList() {
		return OutList;
	}

	public void setOutList(Set<Sortie> outList) {
		OutList = outList;
	}

}
