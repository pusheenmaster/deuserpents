import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MaFenetreDebut extends JFrame{
	//attributs
	private JPanel cadrePrincipal;
	JPanel cadreColonne;
	JLabel bienvenue;
	JLabel ChoixNbrJoueurs;
	JPanel NbrJoueurs;
	JButton deuxJoueurs;
	JButton troisJoueurs;
	JLabel ChoixNomJoueurs;
	JLabel test1;
	JLabel test2;



	
	//JPanel auNORD;

	
	//constructeur
	public MaFenetreDebut() {
		
        super("Tron");			// nom de la fenetre
        //Dimensions de la fenetre graphique et fermeture
        this.setSize(new Dimension(500,200));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création des éléments visibles sur la fenetre
         //Création du JPanel principal qui sert à organiser la fenetre
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		//mise en place du cadre principal dans la fenetre
        this.setContentPane(cadrePrincipal);
       
        JPanel cadreColonne = new JPanel();
        cadreColonne.setLayout(new BoxLayout(cadreColonne, BoxLayout.PAGE_AXIS));       

        cadrePrincipal.add(cadreColonne, BorderLayout.CENTER);
        
   //     JPanel auNORD = new JPanel();
    //    cadrePrincipal.add(auNORD, BorderLayout.NORTH);

        
        //creation du JPanel commande ds lequel on va placer les widget
    //    JPanel monPanelCommande = new JPanel(new FlowLayout()); //la ligne de commande est en ligne
		
		bienvenue = new JLabel("Bienvenue dans TRON !");
		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 20);
		//On l'applique au JLabel
		bienvenue.setFont(police);	 
        cadreColonne.add(bienvenue);
        
        ChoixNbrJoueurs = new JLabel("             Nombre de joueurs :");
        cadreColonne.add(ChoixNbrJoueurs);
        
        JPanel nbrJoueurs = new JPanel(new FlowLayout());
        deuxJoueurs = new JButton("2 joueurs");
		nbrJoueurs.add(deuxJoueurs);
		troisJoueurs = new JButton("3 joueurs");
		nbrJoueurs.add(troisJoueurs);
		
		cadreColonne.add(nbrJoueurs);
		
		
		test1 = new JLabel("Le Test");

		cadreColonne.add(test1);

		
        
  //    ChoixNomJoueurs = new JLabel(" Nom du joueur  ");
   //   cadreColonne.add(ChoixNomJoueurs);
       deuxJoueurs.addActionListener(new EcouteurDeuxJoueurs(this));
       // troisJoueurs.addActionListener(new EcouteurTroisJoueurs(this));
        
        class EcouteurDeuxJoueurs implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				test1.setText("Vous avez cliqué sur le bouton 2"); 
				System.out.println("Vous avez choisi de jouer à deux.");
				cadreColonne.add(test1);
				cadreColonne.revalidate();
				cadreColonne.repaint();

			//	this.setVisible(true);
			}
		}     



	//	  this.repaint();
        //Rendre la fenêtre visible
        this.setVisible(true);
	}

}
