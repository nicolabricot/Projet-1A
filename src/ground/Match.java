package ground;

public class Match
{
	private Equipe locale;
	private Equipe visitor;
	private Pronostique pronostique;

	/**
	 * On instancie un match avec les 2 equipes et on ajoute un pronostique default (= vide)
	 * @param nameLocal
	 * @param nameVisitor
	 */
	public Match(String nameLocal, String nameVisitor) {
		this.locale = new Equipe(nameLocal);
		this.visitor = new Equipe(nameVisitor);
		this.pronostique = new Pronostique();
	}

	/*
	 * public Equipe[] getMatch() { Equipe[] resultat = new Equipe[2];
	 * resultat[0] = this.locale; resultat[1] = this.visitor; return resultat; }
	 * public void setMatch(String nameLocal, String nameVisitor) {
	 * this.locale.setName(nameLocal); this.visitor.setName(nameVisitor); }
	 */

	/**
	 * Retourne le pronostique
	 */
	public Pronostique getPronostique() {
		return this.pronostique;
	}
	/**
	 * Modifie le pronostique.
	 * @param locale
	 * @param matchNul
	 * @param visitor
	 */
	public void setPronostique(boolean locale, boolean matchNul, boolean visitor) {
		this.pronostique.setPronostique(locale, matchNul, visitor);
	}
	
	public String[] getNameEquipe() {
		String retour[] = new String[2];
		retour[0] = locale.getName();
		retour[1] = visitor.getName();
		return retour;
	}

	@Override
	public String toString() {
		return this.locale + " <> " + this.visitor + "\t" + this.pronostique;
	}
	/**
	 * Affiche du match (alias de toString()
	 */
	public String affiche() {
		return this.locale + " <> " + this.visitor + "\t" + this.pronostique;
	}
}
