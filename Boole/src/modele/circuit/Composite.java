package modele.circuit;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import exception.EndException;
import exception.StartException;
import exception.StateException;
import modele.Composant;
import modele.Port;
import modele.port.Entree;
import modele.port.Hermaphrodite;
import modele._Composant;
import modele.composant.Recepteur;
import modele.composant._Generateur;
import modele.composant._Recepteur;
import modele.port.Sortie;

public class Composite extends Composant implements _Ouvert {

	private LinkedHashSet<Composant> premiers = new LinkedHashSet<Composant>();
	private LinkedHashMap<Port, Boolean> inList = new LinkedHashMap<Port, Boolean>();
	private LinkedHashSet<Port> outList = new LinkedHashSet<Port>();

	/**
	 * 
	 * @param nom
	 */
	public Composite(String nom, Composant... composants) {
		super(nom);
		for (Composant composant : composants) {
			this.premiers.add(composant);
		}
	}

	/**
	 * Connecte deux composants. La sortie IndexSortie du composant Emet est
	 * connectee l 'entre IndexEntree du composant Recoit Un port hermaphrodite
	 * est entre les deux
	 * 
	 * @param ajout
	 * @param precedent
	 * @param indexSortie
	 * @param indexEntree
	 */
	public void connexionHermaphrodite(Composant emet, Composant recoit,
			int indexSortie, int indexEntree) {
		for (Port sortie : ((_Generateur) emet).getOutList()) {
			if (sortie.getNum() == indexSortie) {
				for (Entry<Port, Boolean> entry : ((_Recepteur) recoit)
						.getInList().entrySet()) {
					if (entry.getKey().getNum() == indexEntree) {
						Hermaphrodite herma = new Hermaphrodite(0);
						((Sortie) sortie).getRecepteurs().add(herma);
						herma.getRecepteurs().add(entry.getKey());
						if (premiers.contains(recoit)) {
							this.inList.put(herma, new Boolean(false));
						} else {
							this.outList.add(herma);
						}
					}
				}
			}
		}
	}

	@Override
	public void tryTraitement() throws EndException, StateException {
		for (Entry<Port, Boolean> entry : this.inList.entrySet()) {
			if (entry.getValue().booleanValue() == false) {
				return;
			}
		}
		traitement();
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

	public void traitement(Composant c) throws StateException {
		try {
			c.tryTraitement();
		} catch (EndException ee) {
			for (Port entree : ee.getSortie().getRecepteurs()) {
				try {
					((Entree) entree).setEtat(ee.getSortie().getEtat());
				} catch (StartException se) {
					((_Recepteur) se.getEntree().getComposant()).modified(se
							.getEntree());
					traitement(se.getEntree().getComposant());
				}
			}
		}
	}

	public void connexion(Composant Emet, Composant Recoit, int indexSortie,
			int indexEntree) {
		for (Port sortie : ((_Generateur) Emet).getOutList()) {
			if (sortie.getNum() == indexSortie) {
				for (Entry<Port, Boolean> e : ((_Recepteur) Recoit).getInList()
						.entrySet()) {
					if (e.getKey().getNum() == indexEntree) {
						((Sortie) sortie).getRecepteurs().add(e.getKey());
					}
				}
			}
		}
	}

	public LinkedHashMap<Port, Boolean> getInList() {
		return inList;
	}

	public LinkedHashSet<Port> getOutList() {
		return outList;
	}

}
