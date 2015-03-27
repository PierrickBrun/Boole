package modele.circuit;

import exception.EndException;
import exception.StartException;
import exception.StateException;
import modele.Circuit;
import modele.Composant;
import modele.port.Entree;

public class Ferme extends Circuit {

	public Ferme(Composant composant) {
		super(composant);
	}

	@Override
	public void traitement() {
		for (Composant c : this.premiers) {
			try {
				traitement(c);
			} catch (StateException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * traite récursivement chaque Composant du circuit
	 * 
	 * @param c
	 * @throws StateException
	 */
	private void traitement(Composant c) throws StateException {
		try {
			c.traitement();
		} catch (EndException ee) {
			for (Entree entree : ee.getSortie().getRecepteurs()) {
				try {
					entree.setEtat(ee.getSortie().getEtat());
				} catch (StartException se) {
					traitement(se.getEntree().getComposant());
				}
			}
		}
	}
}
