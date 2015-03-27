package controleur;

import modele.circuit.Ferme;
import modele.composant.recepteur.*;
import modele.composant.generateur.*;
import modele.parser.ParseException;

public class test {

	public static void main(String args[]) throws ParseException {
		Gnd vcc = new Gnd();
		Led led = new Led();
		Ferme c = new Ferme(vcc);
		c.connexion(led, vcc, 0, 0);
		c.traitement();
	}

}
