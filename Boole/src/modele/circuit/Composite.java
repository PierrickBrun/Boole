package modele.circuit;

import java.util.LinkedHashSet;
import java.util.Map.Entry;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele._Composant;
import modele.port.Entree;

public class Composite extends Ouvert implements _Composant {

	public Composite(LinkedHashSet<Composant> premiers,
			LinkedHashSet<Composant> derniers) {
		super(premiers, derniers);
	}

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		/*
		 * Composite c = new Composite(); _Composant c2 = c; Composant c3 =
		 * (Composant)c2;
		 */
	}

	@Override
	public void tryTraitement() throws EndException, StateException {
		for (Entry<Entree, Boolean> entry : this.inList.entrySet()) {
			if (entry.getValue().booleanValue() == false) {
				return;
			}
		}
		traitement();
	}

}
