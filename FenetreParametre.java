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
		rouge1 = new JButton ("rouge");
		vert1 = new JButton ("vert");
		
		choix2 = new JLabel ("Color of player 2:");
		bleu2 = new JButton ("blue");  //choix couleur trainée j2
		rouge2 = new JButton ("rouge");
		vert2 = new JButton ("vert");
		
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
		
		paraj1.add(j1);
		paraj1.add(nom1);
		paraj1.add(choix1);
		paraj1.add(bleu1);
		paraj1.add(rouge1);
		paraj1.add(vert1);
		paraj1.setBackground(Color.PINK);
		
		paraj1.setBounds(0,0, 200, 600);
		
		cadrePrincipal.add(paraj1);
		
		/*paraj2.add(j2);
		paraj2.add(nom2);
		paraj2.add(choix2);
		paraj2.add(bleu2);
		paraj2.add(rouge2);
		paraj2.add(vert2);
		
		paraj2.setBackground(Color.PINK);
		
		cadrePrincipal.add(paraj1, BorderLayout.WEST);
		cadrePrincipal.add(paraj2, BorderLayout.EAST);
		
		/*cadrePrincipal.add(nomjeu, BorderLayout.SOUTH);
		cadrePrincipal.add(rules, BorderLayout.SOUTH);*/
		
		/*cadrePrincipal.add(black, BorderLayout.SOUTH);
		cadrePrincipal.add(gray, BorderLayout.SOUTH);
		cadrePrincipal.add(pink, BorderLayout.SOUTH);*/
		
		setContentPane(cadrePrincipal);
		
		setVisible(true);
	}	
		
	
	
}

