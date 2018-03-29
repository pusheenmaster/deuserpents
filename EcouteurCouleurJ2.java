import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurCouleurJ2 implements ActionListener{
	private Color couleur;
	
	public EcouteurCouleurJ2(Color c){
		couleur=c;
	}	
	
	public void actionPerformed(ActionEvent E){
		FenetreParametre.creerJoueur2(couleur);
	}	
}
