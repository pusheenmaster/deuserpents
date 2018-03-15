import java.awt.*;
import javax.swing.*;

public class FenetreGraphiqueProjet extends JFrame{
	//constructeur
	public FenetreGraphiqueProjet(){
			
		//on definit le nom de la fenetre
        super("Fenêtre Graphique Projet");
        
        //Dimensions de la fenetre graphique et fermeture
        this.setSize(800,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création des éléments visibles sur la fenetre
        
         //Création du JPanel principal qui sert à organiser la fenetre
        JPanel cadrePrincipal = new JPanel(new BorderLayout()); // on l'organise en border pour pouvoir mettre le reste selon border
        //mise en place du conteneur principal dans la fenetre
        this.setContentPane(cadrePrincipal);
                
        // creation zone haut en blanche       Q1.1
    /*    JPanel monPanelCentre = new JPanel();
        monPanelCentre.setBackground(Color.WHITE);
        cadrePrincipal.add(monPanelCentre, BorderLayout.CENTER); 
      */
     
		// Terrain materialise le labyrinthe, elle remplace le panneau blanc de la fenêtre
		GrilleBloblo leTerrain = new GrilleBloblo();
        cadrePrincipal.add(leTerrain, BorderLayout.CENTER);

          //Rendre la fenêtre visible
        this.setVisible(true);

}
}
