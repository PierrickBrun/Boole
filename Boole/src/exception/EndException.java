package exception;

import modele.port.Sortie;

@SuppressWarnings("serial")
public class EndException extends Exception {

	private Sortie sortie;

	public EndException(Sortie s) {
		this.sortie = s;
	}

	public Sortie getSortie() {
		return sortie;
	}

}
