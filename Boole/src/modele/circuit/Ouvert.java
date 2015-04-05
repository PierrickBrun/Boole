package modele.circuit;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import modele.Circuit;
import modele.Composant;
import modele.composant.Transformateur;
import modele.port.Entree;
import modele.port.Sortie;

public class Ouvert extends Circuit {

	protected LinkedHashMap<Entree, Boolean> inList = new LinkedHashMap<Entree, Boolean>();
	protected LinkedHashSet<Sortie> outList = new LinkedHashSet<Sortie>();

	public Ouvert(Set<Composant> premiers, Set<Composant> derniers) {
		this.premiers = (LinkedHashSet<Composant>) premiers;
		for (Composant composant : premiers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Entree entree : ((Transformateur) composant).getInList()
						.keySet()) {
					inList.put(entree, new Boolean(null));
				}
			}
		}
		for (Composant composant : derniers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Sortie sortie : ((Transformateur) composant).getOutList()) {
					outList.add(sortie);
				}
			}
		}
	}

	public Ouvert(LinkedHashMap<Entree, Boolean> inList,
			LinkedHashSet<Sortie> outList) {
		this.inList = inList;
		this.outList = outList;
	}

}
