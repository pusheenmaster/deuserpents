import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FenetreAccueil extends JFrame{
	//attributs
	private JPanel cadrePrincipal;
	private JPanel cadreColonne;
	private JLabel bienvenue;
	private JLabel ChoixNbrJoueurs;
	private JPanel nbrJoueurs;
	private JButton deuxJoueurs;
	private JButton troisJoueurs;
	private JLabel choixNomJoueurs;
	private JPanel entrerLesNoms;
	private JTextField nomJ1;
	private JTextField nomJ2;
	private JTextField nomJ3;
	private JButton continuer;
	//pour la difficulte
	private JLabel choixVitesse;
	private JPanel vitesse;
	private JButton lent;
	private JButton moyen;
	private JButton rapide;

	//constructeur
	public FenetreAccueil() {
        super("Tron");			// nom de la fenetre
        this.setSize(new Dimension(500,300));					//Dimensions de la fenetre graphique
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// et fermeture
        
        //Création des éléments visibles sur la fenetre
		JPanel cadrePrincipal = new JPanel(new BorderLayout());          //Création du JPanel principal qui sert à organiser la fenetre
        this.setContentPane(cadrePrincipal);						//mise en place du cadre principal dans la fenetre
       
        cadreColonne = new JPanel();
        cadreColonne.setLayout(new BoxLayout(cadreColonne, BoxLayout.PAGE_AXIS));      //Organisation du Panel en colonne
        cadrePrincipal.add(cadreColonne, BorderLayout.CENTER);							// On place le cadre colonne au centre
        
		bienvenue = new JLabel("Bienvenue dans TRON !");
		Font police = new Font("Tahoma", Font.BOLD, 20);		//Définition d'une police d'écriture
		bienvenue.setFont(police);	 							//On l'applique au JLabel
        cadreColonne.add(bienvenue);
        
        ChoixNbrJoueurs = new JLabel("             Nombre de joueurs :");
        cadreColonne.add(ChoixNbrJoueurs);
        
        nbrJoueurs = new JPanel(new FlowLayout());
        deuxJoueurs = new JButton("2 joueurs");
		nbrJoueurs.add(deuxJoueurs);
		deuxJoueurs.addActionListener(new EcouteurDeuxJoueurs());
		
		troisJoueurs = new JButton("3 joueurs");
		nbrJoueurs.add(troisJoueurs);
		troisJoueurs.addActionListener(new EcouteurTroisJoueurs());
		cadreColonne.add(nbrJoueurs);
		//on a selectionné le nbr de joueurs

		choixNomJoueurs = new JLabel("             Nom des joueurs :");
		
        entrerLesNoms = new JPanel(new FlowLayout());

        nomJ1 = new JTextField(10);
		nomJ2 = new JTextField(10);
		nomJ3 = new JTextField(10);

		continuer = new JButton("continuer");
		continuer.addActionListener(new EcouteurContinuer());
		
		
		//choix difficulte

        choixVitesse = new JLabel("             Vitesse :");
        vitesse = new JPanel(new FlowLayout());
        lent = new JButton("lent");
		vitesse.add(lent);
		lent.addActionListener(new EcouteurLent());
		
		moyen = new JButton("moyen");
		vitesse.add(moyen);
		moyen.addActionListener(new EcouteurMoyen());
		
		rapide = new JButton("rapide");
		vitesse.add(rapide);
		rapide.addActionListener(new EcouteurRapide());
		
		vitesse.add(lent);
		vitesse.add(moyen);
		vitesse.add(rapide);
		
		
	
	//	cadreColonne.add(nbrJoueurs);
		//on a selectionné le nbr de joueurs

      
	//	  this.repaint();
        //Rendre la fenêtre visible
        this.setVisible(true);
	}

	class EcouteurDeuxJoueurs implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("Vous avez choisi de jouer à deux.");
				cadreColonne.add(choixNomJoueurs);
				entrerLesNoms.add(nomJ1);
				entrerLesNoms.add(nomJ2);
				entrerLesNoms.remove(nomJ3);
				cadreColonne.add(entrerLesNoms);
				cadreColonne.add(continuer);
				revalidate();
			}
	}
	class EcouteurTroisJoueurs implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("Vous avez choisi de jouer à trois.");
				cadreColonne.add(choixNomJoueurs);
				entrerLesNoms.add(nomJ1);
				entrerLesNoms.add(nomJ2);
				entrerLesNoms.add(nomJ3);
				cadreColonne.add(entrerLesNoms);
				cadreColonne.add(continuer);
				revalidate();
			}
	}
		
	class EcouteurContinuer implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("On continue !");
				cadreColonne.add(choixVitesse);
				cadreColonne.add(vitesse);
				revalidate();
			}
	}
		
	class EcouteurLent implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("Vous avez choisi la vitesse lente.");
				revalidate();
			}
	}
	class EcouteurMoyen implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("Vous avez choisi la vitesse moyenne.");
				revalidate();
			}
	}
	class EcouteurRapide implements ActionListener{			    
			public void actionPerformed(ActionEvent e){
				System.out.println("Vous avez choisi la vitesse difficile.");
				revalidate();
			}
	}
}
