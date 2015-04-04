package modele.circuit;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele._Composant;

public class Composite extends Ouvert implements _Composant {

	public Composite(String nom,Composant composant) {
		super(nom, composant);
	}

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		/*
		 * Composite c = new Composite(); _Composant c2 = c; Composant c3 =
		 * (Composant)c2;
		 */
		
		/*
		 * Idealement : Renvoie la valeur de la sortie du dernier composant.
		 * Du coup y pas mal de trucs qu'on été mal pensés -.\
		 * */
	}

	@Override
	public void tryTraitement() throws EndException, StateException {
		// TODO Auto-generated method stub

	}

}
