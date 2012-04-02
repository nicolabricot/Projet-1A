package inc;

public class Functions
{
	/**
	 * Permet d'afficher un boolean sous forme d'entier
	 */
	public int boolToInt(boolean bool) {
		if (bool)
			return 1;
		return 0;
	}
	
	/**
	 * Permet d'afficher un boolean sous forme de texte
	 */
	public String boolToString(boolean bool) {
		if (bool)
			return "1";
		return "0";
	}
}
