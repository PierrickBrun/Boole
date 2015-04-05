package modele.circuit;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import exception.EndException;
import exception.StateException;
import modele.Composant;
import modele.port.Hermaphrodite;
import modele._Composant;
import modele.composant._Generateur;
import modele.composant._Recepteur;
import modele.port.Entree;
import modele.port.Sortie;
import modele.port._Entree;

public class Composite extends Ouvert implements _Composant {

	/**
	 * 
	 * il faut préciser pour chaque composant l'index du port à utiliser pour le lier
	 * 
	 * @param premiers LinkedHashMap<Entry<Composant, Integer>, Entry<Composant, Integer>>
	 * @param derniers LinkedHashMap<Entry<Composant, Integer>, Entry<Composant, Integer>>
	 */
	public Composite(
			LinkedHashMap<Entry<Composant, Integer>, Entry<Composant, Integer>> premiers,
			LinkedHashMap<Entry<Composant, Integer>, Entry<Composant, Integer>> derniers) {
		super(new LinkedHashSet<Composant>(), new LinkedHashSet<Composant>());

		for (Entry<Entry<Composant, Integer>, Entry<Composant, Integer>> entry : premiers
				.entrySet()) {
			Hermaphrodite herma = new Hermaphrodite(0);
			connexionHermaphrodite(entry.getKey().getKey(), entry.getValue()
					.getKey(), entry.getValue().getValue(), entry.getKey()
					.getValue(), herma);
			this.inList.put((Entree) (_Entree) herma, new Boolean(false));
		}

		for (Entry<Entry<Composant, Integer>, Entry<Composant, Integer>> entry : derniers
				.entrySet()) {
			Hermaphrodite herma = new Hermaphrodite(0);
			connexionHermaphrodite(entry.getValue().getKey(), entry.getKey()
					.getKey(), entry.getKey().getValue(), entry.getValue()
					.getValue(), herma);
			this.outList.add(herma);
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
	public void connexionHermaphrodite(Composant Emet, Composant Recoit,
			int indexSortie, int indexEntree, Hermaphrodite herma) {
		for (Sortie s : ((_Generateur) Emet).getOutList()) {
			if (s.getNum() == indexSortie) {
				for (Entry<Entree, Boolean> e : ((_Recepteur) Recoit)
						.getInList().entrySet()) {
					if (e.getKey().getNum() == indexEntree) {
						s.getRecepteurs().add((Entree) (_Entree) herma);
						herma.getRecepteurs().add(e.getKey());
					}
				}
			}
		}
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
