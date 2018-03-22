import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Trainee {
	
	private Joueur joueur ;
	private Color couleur ;
	
	public Trainee(Joueur jou) {
		this.joueur = jou ;
		this.couleur = joueur.getCouleur() ;
	}
	
	public void setTrainee(Graphics g, int x, int y) {
		g.setColor(couleur);
        g.fillRect(x,y,5,5);
    }
    
    public void deleteTrainee(Graphics g, int x, int y) {
		g.setColor(Color.WHITE/*Terrain.getCouleurFond()*/);
		g.fillRect(x,y,5,5);
	}



}
