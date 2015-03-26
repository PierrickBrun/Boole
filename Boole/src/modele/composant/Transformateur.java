package modele.composant;

import java.util.Set;

import modele.port.Entree;

public abstract class Transformateur extends Generateur implements _Recepteur {

	protected Set<Entree> InList;

	public Set<Entree> getInList() {
		return InList;
	}

	public void setInList(Set<Entree> inList) {
		InList = inList;
	}

	@Override
	public void traitement() {
		boolean result = this.calcul();
		this.getOutList().forEach(Sortie -> Sortie.setEtat(result));
	}

	protected abstract boolean calcul();

}
