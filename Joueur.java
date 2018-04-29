import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Joueur {
	
	private int numJoueur ;
	private String nom ;
	
	private Color couleur ;
	
	private int x ;
	private int y ;
	
	private GrilleJeu terrain ;
	
	private int direction ;
	
	private Point [][] trainee; 
	
	int xDepart = 0 ;
	int yDepart = 0 ;
	
	private int score;
	
	public Joueur(int num, String nom, Color couleur, GrilleJeu grille) {
		
		numJoueur = num ;
		this.nom = nom ;
		this.couleur = couleur ;
		
		terrain = grille ;
		
		if (numJoueur==1) {
			yDepart = 4 ;
			xDepart = (int)((Math.random())*(terrain.getNbColonnes())*0.4);
			if(xDepart<5){
				xDepart=5 ;
			}	
			
			this.direction = 2;
			
		} else if (numJoueur ==2) {
			yDepart = terrain.getNbLignes()-5 ;
			xDepart = (int)((Math.random())*(terrain.getNbColonnes())*0.4);
			if(xDepart<5){
				xDepart=5 ;
			}	
			
			this.direction = 8;
			
		} else if (numJoueur ==3) {
			xDepart = terrain.getNbColonnes()-5 ;
			yDepart = (int)((Math.random())*(terrain.getNbLignes())-5);
			if(yDepart<5){
				xDepart=5 ;
			}	
			
			this.direction = 4;
		}
		
		x=xDepart;
		y=yDepart;
		
		score=0;
		
		trainee = new Point [terrain.getNbLignes()][terrain.getNbColonnes()];
	}
	
	public void dessiner(Graphics g, int w, int h) {
		int x1 = x*w/terrain.getNbColonnes();
        int y1 = y*h/terrain.getNbLignes();
        
        g.setColor(Color.BLACK);
        
        g.fillRect(x1,y1,terrain.getLargeurCase(),terrain.getHauteurCase());
      
    }
    
	public void deplacer(int deltaX, int deltaY){

		trainee[x][y]= new Point(x,y); ///ultra important pour pas de vide
		x=x+deltaX;
        y=y+deltaY;
        
	}
		
	public Color getCouleur(){
		return couleur ;
	}
	
	public void changDirection(int nDir){
		direction=nDir;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void creerTrainee(Graphics g, int w, int h){
		
		if(direction==2)
			trainee[x][y-1]= new Point(x, y-1);
			
		if(direction==8)
			trainee[x][y+1]=new Point(x, y+1);
			
			
		if(direction==6)
			trainee[x-1][y]= new Point(x-1,y);
			
		if(direction==4)
			trainee[x+1][y]=new Point(x+1, y);
			
		
		///affichage trainee
		for (int i=0; i<trainee.length; i++){
			for (int j=0; j<trainee[1].length; j++){
				if(trainee[i][j]!=null){
					int x1 = i*w/terrain.getNbColonnes();
					int y1 = j*h/terrain.getNbLignes();
					g.setColor(couleur);
					g.fillRect(x1,y1,terrain.getLargeurCase(),terrain.getHauteurCase());
				}
			}
		}			
	}
	
	public Point [][] getTrainee(){
		return trainee;
	}
	
	public int getX(){
		return x;
	}
	
		public int getY(){
		return y;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(){
		score++;
	}
	
	public String getNom(){
		return nom;
	}			
	
	public void accidentBordure(){
		
		///accident bordure en utilisant le tableau de grilleJeu
		for (int i=0; i<terrain.getTab().length; i++){
			for (int j=0; j<terrain.getTab()[0].length; j++){
					if(terrain.getTab()[i][j] != null && x==terrain.getTab()[i][j].getX() && y==terrain.getTab()[i][j].getY()){
						System.out.println("collision murs");
						effacerTrainee();
						resetTrainee();
						score--;
					}
			}		
		}
	}		
		
	public void accidentTrainee(){
		
		///collision avec sa propre trainee
			for (int i=0; i<trainee.length; i++){
				for (int j=0; j<trainee[0].length; j++){
					if(trainee[i][j]!=null && x==trainee[i][j].getX() && y==trainee[i][j].getY()){
						System.out.println("Collision avec sa trainee");
						effacerTrainee();
						resetTrainee();
						score --;
					}
				}
			}		
	}
	
	public void effacerTrainee(){
		for (int i=0; i<trainee.length; i++){
				for (int j=0; j<trainee[0].length; j++){
					trainee[i][j]=null;
				}
		}
	}
	
	
	
	public void resetTrainee(){
		
		x=xDepart;
		y=yDepart;
		
		if(numJoueur==1)
			this.direction=2;
			
		else if(numJoueur==2)
			this.direction=8;
		
		else if(numJoueur==3)
			this.direction=4;	
	}
	
	public void mooveOfPlayer(){
		
		if(getDirection()==8){
			deplacer(0,-1);
		}
		if(getDirection()==2){
			deplacer(0,1);
		}
		if(getDirection()==6){
			deplacer(1,0);
		}
		if(getDirection()==4){
			deplacer(-1,0);
		}
	}	
}		
	
	


