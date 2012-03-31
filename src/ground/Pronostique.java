package ground;

import inc.Functions;

public class Pronostique
{
	private boolean locale;
	private boolean matchNul;
	private boolean visitor;
	
	public Pronostique() {
		this.locale = false;
		this.matchNul = false;
		this.visitor = false;
	}
	public Pronostique(boolean locale, boolean matchNul, boolean visitor) {
		this.locale = locale;
		this.matchNul = matchNul;
		this.visitor = visitor;
	}
	
	public boolean[] getPronostique() {
		boolean[] resultat = new boolean[3];
		resultat[0] = this.locale;
		resultat[1] = this.matchNul;
		resultat[2] = this.visitor;
		return resultat;
	}
	public void setPronostique(boolean locale, boolean matchNul, boolean visitor) {
		this.locale = locale;
		this.matchNul = matchNul;
		this.visitor = visitor;
	}
	
	public String toString() {
		Functions f = new Functions();
		return "[" + f.boolToString(this.locale) + ", " + f.boolToString(this.matchNul) + ", " + f.boolToString(this.visitor) + "]";
	}
}