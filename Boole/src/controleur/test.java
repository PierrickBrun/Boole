package controleur;

import modele.circuit.Ferme;
import modele.composant.recepteur.*;
import modele.composant.transformateur.*;
import modele.composant.generateur.*;
import modele.parser.ParseException;

public class test {

	public static void main(String args[]) throws ParseException {
		Gnd gnd = new Gnd();
		Vcc vcc = new Vcc();
		Ou ou = new Ou();
		Led led = new Led();
		Ferme c = new Ferme(vcc, gnd);
		c.connexion(ou, vcc, 0, 0);
		c.connexion(ou, gnd, 0, 1);
		c.connexion(led, ou, 0, 0);
		c.traitement();
	}

}
