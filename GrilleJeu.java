import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GrilleJeu extends JPanel implements KeyListener, ActionListener{
	private final int[][] tab; 		//tableau de boolean
	private int colonne = 30;
	private int ligne = 30;
    
	
	int haut = getHeight();
    int larg = getWidth();
    
    private javax.swing.Timer t;
    
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
	
	    // Variables de la partie
	private Joueur r1;
	private Joueur r2;
   // public Joueur getJoueur() {return r;}
   // public int[][]    getCarte()      {return CARTE;}
    
    	
    // constructeur
    	public GrilleJeu (){
		tab = new int[ligne][colonne];
		r1=new Joueur(1,"Jojo",Color.BLUE,this);
		r2=new Joueur(2,"Pat",Color.RED,this);
		
		t = new javax.swing.Timer(300, this);
		t.start();
	}


			
	//RecommenceApresPerteVie
	public void Commencer(){
		for (int i=0; i<tab.length; i++){
			for (int j=0; j<tab[1].length; j++){ 			// on parcourt le tableau
				tab[i][j] = 0;	
				if(i==0 || j ==0 || i==ligne-1 || j==colonne-1){
					tab[i][j] = 1;	
					}
										
			}
		}
	}
	
	 // affichage tableau
	 public String toString(){
        String message=""; 
        for (int i=0; i<tab.length; i++){
			for (int j=0; j<tab[1].length; j++){
			message = message+tab[i][j];	
		}
		 message = message + "\n";
		}
        return message; 
    }
	
	public int getLargeurCase(){
		int a=this.getLarg()/colonne;
		return a;
	}
	
	public int getHauteurCase(){
		int a=this.getHaut()/ligne;
		return a;
	}

    
    
   public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.setColor(Color.WHITE);
        int haut = getHeight();
        int larg = getWidth();
        
		for (int i=0; i<tab.length; i++){
			int y1 = i*haut/tab.length;
            //int h = (i+1)*haut/tab.length-y1;
            int h = haut/tab.length;
            
            for(int j=0;j<tab[0].length;j++) {   
            int x1 = j*larg/tab[0].length;
            //int l = (j+1)*larg/tab[0].length-x1;
            int l = larg/tab[0].length;
                             
                if(tab[i][j]==0) {
                  g.setColor(Color.GRAY);
                  g.drawRect(x1,y1,l,h);
         
                } else if(tab[i][j]==1) {
                 g.setColor(Color.BLACK);
                 g.fillRect(x1,y1,l,h);
				}

            }			
       }
       r1.dessiner(g,larg,haut);
       r2.dessiner(g,larg,haut);
       
    }
    ///pour clavier vk event ESSAIE DEPLACEMENT
	public void keyPressed(KeyEvent evt) {      
	int c = evt.getKeyCode();
	
	System.out.println("c=" +c);
    
    //deplacement j1
    if (c == KeyEvent.VK_UP) {
        r1.deplacer(0, -1);
        r1.changDirection(8);
    }
      if (c == KeyEvent.VK_DOWN) {
        r1.deplacer(0, 1);
        r1.changDirection(2);
    }
      if (c == KeyEvent.VK_RIGHT) {
        r1.deplacer(1, 0);
        r1.changDirection(6);
    }
      if (c == KeyEvent.VK_LEFT) {
        r1.deplacer(-1, 0);
		r1.changDirection(4);        
    }
    
    //deplacement j2
    if (c == KeyEvent.VK_Z) {
        r2.deplacer(0, -1);
        r2.changDirection(8);
        
    }
      if (c == KeyEvent.VK_S) {
        r2.deplacer(0, 1);
         r2.changDirection(2);
    }
      if (c == KeyEvent.VK_D) {
        r2.deplacer(1, 0);
         r2.changDirection(6);
    }
      if (c == KeyEvent.VK_Q) {
        r2.deplacer(-1, 0);
         r2.changDirection(4);
    }
    
    //this.repaint();
	}
	
	public void keyReleased(KeyEvent evt){}
	
	public void keyTyped(KeyEvent evt){}
	
	public void actionPerformed(ActionEvent e){
		if(r1.getDirection()==8){
			r1.deplacer(0,-1);
		}
		if(r1.getDirection()==2){
			r1.deplacer(0,1);
		}
		if(r1.getDirection()==6){
			r1.deplacer(1,0);
		}
		if(r1.getDirection()==4){
			r1.deplacer(-1,0);
		}
		
		if(r2.getDirection()==8){
			r2.deplacer(0,-1);
		}
		if(r2.getDirection()==2){
			r2.deplacer(0,1);
		}
		if(r2.getDirection()==6){
			r2.deplacer(1,0);
		}
		if(r2.getDirection()==4){
			r2.deplacer(-1,0);
		}
			
		this.repaint();
	}
}

	
