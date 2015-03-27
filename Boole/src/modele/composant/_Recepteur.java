package modele.composant;

import java.util.List;
import java.util.Set;

import modele._Composant;
import modele.port.Entree;

public interface _Recepteur extends _Composant {

	public Set<Entree> getInList();

}
