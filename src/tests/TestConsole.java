package tests;

import ground.Pronostique;
import view.Console;

public class TestConsole
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console c = new Console();
		
		c.grille.setPronostique(1, new Pronostique(1, 1, 1));
		c.grille.setPronostique(2, new Pronostique(1, 1, 1));
		c.grille.setPronostique(3, new Pronostique(1, 1, 1));
		c.grille.setPronostique(4, new Pronostique(1, 0, 0));
		c.grille.setPronostique(5, new Pronostique(1, 0, 0));
		c.grille.setPronostique(6, new Pronostique(1, 0, 0));
		c.grille.setPronostique(7, new Pronostique(1, 0, 0));
		
		c.play();

	}

}
