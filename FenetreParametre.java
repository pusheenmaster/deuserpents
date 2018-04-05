import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FenetreParametre extends JFrame {

	private JButton lancer;
	
	private JButton bleu1;
	private JButton rouge1;
	private JButton vert1;
	
	private JButton bleu2;
	private JButton rouge2;
	private JButton vert2;
	
	private JTextField nom1;
	private JTextField nom2;
	
	private JLabel j1;
	private JLabel j2;
	
	private JLabel choix1;
	private JLabel choix2;
	
	private JLabel choixFond;
	private JButton black;
	private JButton gray;
	private JButton pink;
	
	private JLabel jeunom;
	private JButton rules;
	
	
	public FenetreParametre (){
		
		super("Fenetre PARAMETRE");
		setSize(1000,600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lancer = new JButton ("newGame"); //lancer partie
		
		j1 = new JLabel ("Username of player 1:");  //recuperer le nom des joueurs pour para
		nom1 = new JTextField ("", 15);
		j2 = new JLabel ("Username of player 2:");
		nom2 = new JTextField ("", 15);
		
		
		choix1 = new JLabel ("Color of player 1:");
		bleu1 = new JButton ("blue");	//choix couleur trainée j1
		bleu1.setBackground(Color.BLUE);
		rouge1 = new JButton ("rouge");
		rouge1.setBackground(Color.RED);
		vert1 = new JButton ("vert");
		vert1.setBackground(Color.GREEN);
		
		choix2 = new JLabel ("Color of player 2:");
		bleu2 = new JButton ("blue");  //choix couleur trainée j2
		bleu2.setBackground(Color.BLUE);
		rouge2 = new JButton ("rouge");
		rouge2.setBackground(Color.RED);
		vert2 = new JButton ("vert");
		vert2.setBackground(Color.GREEN);
		
		choixFond = new JLabel ("Color of the background:"); // choix couleur fond du jeu
		black = new JButton ("Black");
		black.setBackground(Color.BLACK);
		gray = new JButton ("Gray");
		gray.setBackground(Color.GRAY);
		pink = new JButton ("Pink");
		pink.setBackground(Color.PINK);
	
		JPanel cadrePrincipal= new JPanel();
		cadrePrincipal.setSize(1000,600);
		cadrePrincipal.setLayout(null);
		JPanel paraj1 = new JPanel(new GridLayout(6,1));
		JPanel paraj2 = new JPanel(new GridLayout(6,1));
		JPanel paraj3 = new JPanel(new GridLayout(1,5));
		
		paraj1.add(j1);
		paraj1.add(nom1);
		paraj1.add(choix1);
		paraj1.add(bleu1);
		bleu1.addActionListener(new EcouteurCouleurJ1(Color.BLUE));
		paraj1.add(rouge1);
		rouge1.addActionListener(new EcouteurCouleurJ1(Color.RED));
		paraj1.add(vert1);
		vert1.addActionListener(new EcouteurCouleurJ1(Color.GREEN));
		
		paraj1.setBackground(Color.PINK);
		paraj1.setBounds(100,50, 150, 400);
		cadrePrincipal.add(paraj1);
		
		paraj2.add(j2);
		paraj2.add(nom2);
		paraj2.add(choix2);
		paraj2.add(bleu2);
		bleu1.addActionListener(new EcouteurCouleurJ2(Color.BLUE));
		paraj2.add(rouge2);
		rouge1.addActionListener(new EcouteurCouleurJ2(Color.RED));
		paraj2.add(vert2);
		vert1.addActionListener(new EcouteurCouleurJ2(Color.GREEN));
		
		paraj2.setBackground(Color.PINK);
		paraj2.setBounds(500,50, 150, 400);
		cadrePrincipal.add(paraj2);
		
		paraj3.add(choixFond);
		paraj3.add(black);
		paraj3.add(gray);
		paraj3.add(pink);
		
		paraj3.setBackground(Color.PINK);
		paraj3.setBounds(100, 500, 500, 75);
		cadrePrincipal.add(paraj3);
		
		
		setContentPane(cadrePrincipal);
		
		setVisible(true);
	}	
	
	public static Joueur creerJoueur1(Color couleur){
		Color c = couleur;
		//Joueur j1 = new Joueur(1, nom1, c, grille);
		Joueur j1 = new Joueur(1, "zdf", Color.BLACK);
		return j1;
	}
	
	public static Joueur creerJoueur2(Color couleur){
		Color c = couleur;
		//Joueur j1 = new Joueur(1, nom1, c, grille);
		Joueur j2 = new Joueur(1, "zdf", Color.BLACK);
		return j2;
	}
	
	public void lancerFenetreJeu(){
		new GrilleJeu(); 
		}
	
}

