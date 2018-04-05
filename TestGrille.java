import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TestGrille{
	
	public static void main(String[] args){
		GrilleJeu tablo1= new GrilleJeu();
		tablo1.Commencer();
		System.out.println(tablo1.toString());
		
	//	System.out.println(tablo1.getGrille().getHaut() + " et " + tablo1.getGrille.getLarg());  ////// a revoir
		
		FenetreJeu f = new FenetreJeu();
		//System.out.println("longueur "+f.getLongueur()+"largeur"+f.getLargeur());  // je veux recuperer les dimensions du panneau central
	}
		
    
		
		

}



