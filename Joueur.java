import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Joueur {
	
	private int numJoueur ;
	private String nom ;
	private Color couleur ;
	//private int vitesse ;
	private int x ;
	private int y ;
	private GrilleJeu terrain ;
	
	int xDepart = 0 ;
	int yDepart = 0 ;
	//int vitesseInitiale = 50 ;
	
	public Joueur(int num, String nom, Color couleur, GrilleJeu grille) {
		numJoueur = num ;
		this.nom = nom ;
		this.couleur = couleur ;
		//vitesse = vitesseInitiale ;
		terrain = grille ;
		if (numJoueur==1) {
			System.out.println("ok joueur 1");
			yDepart = 0 ;
			xDepart = (int)((Math.random())*(terrain.getNbColonnes())+1);
		} else {
			System.out.println("ok joueur 2");
			yDepart = terrain.getNbLignes()-1 ;
			xDepart = (int)((Math.random())*(terrain.getNbColonnes())+1);
		}
		x=xDepart;
		y=yDepart;
	}
	
	public void dessiner(Graphics g, int w, int h) {
		int x1 = x*w/terrain.getNbColonnes();
        int y1 = y*h/terrain.getNbLignes();
        System.out.println("x= "+x+" y = "+y+" x1 = "+x1+" y1= "+y1);
        g.setColor(couleur);
        g.fillRect(x1,y1,terrain.getLargeurCase(),terrain.getHauteurCase());
    }
    
	public void deplacer(int deltaX, int deltaY){
		x=x+deltaX;
        y=y+deltaY;
	}
	
	//public void changerVitesse(int bonusVitesse) {
	//	vitesse = vitesse + bonusVitesse ;
	//}
	
	public Color getCouleur(){
		return couleur ;
	}
	
	///pour clavier vk event ESSAIE DEPLACEMENT
	private void passwordTFKeyTyped(java.awt.event.KeyEvent evt) {      
	char c = evt.getKeyChar();

    if (c == KeyEvent.VK_UP) {
        deplacer(0, -1);
    }
      if (c == KeyEvent.VK_DOWN) {
        deplacer(0, 1);
    }
      if (c == KeyEvent.VK_RIGHT) {
        deplacer(1, 0);
    }
      if (c == KeyEvent.VK_LEFT) {
        deplacer(-1, 0);
    }
	}





}
