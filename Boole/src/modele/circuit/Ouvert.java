package modele.circuit;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import modele.Circuit;
import modele.Composant;
import modele.Port;
import modele.composant.Transformateur;

public class Ouvert extends Circuit {

	protected LinkedHashMap<Port, Boolean> inList = new LinkedHashMap<Port, Boolean>();
	protected LinkedHashSet<Port> outList = new LinkedHashSet<Port>();

	public Ouvert(Set<Composant> premiers, Set<Composant> derniers) {
		this.premiers = (LinkedHashSet<Composant>) premiers;
		for (Composant composant : premiers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Port entree : ((Transformateur) composant).getInList()
						.keySet()) {
					inList.put(entree, new Boolean(null));
				}
			}
		}
		for (Composant composant : derniers) {
			if (composant instanceof Transformateur) {
				composant = (Transformateur) composant;
				for (Port sortie : ((Transformateur) composant).getOutList()) {
					outList.add(sortie);
				}
			}
		}
	}

	public Ouvert(LinkedHashMap<Port, Boolean> inList,
			LinkedHashSet<Port> outList) {
		this.inList = inList;
		this.outList = outList;
	}

}
