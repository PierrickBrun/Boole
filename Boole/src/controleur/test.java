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
		Et et = new Et();
		Ou ou = new Ou();
		Non not = new Non();
		Non not1 = new Non();
		Led led = new Led();
<<<<<<< HEAD
		Ferme c = new Ferme("Test",vcc,gnd,not,et,not1,ou,led);
		c.connexion(vcc, et, 0, 1);
		c.connexion(vcc,ou,0,1);
		c.connexion(gnd,not, 0, 0);
		c.connexion(not,et,0,0);
		c.connexion(et,not1, 0, 0);
		c.connexion(not1,ou,0,0);
		c.connexion(ou,led,0,0);
=======
		Ferme c = new Ferme(vcc, gnd);
		c.connexion(vcc, ou, 0, 0);
		c.connexion(gnd, ou, 0, 1);
		c.connexion(ou, led, 0, 0);
>>>>>>> branch 'master' of https://github.com/pierrickBrun/Boole.git
		c.traitement();
	}

}
