import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Joueur {
	
	private int numJoueur ;
	private String nom ;
	private Color couleur ;
	private int vitesse ;
	private int x ;
	private int y ;
	
	int xDepart = 0 ;
	int yDepart = 0 ;
	int vitesseInitiale = 50 ;
	
	public Joueur(int num, String nom, Color couleur) {
		numJoueur = num ;
		this.nom = nom ;
		this.couleur = couleur ;
		vitesse = vitesseInitiale ;
		if (numJoueur==1) {
			yDepart = 0 ;
			// xDepart = (int)((Math.random())*(Terrain.getLongueur()));
		} else {
			// yDepart = Terrain.getLargeur() ;
			// xDepart = (int)((Math.random())*(Terrain.getLongueur()));
		}
	}
	
	public void dessiner(Graphics g, int x, int y) {
        g.setColor(couleur);
        g.fillRect(x,y,5,5);
    }
    
	public void deplacer(int deltaX, int deltaY){
		x=x+deltaX;
        y=y+deltaY;
	}
	
	public void changerVitesse(int bonusVitesse) {
		vitesse = vitesse + bonusVitesse ;
	}
	
	public Color getCouleur(){
		return couleur ;
	}





}
