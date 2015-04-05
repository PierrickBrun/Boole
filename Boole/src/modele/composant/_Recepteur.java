package modele.composant;

import java.util.Map;

import exception.EndException;
import exception.StateException;
import modele.Port;
import modele._Composant;
import modele.port.Entree;

public interface _Recepteur extends _Composant {

	public Map<Port, Boolean> getInList();

	public void modified(Entree entree);

	public void tryTraitement() throws EndException, StateException;
}
