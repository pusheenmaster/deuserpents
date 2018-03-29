import java.awt.*;
import javax.swing.*;

public class FenetreJeu extends JFrame{
	//attributs
	
	//constructeur
	public FenetreJeu(/*Color couleurBackGround*/){
			
		//on definit le nom de la fenetre
        super("Fenêtre Graphique Projet");
        //Dimensions de la fenetre graphique et fermeture
        this.setSize(700,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création des éléments visibles sur la fenetre
        JPanel cadrePrincipal = new JPanel(new BorderLayout());
        //mise en place du cadre principal dans la fenetre
        this.setContentPane(cadrePrincipal);
        cadrePrincipal.setBackground(/*couleurBackGround*/Color.WHITE);  // la couleur du fond est donnee dans la FenetreParametre;
                
        // creation zone haut en blanche       Q1.1
    /*    JPanel monPanelCentre = new JPanel();
        monPanelCentre.setBackground(Color.WHITE);
        cadrePrincipal.add(monPanelCentre, BorderLayout.CENTER); 
      */
     
		// Terrain materialise le labyrinthe, elle remplace le panneau blanc de la fenêtre
		GrilleJeu leTerrain = new GrilleJeu();
		leTerrain.Commencer();
        cadrePrincipal.add(leTerrain, BorderLayout.CENTER);
        
    /*    //methode
        public GrilleJeu getGrille(){
			return leTerrain ;
		} */                //   Pour recup la Grille quon utilise, puis coord dans Grille

          //Rendre la fenêtre visible
        this.setVisible(true);
	}
}
