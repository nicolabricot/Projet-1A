package view;


import ground.Grille;
import ground.Pronostique;
import inc.Functions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame
{

	private static final long serialVersionUID = 1L;

	protected Grille g = new Grille();
	
	private JPanel container = new JPanel();
	
	private JPanel buttons = new JPanel();
	private JButton reset = new JButton("Remettre à zéro");
	private JButton process = new JButton("Traiter la grille");
	
	private JPanel prono[] = new JPanel[g.getNbMatchs()];
	private JButton loc[] = new JButton[g.getNbMatchs()];
	private JButton mn[] = new JButton[g.getNbMatchs()];
	private JButton vis[] = new JButton[g.getNbMatchs()];
	
	private JLabel ecran[] = new JLabel[g.getNbMatchs()];
	private JLabel ecran_prono[] = new JLabel[g.getNbMatchs()];
	
	private JPanel legend = new JPanel();
	private JPanel ligne[] = new JPanel[g.getNbMatchs()];
	private JPanel lignes = new JPanel();
	
	protected Functions f = new Functions();
	
	/**
	 * On instancie une nouvelle fenêtre pour "remplir" la grille
	 */
	public Fenetre() {

		this.setTitle("EnsiStats");
		this.setSize(550, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComposant();
		
		this.setContentPane(container);
		JOptionPane.showMessageDialog(null, "Bonjour !\nNous espérons que ce petit programme te permettra de bien t'amuser...\nN'hésite pas à nous faire parvenir les beugs à projet@devenet.info !\nMerci ;-)", "Bienvenue - EnsiStats", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Ah oui, avant de te laisser les manettes, si tu n'as jamais entendu parler du LotoFoot,\nva lire sur notre Wiki ce que tu dois savoir avant de commencer !\nPour rappel, ce programme permet de réduire le nombre de grilles souhaitées tout en\n gardant une garantie N-1 :-)", "LotoFoot ? WTF ! - EnsiStats", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(true);
		
	}
	
	/**
	 * On initialise tous les boutons et autres joyeusetés de JFrame...
	 */
	private void initComposant() {
		
		container.setLayout(new BorderLayout());
			
		lignes.setLayout(new GridLayout(7,1));
		//lignes.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		JLabel legendeMatch = new JLabel();
		legendeMatch.setText("Équipe locale vs. équipe visiteur");
		legendeMatch.setPreferredSize(new Dimension(300, 30));
		legendeMatch.setHorizontalAlignment(JLabel.CENTER);
		JLabel legendeProno = new JLabel();
		legendeProno.setText("[(1) Locale, (N) Match Nul, (2) Visiteur]");
		legendeProno.setHorizontalAlignment(JLabel.CENTER);
		legend.setLayout(new BorderLayout());
		legend.add(legendeMatch, BorderLayout.WEST);
		legend.add(legendeProno, BorderLayout.CENTER);
		container.add(legend, BorderLayout.NORTH);
		
		/* Dimension des boutons pour modifier les prono */
		Dimension dim = new Dimension(22, 22);
		
		for (int i=0; i<g.getNbMatchs(); i++) {
			loc[i] = new JButton("1");
			loc[i].setPreferredSize(dim);
			loc[i].setName("1");
			loc[i].setText("1");
			loc[i].addActionListener(new SetProno(i, 1));
			mn[i] = new JButton("N");
			mn[i].setPreferredSize(dim);
			mn[i].addActionListener(new SetProno(i, 0));
			vis[i] = new JButton("2");
			vis[i].setPreferredSize(dim);
			vis[i].addActionListener(new SetProno(i, 2));
			
			prono[i] = new JPanel();
			prono[i].setPreferredSize(new Dimension(125, 20));
			//prono[i].setBorder(BorderFactory.createLineBorder(Color.orange));
			prono[i].add(loc[i]);
			prono[i].add(mn[i]);
			prono[i].add(vis[i]);
			
			ecran[i] = new JLabel();
			//ecran[i].setBorder(BorderFactory.createLineBorder(Color.green));
			ecran[i].setPreferredSize(new Dimension(300, 30));
			ecran[i].setText(displayMatch(i));
			
			ecran_prono[i] = new JLabel();
			ecran_prono[i].setText(displayProno(i));
			ecran_prono[i].setHorizontalAlignment(JLabel.CENTER);
			
			ligne[i] = new JPanel();
			//ligne[i].setBorder(BorderFactory.createLineBorder(Color.black));
			ligne[i].setLayout(new BorderLayout());
			ligne[i].add(ecran[i], BorderLayout.WEST);
			ligne[i].add(ecran_prono[i], BorderLayout.CENTER);
			ligne[i].add(prono[i], BorderLayout.EAST);
			lignes.add(ligne[i]);
		}
		container.add(lignes, BorderLayout.CENTER);
		
		reset.addActionListener(new Reset());
		process.addActionListener(new TraiteGrille());
		buttons.add(reset, BorderLayout.WEST);
		buttons.add(process, BorderLayout.EAST);
		//buttons.setBorder(BorderFactory.createLineBorder(Color.red));
		container.add(buttons, BorderLayout.SOUTH);
	}
	
	/**
	 * Permet d'afficher le nom des matchs autrement que par défault
	 * @param i
	 * @return
	 */
	public String displayMatch(int i) {
		return "\t\t" +  f.intToString(i+1) + ".\t\t" + g.getMatch(i).getNameEquipe()[0] + "  vs.  " + g.getMatch(i).getNameEquipe()[1];
	}
	/**
	 * Affichage des pronostiques séparement du nom des matchs
	 * @param i
	 * @return
	 */
	public String displayProno(int i) {
		return g.getMatch(i).getPronostique().toString();
	}
	
	/**
	 * Bouton de traitement de la grille
	 * @author Nicolas
	 *
	 */
	class TraiteGrille implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FenetreResultats(g);
		}
	}
	
	/**
	 * Bouton reset des pronostiques
	 * @author Nicolas
	 *
	 */
	class Reset implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			for (int i=0; i<g.getNbMatchs(); i++) {
				g.setPronostique(i+1, new Pronostique(false, false, false));
				ecran_prono[i].setText(displayProno(i));
			}
		}
	}
	
	/**
	 * Boutons de modifications des pronostiques
	 * @author Nicolas
	 *
	 */
	class SetProno implements ActionListener {
		
		private int prono;
		private int match;
		
		/**
		 * Instanciation avec le numéro du match et pronostique default
		 * @param match
		 * @param prono
		 */
		public SetProno(int match, int prono) {
			this.prono = prono;
			this.match = match;
		}
		
		/**
		 * Modification du pronostique "à l'unité"
		 */
		public void actionPerformed(ActionEvent arg0) {
			if (prono == 1) {
				g.setPronostique(match+1, new Pronostique(
						!g.getMatch(match).getPronostique().getPronostique()[0],
						g.getMatch(match).getPronostique().getPronostique()[1],
						g.getMatch(match).getPronostique().getPronostique()[2]));
				ecran_prono[match].setText(displayProno(match));
			}
			else if (prono == 2) {
				g.setPronostique(match+1, new Pronostique(
						g.getMatch(match).getPronostique().getPronostique()[0],
						g.getMatch(match).getPronostique().getPronostique()[1],
						!g.getMatch(match).getPronostique().getPronostique()[2]));
				ecran_prono[match].setText(displayProno(match));
			}
			else {
				g.setPronostique(match+1, new Pronostique(
						g.getMatch(match).getPronostique().getPronostique()[0],
						!g.getMatch(match).getPronostique().getPronostique()[1],
						g.getMatch(match).getPronostique().getPronostique()[2]));
				ecran_prono[match].setText(displayProno(match));
			}
		}
	}
	
}