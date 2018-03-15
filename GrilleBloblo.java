import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GrilleBloblo extends JPanel{
	private final int[][] tab; 		//tableau de boolean
	private int colonne = 5;
	private int ligne = 12;
    
    private int pL = 800;
	private int pH = 350;
	
    // constructeur
    	public GrilleBloblo (){
		tab = new int[colonne][ligne];
	}

   // public static final int CASE_VIDE     = 0;
  //  public static final int CASE_OBSTACLE = 1;
			
	//RecommenceApresPerteVie
	public void Commencer(){
		for (int i=0; i<tab.length; i++){
			for (int j=0; j<tab[1].length; j++){ 			// on parcourt le tableau
				tab[i][j] = 0;	
				if(i==0 || j ==0 || i==colonne-1 || j==ligne-1){
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
				                        
                if(tab[i][j]==0) {
                  g.setColor(Color.PINK);
                 // g.drawRect(x1,y1,l,h);
                } 
                if(tab[i][j]==1) {
                 g.setColor(Color.BLACK);
			 }

            int x1 = j*larg/tab[0].length;
            //int l = (j+1)*larg/tab[0].length-x1;
            int l = larg/tab[0].length;
                g.drawRect(x1,y1,l,h);
               // g.fillRect(x1,y1,l,h);
            }

			
        }

        /*for(int i=0;i<listItem.size();i++) {
             listItem.get(i).dessiner(g,larg,haut);
        }*/

       // r.dessiner(g,larg,haut);
    }
	}

	
