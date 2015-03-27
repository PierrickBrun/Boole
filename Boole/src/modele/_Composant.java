package modele;

import exception.EndException;
import exception.StateException;

public interface _Composant {

	public void traitement() throws EndException, StateException;

	public void tryTraitement() throws EndException, StateException;

}
