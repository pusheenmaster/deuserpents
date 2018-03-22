public class TestGrille{
	
	public static void main(String[] args){
		GrilleJeu tablo1= new GrilleJeu();
		tablo1.Commencer();
		System.out.println(tablo1.toString());
		
		System.out.println(tablo1.getHaut() + " et " + tablo1.getLarg());
		
		FenetreJeu f = new FenetreJeu();
		//System.out.println("longueur "+f.getLongueur()+"largeur"+f.getLargeur());  // je veux recuperer les dimensions du panneau central
    }
		
		

}



