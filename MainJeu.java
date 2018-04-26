import java.util.Scanner;

public class MainJeu{
	
	public static void main(String[] args){
		
		int nbrJoueur;
		int ms=0;
		
		String nom3 = "";
		
		System.out.println("Nombre de joueurs (tapez 2 ou 3):");
		Scanner nb = new Scanner(System.in);
		nbrJoueur = nb.nextInt();
		
		System.out.println("Nom joueur1:");
		Scanner n1 = new Scanner(System.in);
		String nom1 = n1.nextLine();
		
		System.out.println("Nom joueur2:");
		Scanner n2 = new Scanner(System.in);
		String nom2 = n2.nextLine();
		
		if(nbrJoueur==3){
		System.out.println("Nom joueur3:");
		Scanner n3 = new Scanner(System.in);
		nom3 = n3.nextLine();
		} else { nom3 ="NoPlayer";}
		
		System.out.println("Quelle difficule ? Tapez 1, 2 ou 3 (3 -> difficile)");
		Scanner niv = new Scanner(System.in);
		int difficulte = niv.nextInt();
			
		if (difficulte == 1)
			ms = 100;
		if (difficulte == 2)
			ms = 75;
		if (difficulte == 3)
			ms = 50;
		
		new FenetreJeu(nbrJoueur, nom1, nom2, nom3, ms);
		
	}
		
    
		
		

}



