package modele;

import exception.EndException;
import exception.StartException;

public abstract class Port {

	protected boolean etat = false;

	public boolean getEtat() {
		return etat;
	}

	protected Composant composant;

	public Composant getComposant() {
		return composant;
	}

	protected int num;

	public int getNum() {
		return num;
	}

	public Port(int num, Composant c) {
		this.num = num;
		this.composant = c;
	}

	/**
	 * change l'état du port et propage le changement
	 * 
	 * @param e
	 * @throws EndException
	 * @throws StartException
	 */
	public abstract void setEtat(boolean e) throws EndException, StartException;

}
