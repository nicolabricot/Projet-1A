package view;

import inc.Functions;
import ground.Grille;
import ground.Pronostique;
import process.*;
import java.util.Scanner;

public class Console
{
	private boolean works;
	private Scanner scan;
	/* **
	 * A REMETTRE A PRIVATE !!
	 */
	public Grille grille;
	/* **
	 * 
	 */
	private Traitement traitement;
	/*int i = 0;*/
	
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
	 * Permet de mettre à jour un pronostique
	 */
	private void setPronostique() {
		Functions f = new Functions();
		System.out.println("\nIndiquer le n° du match (0 pour annuler)");
		prompt();
		int match =  f.stringToInt(fetch());
		if (match == 0) System.out.println("Abandon");
		else if (match != -1) {
			System.out.println("\n"+grille.getMatch(match-1));
			boolean weiter = false;
			int prono[] = new int[3];
			while (!weiter) {
				System.out.println("Équipe locale (0 défaite, 1 victoire) ?");
				prompt();
				prono[0] = f.stringToInt(fetch());
				if (prono[0] != -1 && prono[0] <= 1) weiter = true;
			}
			weiter = false;
			while (!weiter) {
				System.out.println("Match nul (0 faux, 1 vrai) ?");
				prompt();
				prono[1] = f.stringToInt(fetch());
				if (prono[1] != -1 && prono[1] <= 1) weiter = true;
			}
			weiter = false;
			while (!weiter) {
				System.out.println("Équipe visiteur (0 défaite, 1 victoire) ?");
				prompt();
				prono[2] = f.stringToInt(fetch());
				if (prono[2] != -1 && prono[2] <= 1) weiter = true;
			}
			grille.setPronostique(match, new Pronostique(prono[0], prono[1], prono[2]));
		}
		else System.out.println("Aucun match ne correspond !");
	}
	
	/**
	 * S'occupe de traiter la grille
	 */
	private void traitement() {
		/* On vérifie que la grille est remplie */
		if(grille.getNbZero() != 0)
			System.out.println("\nAu moins un des matchs a tous ses pronostiques nuls !");
		/* s'il n'y a que des simples */
		else if (grille.getNbSimple() == grille.getNbMatchs())
			System.out.println("\nWah, trop facile ;)");
		/* on vérifie qu'on est bien dans les cas que l'on peut traiter */
		/* tout va bien, on peut lancer le traitement */
		else {
			traitement = new TraitementSimple();
			traitement.traite(grille);
		}
	}
	
	/**
	 * Récupère ce qui est tapé en console
	 * @return
	 */
	private String fetch() {
		return scan.next();
	}
	
	/**
	 * Exécute la commande tapé en console 
	 * @param cmd
	 */
	private void decode(String cmd) {
		if (cmd.contentEquals("q") || cmd.contentEquals("Q")) quit();
		else if (cmd.contentEquals("g") || cmd.contentEquals("G")) grille.affiche();
		else if (cmd.contentEquals("p") || cmd.contentEquals("P")) setPronostique();
		else if (cmd.contentEquals("t") || cmd.contentEquals("T")) traitement();
	}
	
	/**
	 * Affiche le menu
	 */
	private void afficheMenu() {
		System.out.println("");
		//System.out.println("m > afficher Menu");
		System.out.println("g > afficher Grille");
		System.out.println("p > modifier Pronostique");
		System.out.println("t > Traiter la grille");
		System.out.println("q > Quitter");
	}
	
	/**
	 * Affiche le prompt pour demander entrée clavier
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
		System.out.println("");
		System.out.println("------------------------");
		System.out.println("    (c) 2012  Ensisa   ");
		
	}
}
