package modele.circuit;

import java.util.Set;

import modele.Circuit;
import modele.Composant;
import modele.Port;

public class Ouvert extends Circuit {

	public Ouvert(Composant composant) {
		super(composant);
	}

	protected Set<Port> Entrees;
	protected Set<Port> Sorties;

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

	}

}
