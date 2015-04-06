package controleur;

import modele.circuit.Composite;
import modele.*;
import modele.circuit.Ferme;
import modele.composant.recepteur.*;
import modele.composant.transformateur.*;
import modele.composant.generateur.*;
import modele.parser.ParseException;

public class test {

	public static void main(String args[]) throws ParseException {
		
		/*Xor = (!A.B)+(A.!B)*/
		
		
		Gnd gnd = new Gnd("000");
		Vcc vcc = new Vcc("001");
		
		Ou ou = new Ou("002");
		Non non = new Non("003");
		Non non1 = new Non("004");
		Et et = new Et("005");
		Et et1 = new Et("006");
		Led led = new Led("007");
		Composite xor = new Composite("004",non,non1,et,et1,ou);
		
		xor.connexionHermaphrodite(vcc, non, 0, 0);
		xor.connexionHermaphrodite(gnd,et,0,0);
		xor.connexionHermaphrodite(vcc, et1, 0, 0);
		xor.connexionHermaphrodite(gnd,non1,0,0);
		xor.connexionHermaphrodite(ou,led,0,0);
		xor.connexion(non,et,0,1);
		xor.connexion(non1,et1,0,1);
		xor.connexion(et,ou,0,0);
		xor.connexion(et1,ou,0,1);
		
		
		/*xor.connexionHermaphrodite(gnd, ou, 0, 0);
		xor.connexionHermaphrodite(gnd, ou, 0, 1);
		xor.connexion(ou, non, 0, 0);
		xor.connexionHermaphrodite(non, led, 0, 0);*/
		Ferme ferme = new Ferme(gnd,vcc,(Composant) xor);
		ferme.connexion(xor, led, 0, 0);
		ferme.traitement();

	}
}
