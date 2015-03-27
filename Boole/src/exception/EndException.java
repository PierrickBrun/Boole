package exception;

import modele.port.Sortie;

@SuppressWarnings("serial")
public class EndException extends Exception {

	private Sortie sortie;

	public EndException(Sortie s) {
		this.setSortie(s);
	}

	public Sortie getSortie() {
		return sortie;
	}

	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}

}
