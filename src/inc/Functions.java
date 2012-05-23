package inc;

public class Functions
{
	/**
	 * Permet d'afficher un boolean sous forme d'entier
	 */
	public int boolToInt(boolean bool) {
		if (bool) return 1;
		return 0;
	}
	
	/**
	 * Permet d'afficher un entier sous forme de boolean
	 */
	public boolean intToBool(int nb) {
		if (nb == 1) return true;
		return false;
	}
	
	/**
	 * Permet d'afficher un boolean sous forme de texte
	 */
	public String boolToString(boolean bool) {
		if (bool) return "1";
		return "0";
	}
	
	public int stringToInt(String text) {
		if (text.contentEquals("1")) return 1;
		else if (text.contentEquals("2")) return 2;
		else if (text.contentEquals("3")) return 3;
		else if (text.contentEquals("4")) return 4;
		else if (text.contentEquals("5")) return 5;
		/*
		else if (text.contentEquals("6")) return 6;
		else if (text.contentEquals("7")) return 7;
		else if (text.contentEquals("8")) return 8;
		else if (text.contentEquals("9")) return 9;
		else if (text.contentEquals("10")) return 10;
		*/
		else if (text.contentEquals("0")) return 0;
		return -1;
	}
}
