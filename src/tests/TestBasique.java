package tests;

import ground.*;

public class TestBasique
{
	public static void main(String[] args) {
		Grille g = new Grille();
		// System.out.println(g);
		g.setPronostique(1, new Pronostique(true, false, false));
		g.setPronostique(2, new Pronostique(false, true, false));
		g.setPronostique(3, new Pronostique(false, true, true));
		g.setPronostique(4, new Pronostique(true, true, true));
		g.setPronostique(5, new Pronostique(true, false,false));
		g.setPronostique(6, new Pronostique(false, true,false));
		g.setPronostique(7, new Pronostique(true, false,false));
		g.affiche();
		System.out.println("");
		
		System.out.println(g.getMatch(2));
		
		System.out.println("");
		System.out.println("nb of zero : " + g.getNbZero());
		System.out.println("nb of simple : " + g.getNbSimple());
		System.out.println("nb of double : " + g.getNbDouble());
		System.out.println("nb of triple : " + g.getNbTriple());
		
		
		System.out.println("");
		System.out.println(g.getZero());
		System.out.println("");
		int[] simples = g.getSimple();
		for (int i = 0; i < g.getNbSimple(); i++)
			System.out.println(simples[i]);
		System.out.println("");
		for (int i = 0; i < g.getNbDouble(); i++)
			System.out.println(g.getDouble()[i]);
		System.out.println("");
		for (int i = 0; i < g.getNbTriple(); i++)
			System.out.println(g.getTriple()[i]);
		
	}
}
