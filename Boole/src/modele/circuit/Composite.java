package modele.circuit;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele._Composant;

public class Composite extends Ouvert implements _Composant {

	public Composite(Composant composant) {
		super(composant);
	}

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		/*
		 * Composite c = new Composite(); _Composant c2 = c; Composant c3 =
		 * (Composant)c2;
		 */
	}

	@Override
	public void tryTraitement() throws EndException, StateException {
		// TODO Auto-generated method stub

	}

}
