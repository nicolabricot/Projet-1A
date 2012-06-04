package ground;

public class Grille implements Cloneable
{
	private final int nbMatchs = 7;
	private Match[] matchs = new Match[this.nbMatchs];
	private String[] equipes = { "Montpellier", "FC Mulhouse", "Paris Saint Germain", "Arsenal", 
			"Olympique Marseille", "Sochaux", "Olympique Lyon", "FC Toulouse",  "Manchester United",
			"FC Chelsea", "FC Barcelone", "Inter Milan", "AS Rome", "Juventus de Turin", "Real Madrid",
			 "Bayer Munich", "Dortmund", "AC Milan" };
	private final double prixGrille = 1.0;

	/**
	 * On instancie une nouvelle grille avec les matchs (non aléatoires pour
	 * l'instant)
	 */
	public Grille() {
		for (int i=0; i < this.nbMatchs; i++)
			this.matchs[i] = new Match(this.equipes[2 * i],this.equipes[2 * i + 1]);
	}

	/**
	 * Retourne un match donné selon son numéro
	 * @return Match
	 */
	public Match getMatch(int i) {
		return matchs[i];
	}

	/**
	 * Permet d'ajouter les pronostiques.
	 * @param numeroMatch
	 * @param pronostique
	 */
	public void setPronostique(int numeroMatch, Pronostique pronostique) {
		this.matchs[numeroMatch - 1].setPronostique(
				pronostique.getPronostique()[0],
				pronostique.getPronostique()[1],
				pronostique.getPronostique()[2]);
	}
	
	/**
	 * Permet de récupérer lenombre de maths par grille
	 */
	public int getNbMatchs() {
		return nbMatchs;
	}
	
	/**
	 * Retourne le nombre de Zero dans la grille (match sans pronostique)
	 * @return
	 */
	public int getNbZero() {
		int retour = 0;
		for (int i = 0; i < nbMatchs; i++)
			if (matchs[i].getPronostique().getNumberOfProno() == 0)
				retour++;
		return retour;
	}
	/**
	 * Retourne le nombre de Simple dans la grille
	 * @return
	 */
	public int getNbSimple() {
		int retour = 0;
		for (int i = 0; i < nbMatchs; i++)
			if (matchs[i].getPronostique().getNumberOfProno() == 1)
				retour++;
		return retour;
	}
	/**
	 * Retourne le nombre de Double dans la grille
	 * @return
	 */
	public int getNbDouble() {
		int retour = 0;
		for (int i = 0; i < nbMatchs; i++)
			if (matchs[i].getPronostique().getNumberOfProno() == 2)
				retour++;
		return retour;
	}
	/**
	 * Retourne le nombre de Triple dans la grille
	 * @return
	 */
	public int getNbTriple() {
		int retour = 0;
		for (int i = 0; i < nbMatchs; i++)
			if (matchs[i].getPronostique().getNumberOfProno() == 3)
				retour++;
		return retour;
	}
	
	/**
	 * Retourne le numéro des matchs n'ayant pas de pronostique
	 * @return
	 */
	public int[] getZero() {
		if (getNbZero() == 0)
			return null;
		else {
			int[] match = new int[getNbZero()];
			int i = 0;
			for (int j = 0; j < nbMatchs; j++) {
				if (matchs[j].getPronostique().getNumberOfProno() == 0) {
					match[i] = j;
					i++;
				}
			}
			return match;
		}
	}
	/**
	 * Retourne le numéro des matchs Simples
	 * @return
	 */
	public int[] getSimple() {
		if (getNbSimple() == 0)
			return null;
		else {
			int[] match = new int[getNbSimple()];
			int i = 0;
			for (int j = 0; j < nbMatchs; j++) {
				if (matchs[j].getPronostique().getNumberOfProno() == 1) {
					match[i] = j;
					i++;
				}
			}
			return match;
		}
	}
	/**
	 * Retourne le numéro des matchs Doubles
	 * @return
	 */
	public int[] getDouble() {
		if (getNbDouble() == 0)
			return null;
		else {
			int[] match = new int[getNbDouble()];
			int i = 0;
			for (int j = 0; j < nbMatchs; j++) {
				if (matchs[j].getPronostique().getNumberOfProno() == 2) {
					match[i] = j;
					i++;
				}
			}
			return match;
		}
	}
	/**
	 * Retourne le numéro des matchs Triples
	 * @return
	 */
	public int[] getTriple() {
		if (getNbTriple() == 0)
			return null;
		else {
			int[] match = new int[getNbTriple()];
			int i = 0;
			for (int j = 0; j < nbMatchs; j++) {
				if (matchs[j].getPronostique().getNumberOfProno() == 3) {
					match[i] = j;
					i++;
				}
			}
			return match;
		}
	}
	
	/**
	 * Permet de connaitre le prix d'une grille
	 * @return
	 */
	public double getPrixGrille() {
		return prixGrille;
	}
	
	/**
	 * Permet d'afficher proprement une grille numérotée des matchs et des
	 * pronostiques
	 */
	@Override
	public String toString() {
		String resultat = "\nN°\tLocale <> Visiteur\t[Gagne, Nul, Perd]\n";
		for (int i = 1; i <= this.nbMatchs; i++) {
			resultat += i + ".\t" + this.matchs[i-1];
			if (i != this.nbMatchs) resultat += "\n";
		}
		return resultat;
	}
	
	/**
	 * Affiche une grille (alias de toString)
	 */
	public void affiche() {
		String resultat = "\nN°\tLocale <> Visiteur\t[Gagne, Nul, Perd]\n";
		for (int i = 1; i <= this.nbMatchs; i++) {
			resultat += i + ".\t" + this.matchs[i-1];
			if (i != this.nbMatchs) resultat += "\n";
		}
		System.out.println(resultat);
	}
}
