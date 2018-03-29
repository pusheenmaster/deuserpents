import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GrilleJeu extends JPanel{
	private final int[][] tab; 		//tableau de boolean
	private int colonne = 30;
	private int ligne = 30;
    
    private int pL = 800;
	private int pH = 350;
	
	int haut = getHeight();
    int larg = getWidth();
    
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
	}

   // public static final int CASE_VIDE     = 0;
  //  public static final int CASE_OBSTACLE = 1;
			
	//RecommenceApresPerteVie
	public void Commencer(){
		for (int i=0; i<tab.length; i++){
			for (int j=0; j<tab[1].length; j++){ 			// on parcourt le tableau
				tab[i][j] = 0;	
				if(i==0 || j ==0 || i==ligne-1 || j==colonne-1){
					tab[i][j] = 1;	
					}
										// on le remplit de cases vides. Une case vide a la valeur 0
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
	}

	
