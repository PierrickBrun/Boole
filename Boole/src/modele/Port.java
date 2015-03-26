package modele;

public abstract class Port {

	protected boolean etat;

	public boolean getEtat() {
		return etat;
	}

	/**
	 * change l'état du port et propage le changement
	 * 
	 * @param e
	 */
	public abstract void setEtat(boolean e);

}
