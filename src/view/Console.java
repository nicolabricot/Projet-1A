package view;

import inc.Functions;
import ground.Grille;
import ground.Pronostique;
import java.util.Scanner;

public class Console
{
	private boolean works;
	private Scanner scan;
	private Grille grille;
	int i = 0;
	
	public Console() {
		works = true;
		scan = new Scanner(System.in);
		grille = new Grille();
	}
	
	/**
	 * Permet de quitter et de dire au revoir
	 */
	private void quit() {
		works = false;
		System.out.println("\nBye bye... !");
	}
	
	/**
	 * Permet de mettre ˆ jour un pronostique
	 */
	private void setPronostique() {
		Functions f = new Functions();
		System.out.println("\nIndiquer le n¡ du match (0 pour annuler)");
		prompt();
		int match =  f.stringToInt(fetch());
		if (match == 0) System.out.println("Abandon");
		else if (match != -1) {
			System.out.println("\n"+grille.getMatch(match-1));
			boolean weiter = false;
			int prono[] = new int[3];
			while (!weiter) {
				System.out.println("ƒquipe locale (0 dŽfaite, 1 victoire) ?");
				prompt();
				prono[0] = f.stringToInt(fetch());
				if (prono[0] != -1) weiter = true;
			}
			weiter = false;
			while (!weiter) {
				System.out.println("Match nul (0 faux, 1 vrai) ?");
				prompt();
				prono[1] = f.stringToInt(fetch());
				if (prono[1] != -1) weiter = true;
			}
			weiter = false;
			while (!weiter) {
				System.out.println("ƒquipe visiteur (0 dŽfaite, 1 victoire) ?");
				prompt();
				prono[2] = f.stringToInt(fetch());
				if (prono[2] != -1) weiter = true;
			}
			grille.setPronostique(match, new Pronostique(prono[0], prono[1], prono[2]));
		}
		else System.out.println("Aucun match ne correspond !");
	}
	
	/**
	 * RŽcupre ce qui est tapŽ en console
	 * @return
	 */
	private String fetch() {
		return scan.next();
	}
	
	/**
	 * ExŽcute la commande tapŽ en console 
	 * @param cmd
	 */
	private void decode(String cmd) {
		if (cmd.contentEquals("q")) quit();
		else if (cmd.contentEquals("g")) grille.affiche();
		else if (cmd.contentEquals("p")) setPronostique();
	}
	
	/**
	 * Affiche le menu
	 */
	private void afficheMenu() {
		System.out.println("");
		//System.out.println("m > afficher Menu");
		System.out.println("g > afficher Grille");
		System.out.println("p > modifier Pronostique");
		System.out.println("q > Quitter");
	}
	
	/**
	 * Affiche code -> pour demander entrŽe clavier
	 */
	private void prompt() {
		System.out.print("-> ");
	}
	
	/**
	 * Lance le programme d'affichage console
	 */
	public void play() {
		System.out.println("#----------------------#");
		System.out.println("|      EnsiStats       |");
		System.out.println("#----------------------#");
		while(works) {
			this.afficheMenu();
			prompt();
			decode(fetch());
		}
		
	}
}
