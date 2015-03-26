package modele.port;

public class Hermaphrodite extends Sortie implements _Entree {

	public Hermaphrodite(Sortie s) {
		super(s);
	}

	protected Sortie emetteur;

	public Sortie getEmetteur() {
		return new Sortie(emetteur);
	}

	public void setEmetteur(Sortie emetteur) {
		this.emetteur = emetteur;
	}

}
