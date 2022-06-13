package partie;

import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		
		// A Compléter
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres(); // On ouvre la fenêtre de paramètrage pour la saisie
		Plateau plateau=new Plateau();
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);

		// Création de la fenêtre de jeu et affichage de la fenêtre
		int nbJoueurs=joueurs.length; // Récupération du nombre de joueurs
		IG.creerFenetreJeu("Labyrinthe", nbJoueurs); // On crée la fenêtre
		IG.rendreVisibleFenetreJeu();

	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		// A Compléter
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}
