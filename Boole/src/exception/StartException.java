package exception;

import modele.port.Entree;

@SuppressWarnings("serial")
public class StartException extends Exception {

	private Entree entree;

	public StartException(Entree e) {
		this.entree = e;
	}

	public Entree getEntree() {
		return entree;
	}

}
