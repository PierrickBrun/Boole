
package modele;

public abstract class Composant implements _Composant {

	protected String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Composant() {
		this.nom = "000";
	}

}
