import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GrilleJeu extends JPanel implements KeyListener, ActionListener{
	
	public static HighscoreManager hm = new HighscoreManager();
	private final Point[][] tab; 
	private int colonne = 60;
	private int ligne = 60;
		
	int haut = getHeight();
    int larg = getWidth();
    
    private javax.swing.Timer t;
    
    private int nbrJoueur;
    
    private Joueur r1;
	private Joueur r2;
	private Joueur r3;
	
    public GrilleJeu (int nbrJoueur, String nomJ1, String nomJ2, String nomJ3, int ms){
		
		this.nbrJoueur = nbrJoueur;
		
		r1=new Joueur(1, nomJ1, Color.BLUE, this);
		r2=new Joueur(2, nomJ2, Color.RED, this);
		
		if(nbrJoueur == 3)
			r3=new Joueur(3, nomJ2, Color.GREEN, this);	
		
		tab = new Point[ligne][colonne];
		
			for(int i=0; i<tab.length; i++){
				for(int j=0; j<tab[0].length; j++){ ///les bordures ==1
					
					tab[0][j]= new Point (0, j);
					tab[tab.length-1][j]= new Point(tab.length-1, j);
					tab[i][0]= new Point (i,0);
					tab[i][tab[0].length-1]= new Point(i, tab[0].length-1) ;
					
					tab[1][j]= new Point (1, j);
					tab[tab.length-2][j]= new Point (tab.length-2, j) ;
					tab[i][1]= new Point (i, 1);
					tab[i][tab[0].length-2]= new Point (i, tab[0].length-2);
				}
			}
			
		t = new javax.swing.Timer(ms, this);
	}
	
	public void startGame(){
		t.start();
	}	
    
    public int getHaut(){
		return getHeight();
	}
	public int getLarg(){
		return getWidth();
	}
	
	public int getNbColonnes(){
		return colonne ;
	}
	
	public int getNbLignes(){
		return ligne ;
	}
	
	public Point [][] getTab(){
		return tab ;
	}	
	
	public int getLargeurCase(){
		int a=this.getLarg()/colonne;
		return a;
	}
	
	public int getHauteurCase(){
		int a=this.getHaut()/ligne;
		return a;
	}
	
	public int getNbJoueurs(){
		return nbrJoueur;
	}		

    
   public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
        int haut = getHeight();
        int larg = getWidth();
        
        ///affichage grille tab
		for (int i=0; i<tab.length; i++){
			int y1 = i*haut/tab.length;
            int h = (i+1)*haut/tab.length-y1;
            
            for(int j=0;j<tab[0].length;j++) {   
            int x1 = j*larg/tab[0].length;
            int l = (j+1)*larg/tab[0].length-x1;
                             
                if(tab[i][j]==null) {
                  //g.setColor(Color.GRAY);
                  //g.drawRect(x1,y1,l,h);
         
                } else if(tab[i][j]!=null) {
                 g.setColor(Color.BLACK);
                 g.fillRect(x1,y1,l,h);
				}

            }			
       }
       
       r1.dessiner(g, larg, haut);
       r2.dessiner(g, larg, haut);
       
       if(nbrJoueur == 3)
			r3.dessiner(g, larg, haut);
       
       r1.creerTrainee(g, larg, haut);
       r2.creerTrainee(g, larg, haut);		   
       
       if(nbrJoueur == 3)
			r3.creerTrainee(g, larg, haut);
    }
    
    ///pour clavier DEPLACEMENT
	public void keyPressed(KeyEvent evt) {      
		int c = evt.getKeyCode();
    
		///deplacement j1
		if (c == KeyEvent.VK_UP && r1.getDirection()!=8 && r1.getDirection()!=2) 
			r1.changDirection(8);
    
		if (c == KeyEvent.VK_DOWN && r1.getDirection()!=2 && r1.getDirection()!=8) 
			r1.changDirection(2);
    
		if (c == KeyEvent.VK_RIGHT && r1.getDirection()!=6 && r1.getDirection()!=4) 
			r1.changDirection(6);
        
		if (c == KeyEvent.VK_LEFT && r1.getDirection()!=4 && r1.getDirection()!=6)
			r1.changDirection(4);        
    
    
		///deplacement j2
		if (c == KeyEvent.VK_Z && r2.getDirection()!=8 && r2.getDirection()!=2) 
			r2.changDirection(8);
        
		if (c == KeyEvent.VK_S && r2.getDirection()!=2 && r2.getDirection()!=8) 
			r2.changDirection(2);

		if (c == KeyEvent.VK_D && r2.getDirection()!=6 && r2.getDirection()!=4) 
			r2.changDirection(6);

		if (c == KeyEvent.VK_Q && r2.getDirection()!=4 && r2.getDirection()!=6) 
			r2.changDirection(4);
  
		
		///deplacement j3
		if(nbrJoueur == 3){
		if (c == KeyEvent.VK_U && r3.getDirection()!=8 && r3.getDirection()!=2) 
			r3.changDirection(8);
        
		if (c == KeyEvent.VK_J && r3.getDirection()!=2 && r3.getDirection()!=8) 
			r3.changDirection(2);
		
		if (c == KeyEvent.VK_K && r3.getDirection()!=6 && r3.getDirection()!=4) 
			r3.changDirection(6);
    
		if (c == KeyEvent.VK_H && r3.getDirection()!=4 && r3.getDirection()!=6)
			r3.changDirection(4);
		}
	}

	
	public void keyReleased(KeyEvent evt){}
	
	public void keyTyped(KeyEvent evt){}
	
	public void actionPerformed(ActionEvent e){
		
		r1.mooveOfPlayer();
		r2.mooveOfPlayer();
		
		if(nbrJoueur == 3)
			r3.mooveOfPlayer();
		
		r1.accidentTrainee();
		r2.accidentTrainee();
		
		if(nbrJoueur == 3)
			r3.accidentTrainee();
		
		r1.accidentBordure();
		r2.accidentBordure();
		
		if(nbrJoueur == 3)
			r3.accidentBordure();
		
		collisionAdansB(r1, r2);
		collisionAdansB(r2, r1);
		
		if(nbrJoueur == 3){
			collisionAdansB(r1, r3);				
			collisionAdansB(r3, r1);
		
			collisionAdansB(r2, r3);
			collisionAdansB(r3, r2);
		}
		
		if (finDuJeu()) {
			hm.addScore(nomJoueurWin(),1);
			remettreZero();			
		}
			
		this.repaint();
	}
	
	public void collisionAdansB(Joueur A, Joueur B){
		Joueur win = A;
		Joueur loose = B;
			
		for (int i=0; i<win.getTrainee().length; i++){
				for (int j=0; j<win.getTrainee()[0].length; j++){
							if(win.getTrainee()[i][j] !=null && (win.getTrainee()[i][j]).getX()==loose.getX() && (win.getTrainee()[i][j]).getY()==loose.getY()){
								//System.out.println("collision joueurs");
								loose.effacerTrainee();
								loose.resetTrainee();
								win.setScore();
								win.effacerTrainee();
								win.resetTrainee();
								//System.out.println("Score de "+win.getNom()+" est egal a "+win.getScore());
							}		
					
				}
		}
		
		///cas où les tetes se croisent
		if(win.getX()==loose.getX() && win.getY()==loose.getY()){
				win.effacerTrainee();
				win.resetTrainee();
				loose.effacerTrainee();
				loose.resetTrainee();
		}						 
	}
	
	public int returnScoreJoueur(int nJ){
		int resultat = 0;
		if(nJ==1)
			resultat = r1.getScore();
		if(nJ==2)
			resultat = r2.getScore();
		if(nbrJoueur==3){
			if(nJ==3)
				resultat = r3.getScore();	
		}
		return resultat;	
	}
	
	public boolean finDuJeu(){
		boolean end = false;
		if(r1.getScore()==5 || r2.getScore()==5)
			end=true;
		if(nbrJoueur==3){
			if(r3.getScore()==5)
				end=true;
		}
		return end;
	}
	
	public void remettreZero(){
		r1.setZero();
		r2.setZero();
		if(nbrJoueur == 3) 
			r3.setZero();
	}
	
	public static HighscoreManager getHm() {
		return hm;
	}	
	
	public String nomJoueurWin(){
		String gagnant = "";
		if(r1.getScore()==5)
			gagnant = r1.getNom();
		if(r2.getScore()==5)
			gagnant = r2.getNom();	
		if(nbrJoueur==3){
		if(r3.getScore()==5)
			gagnant = r3.getNom(); }
		return gagnant;
	}		
			
}

	
