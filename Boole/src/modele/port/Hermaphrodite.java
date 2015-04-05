package modele.port;


public class Hermaphrodite extends Sortie implements _Entree {

	public Hermaphrodite(int num) {
		super(num, null);
	}

	protected Sortie emetteur;

	public Sortie getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Sortie emetteur) {
		this.emetteur = emetteur;
	}

}
