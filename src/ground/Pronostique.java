package ground;

import inc.Functions;

public class Pronostique
{
	private boolean locale;
	private boolean matchNul;
	private boolean visitor;
	private Functions f = new Functions();

	/**
	 * On instancie le pronostique par default = aucun
	 */
	public Pronostique() {
		this.locale = false;
		this.matchNul = false;
		this.visitor = false;
	}
	/**
	 * On instancie le pronostique en donnant les choix booleans
	 * @param locale
	 * @param matchNul
	 * @param visitor
	 */
	public Pronostique(boolean locale, boolean matchNul, boolean visitor) {
		this.locale = locale;
		this.matchNul = matchNul;
		this.visitor = visitor;
	}
	/**
	 * On instancie le pronostique en donnant des entiers
	 */
	public Pronostique(int locale, int matchNul, int visitor) {
		this.locale = f.intToBool(locale);
		this.matchNul = f.intToBool(matchNul);
		this.visitor = f.intToBool(visitor);
	}

	/**
	 * Retourn le pronostique (sous forme de tableau a 3 cases)
	 */
	public boolean[] getPronostique() {
		boolean[] resultat = new boolean[3];
		resultat[0] = this.locale;
		resultat[1] = this.matchNul;
		resultat[2] = this.visitor;
		return resultat;
	}
	/**
	 * On modifie le pronostique en donnant les choix sous forme de boolean
	 * @param locale
	 * @param matchNul
	 * @param visitor
	 */
	public void setPronostique(boolean locale, boolean matchNul, boolean visitor) {
		this.locale = locale;
		this.matchNul = matchNul;
		this.visitor = visitor;
	}
	/**
	 * On modifie le pronostique en donnant les choix sous forme d'entiers
	 * @param locale
	 * @param matchNul
	 * @param visitor
	 */
	public void setPronostique(int locale, int matchNul, int visitor) {
		this.locale = f.intToBool(locale);
		this.matchNul = f.intToBool(matchNul);
		this.visitor = f.intToBool(visitor);
	}
	
	@Override
	public String toString() {
		return "[" + f.boolToString(this.locale) + ", "
				+ f.boolToString(this.matchNul) + ", "
				+ f.boolToString(this.visitor) + "]";
	}
}