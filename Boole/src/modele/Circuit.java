package modele;

import java.util.LinkedHashSet;
import java.util.Map.Entry;

import exception.EndException;
import exception.StartException;
import exception.StateException;
import modele.circuit.Composite;
import modele.composant.Recepteur;
import modele.composant.Generateur;
import modele.composant._Recepteur;
import modele.port.Entree;
import modele.port.Hermaphrodite;
import modele.port.Sortie;

public abstract class Circuit implements _Circuit {

	protected LinkedHashSet<Composant> premiers = new LinkedHashSet<Composant>();

	protected String nom = "000";

	/**
	 * Connecte deux composants. La sortie IndexSortie du composant Emet est
	 * connectee l 'entre IndexEntree du composant Recoit
	 * 
	 * @param ajout
	 * @param precedent
	 * @param indexSortie
	 * @param indexEntree
	 */
	public void connexion(Composant emet, Composant recoit, int indexSortie,
			int indexEntree) {
		if (emet instanceof Generateur) {
			for (Port sortie : ((Generateur) emet).getOutList()) {
				if (sortie.getNum() == indexSortie) {
					if (recoit instanceof Recepteur) {
						for (Entry<Port, Boolean> e : ((Recepteur) recoit)
								.getInList().entrySet()) {
							if (e.getKey().getNum() == indexEntree) {
								((Sortie) sortie).getRecepteurs().add(
										e.getKey());
							}
						}
					} else if (recoit instanceof Composite) {
						for (Entry<Port, Boolean> e : ((Composite) recoit)
								.getInList().entrySet()) {
							if (e.getKey().getNum() == indexEntree) {
								((Sortie) sortie).getRecepteurs().add(
										e.getKey());
							}
						}
					}
				}
			}
		} else if (emet instanceof Composite) {
			for (Port sortie : ((Composite) emet).getOutList()) {
				if (sortie.getNum() == indexSortie) {
					if (recoit instanceof Recepteur) {
						for (Entry<Port, Boolean> e : ((Recepteur) recoit)
								.getInList().entrySet()) {
							if (e.getKey().getNum() == indexEntree) {
								((Sortie) sortie).getRecepteurs().add(
										e.getKey());
							}
						}
					} else if (recoit instanceof Composite) {
						for (Entry<Port, Boolean> e : ((Composite) recoit)
								.getInList().entrySet()) {
							if (e.getKey().getNum() == indexEntree) {
								((Sortie) sortie).getRecepteurs().add(
										e.getKey());
							}
						}
					}
				}
			}
		}
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
	 * 
	 * traite récursivement chaque Composant du circuit
	 * 
	 * @param c
	 * @throws StateException
	 */
	public void traitement(Composant c) throws StateException {
		try {
			c.tryTraitement();
		} catch (EndException ee) {
			for (Port entree : ee.getSortie().getRecepteurs()) {
				propagation(entree, ee.getSortie().getEtat());
			}
		}
	}

	public void propagation(Port entree, boolean etat) throws StateException {
		try {
			if (entree instanceof Entree) {
				((Entree) entree).setEtat(etat);
			} else if (entree instanceof Hermaphrodite) {
				((Hermaphrodite) entree).setEtat(etat);
			}
		} catch (StartException se) {
			((_Recepteur) se.getEntree().getComposant()).modified(se
					.getEntree());
			traitement(se.getEntree().getComposant());
		} catch (EndException ee) {
			for (Port entree2 : ee.getSortie().getRecepteurs()) {
				propagation(entree2, ee.getSortie().getEtat());
			}
		}
	}
}
