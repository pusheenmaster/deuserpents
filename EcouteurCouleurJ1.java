import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurCouleurJ1 implements ActionListener{
	private Color couleur;
	
	public EcouteurCouleurJ1(Color c){
		couleur=c;
	}	
	
	public void actionPerformed(ActionEvent E){
		FenetreParametre.creerJoueur1(couleur);
	}	
}