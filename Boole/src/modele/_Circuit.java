package modele;

import exception.StateException;

public interface _Circuit {

	public void traitement();

	public void connexion(Composant Emet, Composant Recoit, int indexSortie,
			int indexEntree);

	public void traitement(Composant c) throws StateException;

}
