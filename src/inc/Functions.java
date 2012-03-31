package inc;

public class Functions
{
	/**
	 * Permet d'afficher un boolean sous forme plus agréable
	 */
	public int boolToInt(boolean bool) {
		if(bool)
			return 1;
		return 0;
	}
	public String boolToString(boolean bool) {
		if(bool)
			return "1";
		return "0";
	}
}
