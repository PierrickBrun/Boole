package controleur;

import modele.circuit.Composite;
import modele.circuit.Ferme;
import modele.composant.recepteur.*;
import modele.composant.transformateur.*;
import modele.composant.generateur.*;
import modele.parser.ParseException;

public class test {

	public static void main(String args[]) throws ParseException {
		Gnd gnd = new Gnd("000");
		Vcc vcc = new Vcc("001");
		Ou ou = new Ou("002");
		Non non = new Non("003");
		Led led = new Led("005");
		Composite xor = new Composite("004", ou);
		xor.connexionHermaphrodite(gnd, ou, 0, 0);
		xor.connexionHermaphrodite(gnd, ou, 0, 1);
		xor.connexion(ou, non, 0, 0);
		xor.connexionHermaphrodite(non, led, 0, 0);
		Ferme ferme = new Ferme(gnd,vcc);
		ferme.connexion(xor, led, 0, 0);
		ferme.traitement();

	}
}
