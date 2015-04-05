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

<<<<<<< HEAD
	// un des deux ï¿½ supprimer
	protected Set<Composant> premiers = new HashSet<Composant>();
    protected String nom;
    protected boolean NomEntre = false;
    
	public Circuit(String nom, Composant... composants) {
		for (Composant composant : composants) {
			this.premiers.add(composant);
		}
		this.nom = nom;
	}
	
	protected String nom = "000";
	protected String nom = "000";
	public Circuit(String nom){
		this.nom = nom;
	}
	
	public Circuit(){
		
	}
	
	public void setNom(String nom){
		if(NomEntre == false){
		  this.nom = nom;
		  NomEntre = true;
		}
	}
	
   public void ajoutComposant(Composant c){
	   this.premiers.add(c);
   }
	
	
=======
	protected LinkedHashSet<Composant> premiers = new LinkedHashSet<Composant>();

	protected String nom = "000";
>>>>>>> branch 'master' of https://github.com/pierrickBrun/Boole.git

	/**
	 * Connecte deux composants. La sortie IndexSortie du composant Emet est
	 * connectee l 'entre IndexEntree du composant Recoit
	 * 
	 * @param Emet
	 * @param Recoit
	 * @param indexSortie
	 * @param indexEntree
	 */
	public void connexion(Composant Emet, Composant Recoit, int indexSortie,
			int indexEntree) {
		for (Sortie s : ((_Generateur) Emet).getOutList()) {
			if (s.getNum() == indexSortie) {
				for (Entry<Entree, Boolean> e : ((_Recepteur) Recoit)
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
