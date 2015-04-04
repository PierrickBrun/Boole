package modele;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import modele.composant._Generateur;
import modele.composant._Recepteur;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Circuit implements _Circuit {

	// un des deux � supprimer
	protected Set<Composant> premiers = new HashSet<Composant>();
    protected String nom;
	public Circuit(String nom, Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);
		}
		this.nom = nom;
	}
	

	
	

	/**
	 * Connecte deux composants.
	 * La sortie IndexSortie du composant Emet est connectee l 'entre IndexEntree du composant Recoit
	 * 
	 * @param ajout
	 * @param precedent
	 * @param indexSortie
	 * @param indexEntree
	 */
	public void connexion(Composant Emet, Composant Recoit,
			int indexSortie, int indexEntree) {
		for (Sortie s : ((_Generateur) Emet).getOutList()) {
			if (s.getNum() == indexSortie) {
				for (Entry<Entree, Boolean> e : ((_Recepteur)Recoit)
						.getInList().entrySet()) {
					if (e.getKey().getNum() == indexEntree) {
						s.getRecepteurs().add(e.getKey());
					}
				}
			}
		}
	}
}
