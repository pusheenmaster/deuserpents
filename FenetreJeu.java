import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreJeu extends JFrame {
	
	int dimTerrain = 800;
	private GrilleJeu leTerrain;
	
	private int nbrJ;
	private String nom1;
	private String nom2;
	private String nom3;
	
	private PanneauScore ps;
	
	private Decompte de;
	
	private JPanel cadrePrincipal;
	
	public FenetreJeu(int nbrJ, String nom1, String nom2, String nom3, int ms){
		
        super("Fenetre TRON");
        
        setSize(1200, dimTerrain+200);
        setResizable(false);
        setLocation(100, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.nbrJ=nbrJ;
        this.nom1=nom1;
        this.nom2=nom2;
        this.nom3=nom3;
        
        cadrePrincipal= new JPanel();
		cadrePrincipal.setSize(1400, dimTerrain);
		cadrePrincipal.setLayout(null);
    
        cadrePrincipal.setBackground(Color.WHITE);
      
        de = new Decompte();
		de.setBackground(Color.WHITE);
		de.setBounds(5, 10, 180, 500);
        setContentPane(de);
 		
		
		leTerrain = new GrilleJeu(nbrJ, nom1, nom2, nom3, ms);
		addKeyListener(leTerrain);
		
		leTerrain.setBackground(Color.PINK);
		leTerrain.setBounds(250, 25, dimTerrain, dimTerrain);
		cadrePrincipal.add(leTerrain);
		
		ps = new PanneauScore();
		ps.setBackground(Color.WHITE);
		ps.setBounds(5, 10, 180, 500);
		cadrePrincipal.add(ps);
      
        setVisible(true);
	}
	
	
	
	///Pour afficher les scores
	class PanneauScore extends JPanel implements ActionListener{
			
			private javax.swing.Timer t;
			
		public PanneauScore(){
				  
			t = new javax.swing.Timer(70, this);
			t.start();
		}		  
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			g.setFont(new Font("Arial",Font.PLAIN,40));
			g.setColor(Color.RED);
			g.drawString (" Scores ", 20, 50);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial",Font.PLAIN,20));
			
			g.drawString (nom1, 20, 150);
			g.drawString ("Score= "+leTerrain.returnScoreJoueur(1), 20, 180);

			g.drawString (nom2, 20, 250);
			g.drawString ("Score= "+leTerrain.returnScoreJoueur(2), 20, 280);
			
			if(leTerrain.getNbJoueurs()==3){
				g.drawString (nom3, 20, 350);
				g.drawString ("Score= "+leTerrain.returnScoreJoueur(3), 20, 380);
			}
			
			g.setFont(new Font("Arial",Font.PLAIN,17));
			drawString (g, "Nombre de fois gagne:", 10, 380);
			g.setFont(new Font("Arial",Font.PLAIN,14));
			drawString (g, GrilleJeu.getHm().getHighscoreString(), 20, 420);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial",Font.PLAIN,20));
		
		}	
		
		public void actionPerformed(ActionEvent e){
			this.repaint();
		}
		
		private void drawString(Graphics g, String text, int x, int y) {
			for (String line : text.split("\n"))
				g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}
	}
	
	
	///pour décompte lancement jeu
	class Decompte extends JPanel implements ActionListener{
		
		private javax.swing.Timer t;
		private int decompte; 
		
	public Decompte(){
		
		decompte = 4;	  
		t = new javax.swing.Timer(500, this);
		t.start();
	}		  
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
	
		g.setFont(new Font("Arial",Font.PLAIN, 100));
		g.setColor(Color.GRAY);
		g.drawString (""+decompte+" !", 300, 400);
		decompte--;
	}
	
	public void actionPerformed(ActionEvent e){
		
		this.repaint();
		if(decompte==0){
			setContentPane(cadrePrincipal);
			leTerrain.startGame();
			t.stop();
		}	
	}
	
	public int getDecompte(){
		return decompte;
	}
	}
	
		
}
