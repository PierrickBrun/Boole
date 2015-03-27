package modele;

import java.util.HashSet;
import java.util.Set;

import modele.composant._Generateur;
import modele.composant._Recepteur;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Circuit implements _Circuit {

	// un des deux à supprimer
	protected Set<Composant> premiers = new HashSet<Composant>();

	public Circuit(Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);
		}
	}

	/**
	 * Ajoute un composant à la suite d'un autre en liant une entree à une
	 * sortie
	 * 
	 * @param ajout
	 * @param precedent
	 * @param indexSortie
	 * @param indexEntree
	 */
	public void connexion(Composant ajout, Composant precedent,
			int indexSortie, int indexEntree) {
		for (Sortie s : ((_Generateur) precedent).getOutList()) {
			if (s.getNum() == indexSortie) {
				for (Entree e : ((_Recepteur) ajout).getInList()) {
					if (e.getNum() == indexEntree) {
						s.getRecepteurs().add(e);
					}
				}
			}
		}
	}
}
