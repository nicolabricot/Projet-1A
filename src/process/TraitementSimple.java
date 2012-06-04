package process;

import ground.Grille;
import ground.Pronostique;

public class TraitementSimple extends Traitement
{
	private Grille g1;
	private Grille g2;
	private Grille g3;
	private Grille g4;
	private Grille g5;
	private Grille g6;
	private Grille g7;
	private Grille g8;
	private Grille g9;
	private final int nbCase = 10;
	
	/**
	 * On instancie les nouvelles grilles
	 */
	public TraitementSimple() {
		g1 = new Grille();
		g2 = new Grille();
		g3 = new Grille();
		g4 = new Grille();
		g5 = new Grille();
		g6 = new Grille();
		g7 = new Grille();
		g8 = new Grille();
		g9 = new Grille();
	}
	
	@Override
	/**
	 * Traitement de la grille pour en gŽnŽrer des plus optimales
	 */
	public Grille[] traite(Grille g) {
		Grille[] r = new Grille[nbCase];
		
		/* cas trivial... */
		if (g.getNbSimple() == g.getNbMatchs()) {
			r[0] = g;
			r[1] = null;
		}
		
		/* un triple -> une grille */
		else if(g.getNbTriple() == 1 && g.getNbSimple() == (g.getNbMatchs()-1)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on traite le triple */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			
			/* on affiche le rŽsultat */
			g1.affiche();
			r[0] = g1;
			r[1] = null;
		}
		
		/* un double -> une grille */
		else if (g.getNbDouble() == 1 && g.getNbSimple() == (g.getNbMatchs()-1)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on traite le double */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false)))
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true)))
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			else
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			
			/* on affiche le rŽsultat */
			g1.affiche();
			r[0] = g1;
			r[1] = null;
		}
		
		/* deux doubles -> deux grilles */
		else if (g.getNbDouble() == 2 && g.getNbSimple() == (g.getNbMatchs()-2)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du second double, comme s'il n'y en avait qu'un */
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
			}
			
			/* on affiche les rŽsutats */
			g1.affiche();
			g2.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = null;
		}
		
		/* un double et un triple -> deux grilles */
		else if (g.getNbTriple() == 1 && g.getNbDouble() == 1 && g.getNbSimple() == (g.getNbMatchs()-2)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du triple, comme s'il n'y en avait qu'un */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			
			/* on affiche les rŽsutats */
			g1.affiche();
			g2.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = null;
		}
		
		/* trois doubles -> deux grilles */
		else if (g.getNbDouble() == 3 && g.getNbSimple() == (g.getNbMatchs()-3)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du deuxime double qu'on rŽpartit sur les 2 grilles, alternŽ par rapport au prŽcŽdent*/
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			else {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du troisime double qu'on rŽpartit sur les 2 grilles, normalement*/
			if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = null;
		}
		
		/* deux triples -> 3 grilles */
		else if (g.getNbTriple() == 2 && g.getNbSimple() == (g.getNbMatchs()-2)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier triple qu'on rŽpartit sur les 3 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du second triple, comme s'il n'y en avait qu'un */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = null;
		}
		
		/* un triple et deux doubles -> 3 grilles */
		else if (g.getNbTriple() == 1 && g.getNbDouble() == 2 && g.getNbSimple() == (g.getNbMatchs()-3)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du triple qu'on rŽpartit sur les 3 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du premier double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			}
			
			/* on s'occupe du second double qu'on rŽpartit sur les 2 grilles, alternŽ par rapport au prŽcŽdent */
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			else {
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = null;
		}
		
		/* quatres doubles -> quatre grilles */
		else if (g.getNbDouble() == 4 && g.getNbSimple() == (g.getNbMatchs()-4)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier double qu'on rŽpartit sur les 4 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du deuxime double qu'on rŽpartit sur les 4 grilles */
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du troisime double qu'on rŽpartit sur les 4 grilles*/
			if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
			}
			else if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
			}
			else {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
			}
			
			/* on s'occupe du quatrime double qu'on rŽpartit sur les 4 grilles */
			if (g.getMatch(g.getDouble()[3]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[3]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[3]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[3]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[3]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[3]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[3]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[3]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[3]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[3]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[3]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[3]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[3]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[3]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = null;
		}
		
		/* deux triples et un double -> quatre grilles */
		else if (g.getNbTriple() == 2 && g.getNbDouble() == 1 && g.getNbSimple() == (g.getNbMatchs()-3)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier triple qu'on rŽpartit sur les 3 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du second triple qu'on rŽpartit sur les 2 grilles */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = null;
		}
		
		/* 3 triples -> 5 grilles */
		else if (g.getNbTriple() == 3 && g.getNbSimple() == (g.getNbMatchs()-3)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
				g5.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier triple */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g5.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du deuxime triple */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g4.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g5.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du troisime triple */
			g1.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g4.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g5.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			g5.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = g5;
			r[5] = null;
		}
		
		/* quatre triples -> 9 grilles */
		else if (g.getNbTriple() == 4 && g.getNbSimple() == (g.getNbMatchs()-4)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
				g5.setPronostique(i+1, g.getMatch(i).getPronostique());
				g6.setPronostique(i+1, g.getMatch(i).getPronostique());
				g7.setPronostique(i+1, g.getMatch(i).getPronostique());
				g8.setPronostique(i+1, g.getMatch(i).getPronostique());
				g9.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier triple qu'on rŽpartit sur les 9 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g5.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g7.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g8.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g9.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du deuxime triple */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g4.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g5.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g7.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g8.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g9.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du troisime triple */
			g1.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g2.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g5.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g7.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g8.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g9.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			
			/* on s'occupe du quatrime triple */
			g1.setPronostique(g.getTriple()[3]+1, new Pronostique(false, true, false));
			g2.setPronostique(g.getTriple()[3]+1, new Pronostique(false, false, true));
			g3.setPronostique(g.getTriple()[3]+1, new Pronostique(true, false, false));
			g4.setPronostique(g.getTriple()[3]+1, new Pronostique(true, false, false));
			g5.setPronostique(g.getTriple()[3]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[3]+1, new Pronostique(false, false, true));
			g7.setPronostique(g.getTriple()[3]+1, new Pronostique(false, false, true));
			g8.setPronostique(g.getTriple()[3]+1, new Pronostique(true, false, false));
			g9.setPronostique(g.getTriple()[3]+1, new Pronostique(false, true, false));
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			g5.affiche();
			g6.affiche();
			g7.affiche();
			g8.affiche();
			g9.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = g5;
			r[5] = g6;
			r[6] = g7;
			r[7] = g8;
			r[8] = g9;
			r[9] = null;
		}
		
		/* 1 triple et 3 doubles -> 6 grilles */
		else if (g.getNbTriple() == 1 && g.getNbDouble() == 3 && g.getNbSimple() == (g.getNbMatchs()-4)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
				g5.setPronostique(i+1, g.getMatch(i).getPronostique());
				g6.setPronostique(i+1, g.getMatch(i).getPronostique());
				
			}
			
			/* on s'occupe du triple qu'on rŽpartit sur les 6 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g5.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g6.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du premier double  */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du deuxime double */
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
			}
			
			/* on s'occupe du troisime double */
			if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[2]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g6.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g4.setPronostique(g.getDouble()[2]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
				g6.setPronostique(g.getDouble()[2]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			g5.affiche();
			g6.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = g5;
			r[5] = g6;
			r[6] = null;
		}
		
		/* deux triplse et deux doubles -> 6 grilles */
		else if (g.getNbTriple() == 2 && g.getNbDouble() == 2 && g.getNbSimple() == (g.getNbMatchs()-4)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
				g5.setPronostique(i+1, g.getMatch(i).getPronostique());
				g6.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du triple qu'on rŽpartit sur les 6 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g5.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g6.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du second triple */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g4.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g5.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du premier double qu'on rŽpartit sur les 2 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on s'occupe du second double qu'on rŽpartit sur les 2 grilles, alternŽ par rapport au prŽcŽdent */
			if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[1]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g2.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g3.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g5.setPronostique(g.getDouble()[1]+1, new Pronostique(true, false, false));
				g6.setPronostique(g.getDouble()[1]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			g5.affiche();
			g6.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = g5;
			r[5] = g6;
			r[6] = null;
		}
		
		/* trois triples et un double -> 9 grilles */
		else if (g.getNbTriple() == 3 && g.getNbDouble() == 1 && g.getNbSimple() == (g.getNbMatchs()-4)) {
			/* on copie les pronos dans la new grille avant de les modifier */
			for (int i = 0; i < g.getNbMatchs(); i++) {
				g1.setPronostique(i+1, g.getMatch(i).getPronostique());
				g2.setPronostique(i+1, g.getMatch(i).getPronostique());
				g3.setPronostique(i+1, g.getMatch(i).getPronostique());
				g4.setPronostique(i+1, g.getMatch(i).getPronostique());
				g5.setPronostique(i+1, g.getMatch(i).getPronostique());
				g6.setPronostique(i+1, g.getMatch(i).getPronostique());
				g7.setPronostique(i+1, g.getMatch(i).getPronostique());
				g8.setPronostique(i+1, g.getMatch(i).getPronostique());
				g9.setPronostique(i+1, g.getMatch(i).getPronostique());
			}
			
			/* on s'occupe du premier triple qu'on rŽpartit sur les 9 grilles */
			g1.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g3.setPronostique(g.getTriple()[0]+1, new Pronostique(true, false, false));
			g4.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g5.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[0]+1, new Pronostique(false, true, false));
			g7.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g8.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			g9.setPronostique(g.getTriple()[0]+1, new Pronostique(false, false, true));
			
			/* on s'occupe du deuxime triple */
			g1.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g2.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g3.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g4.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g5.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
			g7.setPronostique(g.getTriple()[1]+1, new Pronostique(true, false, false));
			g8.setPronostique(g.getTriple()[1]+1, new Pronostique(false, true, false));
			g9.setPronostique(g.getTriple()[1]+1, new Pronostique(false, false, true));
				
			/* on s'occupe du troisime triple */
			g1.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g2.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g3.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g4.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g5.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			g6.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g7.setPronostique(g.getTriple()[2]+1, new Pronostique(false, false, true));
			g8.setPronostique(g.getTriple()[2]+1, new Pronostique(true, false, false));
			g9.setPronostique(g.getTriple()[2]+1, new Pronostique(false, true, false));
			
			/* on s'occupe du double qu'on rŽpartit sur les 9 grilles */
			if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(true, true, false))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g7.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g8.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g9.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
			}
			else if (g.getMatch(g.getDouble()[0]).getPronostique().isEqual(new Pronostique(false, true, true))) {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g7.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g8.setPronostique(g.getDouble()[0]+1, new Pronostique(false, true, false));
				g9.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			else {
				g1.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g2.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g3.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g4.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g5.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g6.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g7.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
				g8.setPronostique(g.getDouble()[0]+1, new Pronostique(true, false, false));
				g9.setPronostique(g.getDouble()[0]+1, new Pronostique(false, false, true));
			}
			
			/* on affiche les rŽsultats */
			g1.affiche();
			g2.affiche();
			g3.affiche();
			g4.affiche();
			g5.affiche();
			g6.affiche();
			g7.affiche();
			g8.affiche();
			g9.affiche();
			r[0] = g1;
			r[1] = g2;
			r[2] = g3;
			r[3] = g4;
			r[4] = g5;
			r[5] = g6;
			r[6] = g7;
			r[7] = g8;
			r[8] = g9;
			r[9] = null;
		}
		/* sinon c'est qu'il y a une erreur ! */
		else {
			System.out.println("\nErreur rencontrŽe !");
			for (int i=0; i<9; i++) r[i] = null;
		}
		return r;
	}
	
	public int getNombreCase() {
		return nbCase;
	}
	
	public double prixDepart(Grille g) {
		double retour = g.getPrixGrille() * Math.pow(3, g.getNbTriple()) * Math.pow(2,g.getNbDouble());
		return retour;
	}
}
