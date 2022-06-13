package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 *  
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 oièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée à la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribuées aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		
		// A Compléter
		// Affectation de l'argument aux données
		this.joueurs = joueurs;

		// Initialisation du plateau
		this.plateau = new Plateau();
		this.pieceLibre=this.plateau.placerPiecesAleatoierment();
		for(int i=0; i<7; i++){
			for(int j=0; j<7; j++){
				IG.changerPiecePlateau(i, j, (this.plateau.getPiece(i, j)).getModelePiece(), (this.plateau.getPiece(i, j)).getOrientationPiece());
			}
		}
		IG.changerPieceHorsPlateau(this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());

		// Création des objets avec une position aléatoire
		this.objets = Objet.nouveauxObjets();
		for(int i=0; i< this.objets.length; i++){
			IG.placerObjetPlateau(this.objets[i].getNumeroObjet(), this.objets[i].getPosLignePlateau(),this.objets[i].getPosColonnePlateau());
		}

		// Affectation des objets aux joueurs
		attribuerObjetsAuxJoueurs();
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	private void attribuerObjetsAuxJoueurs(){
	
		// A Compléter
		this.objets = Objet.nouveauxObjets();
		int[] tab = Utils.genereTabIntAleatoirement(18);
		Objet[] liste_objet = new Objet[6];
		int inc = 0;
		for(int i =0; i<this.joueurs.length; i++){
			for(int j=0; j<liste_objet.length; j++){
				liste_objet[j] = this.objets[tab[inc]];
				inc++;
			}
			this.joueurs[i].setObjetsJoueur(liste_objet);
		}
		for(int i=0; i<this.joueurs.length; i++){
			for(int j=0; j<6; j++){
				IG.changerObjetJoueurAvecTransparence(i, this.joueurs[i].getObjetsJoueur()[j].getNumeroObjet(), j);
			}
		}
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return this.joueurs; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return this.objets; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return this.plateau; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return this.pieceLibre; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return this.nombreJoueurs; // A Modifier
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite à l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){
		// A Compléter
		if((choixEntree/7) == 0){
			Piece temp = this.plateau.getPiece(6, choixEntree);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(6-i, choixEntree, this.plateau.getPiece(6-i-1, choixEntree).getModelePiece(), this.plateau.getPiece(6-i-1, choixEntree).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(6-i-1, choixEntree), 6-i, choixEntree);
			}
			IG.changerPiecePlateau(0, choixEntree, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, 0, choixEntree);
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 1){
			Piece temp = this.plateau.getPiece(choixEntree%7, 0);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(choixEntree%7, i, this.plateau.getPiece(choixEntree%7, i+1).getModelePiece(), this.plateau.getPiece(choixEntree%7, i+1).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(choixEntree%7, i+1), choixEntree%7, i);
			}
			IG.changerPiecePlateau(choixEntree%7, 6, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, choixEntree%7, 6);
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 2){
			Piece temp = this.plateau.getPiece(0, 6-(choixEntree%7));
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(i, 6-(choixEntree%7), this.plateau.getPiece(i+1, 6-(choixEntree%7)).getModelePiece(), this.plateau.getPiece(i+1, 6-(choixEntree%7)).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(i+1, 6-(choixEntree%7)), i, 6-(choixEntree%7));
			}
			IG.changerPiecePlateau(6, 6-(choixEntree%7), this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre, 6, 6-(choixEntree%7));
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
		else if((choixEntree/7) == 3){
			Piece temp = this.plateau.getPiece(6-(choixEntree%7), 6);
			for(int i=0; i<6; i++){
				IG.changerPiecePlateau(6-(choixEntree%7), 6-i, this.plateau.getPiece(6-(choixEntree%7), 6-i-1).getModelePiece(), this.plateau.getPiece(6-(choixEntree%7), 6-i-1).getOrientationPiece());
				this.plateau.positionnePiece(this.plateau.getPiece(6-(choixEntree%7), 6-i-1), 6-(choixEntree%7), 6-i);
			}
			IG.changerPiecePlateau(6-(choixEntree%7), 0, this.pieceLibre.getModelePiece(), this.pieceLibre.getOrientationPiece());
			this.plateau.positionnePiece(this.pieceLibre,6-(choixEntree%7), 0 );
			this.pieceLibre = temp;
			IG.changerPieceHorsPlateau(temp.getModelePiece(), temp.getOrientationPiece());
			IG.miseAJourAffichage();
		}
	}


	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}
