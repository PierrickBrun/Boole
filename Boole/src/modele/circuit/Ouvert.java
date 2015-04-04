package modele.circuit;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import modele.Circuit;
import modele.Composant;
import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public class Ouvert extends Circuit {

	protected List<Entree> Entrees = new LinkedList<Entree>();
	protected List<Sortie> Sorties = new LinkedList<Sortie>();

	public Ouvert(LinkedHashSet<Composant> premiers,
			LinkedHashSet<Composant> derniers) {
		this.premiers = premiers;
		for (Composant composant : premiers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Entree entree : ((Transformateur) composant).getInList()
						.keySet()) {
					Entrees.add(entree);
				}
			}
		}
		for (Composant composant : derniers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Sortie sortie : ((Transformateur) composant).getOutList()) {
					Sorties.add(sortie);
				}
			}
		}
	}

}
