package exception;

import modele.port.Entree;

@SuppressWarnings("serial")
public class StartException extends Exception {

	private Entree entree;

	public StartException(Entree e) {
		this.setEntree(e);
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

}
