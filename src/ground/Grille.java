package ground;

public class Grille
{
	private Match[] matchs = new Match[4];
	
	public Grille(String nameLocal, String nameVisitor) {
		this.matchs[0] = new Match(nameLocal, nameVisitor);
	}
	
	public Match[] getGrille() {
		return this.matchs;
	}
	
	
	
}
