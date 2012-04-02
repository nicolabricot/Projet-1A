package ground;

public class Grille
{
	private int nbMatchs = 5;
	private Match[] matchs = new Match[this.nbMatchs];
	private String[] equipes = { "Reims", "Mulhouse", "Auxerre", "Dijon",
			"Paris", "Marseille", "Rouen", "Bordeaux", "Brest", "Grenoble" };

	/**
	 * On instancie une nouvelle grille avec les matchs (non aléatoires pour
	 * l'instant)
	 */
	public Grille() {
		for (int i=0; i < this.nbMatchs; i++)
			this.matchs[i] = new Match(this.equipes[2 * i],this.equipes[2 * i + 1]);
	}

	/*
	 * public Match[] getGrille() { return this.matchs; }
	 */

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
	 * Permet d'afficher proprement une grille numérotée des matchs et des
	 * pronostiques
	 */
	@Override
	public String toString() {
		String resultat = "N°\tLocale <> Visiteur\t[Gagne, Nul, Perd]\n";
		for (int i = 0; i < this.nbMatchs; i++)
			resultat += (i + 1) + ".\t" + this.matchs[i] + "\n";
		return resultat;
	}
}
