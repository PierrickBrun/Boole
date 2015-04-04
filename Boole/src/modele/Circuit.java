package modele;

import java.util.LinkedHashSet;
import java.util.Map.Entry;

import exception.EndException;
import exception.StartException;
import exception.StateException;
import modele.composant._Generateur;
import modele.composant._Recepteur;
import modele.port.Entree;
import modele.port.Sortie;

public abstract class Circuit implements _Circuit {

	protected LinkedHashSet<Composant> premiers = new LinkedHashSet<Composant>();

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
				for (Entry<Entree, Boolean> e : ((_Recepteur) ajout)
						.getInList().entrySet()) {
					if (e.getKey().getNum() == indexEntree) {
						s.getRecepteurs().add(e.getKey());
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
	protected void traitement(Composant c) throws StateException {
		try {
			c.tryTraitement();
		} catch (EndException ee) {
			for (Entree entree : ee.getSortie().getRecepteurs()) {
				try {
					entree.setEtat(ee.getSortie().getEtat());
				} catch (StartException se) {
					((_Recepteur) se.getEntree().getComposant()).modified(se
							.getEntree());
					traitement(se.getEntree().getComposant());
				}
			}
		}
	}
}
