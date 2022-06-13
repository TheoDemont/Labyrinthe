package composants;

/**
 * Cette classe permet de gérer un plateau de jeu constitué d'une grille de pièces (grille de 7 lignes sur 7 colonnes).
 *
 */
public class Plateau {

	private Piece plateau[][]; // La grille des pièces.

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de construire un plateau vide (sans pièces) et d'une taille de 7 lignes sur 7 colonnes.
	 */
	public Plateau() {
		// A Compléter
		this.plateau = new Piece[7][7];
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de placer une pièce sur le plateau.
	 * 
	 * @param piece La pièce à placer.
	 * @param lignePlateau La ligne du plateau sur laquelle sera placée la pièce (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau sur laquelle sera placée la pièce (une entier entre 0 et 6).
	 */
	public void positionnePiece(Piece piece,int lignePlateau,int colonnePlateau){
		// A Compléter
		this.plateau[lignePlateau][colonnePlateau] = piece;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode retournant une pièce se trouvant sur le plateau à un emplacement spécifique.
	 * 
	 * @param lignePlateau La ligne du plateau  (un entier entre 0 et 6).
	 * @param colonnePlateau La colonne du plateau (un entier entre 0 et 6).
	 * @return La pièce se trouvant sur la ligne lignePlateau et la colonne colonnePlateau. Si il n'y a pas de pièce, null est retourné.
	 */
	public Piece getPiece(int lignePlateau,int colonnePlateau){
		return this.plateau[lignePlateau][colonnePlateau]; // A Modfier
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 *  
	 * Méthode permettant de placer aléatoirment 49 pièces du jeu sur le plateau.
	 * L'orientation des pièces est aléatoire. Les pièces utilisées doivent être des nouvelles pièces générées à partir de la méthode Piece.nouvellesPieces.
	 * Parmi les 50 pièces du jeu, la pièce qui n'a pas été placée sur le plateau est retournée par la méthode.
	 * 
	 * @return La seule pièce qui n'a pas été placée sur le plateau
	 */
	public Piece placerPiecesAleatoierment(){
		// A Compléter
		Piece[] tab = Piece.nouvellesPieces();
		int compteur = 0;
		for(int i=0; i<7; i++){
			for(int j=0; j<7; j++){
				this.plateau[i][j] = tab[compteur];
				compteur++;
			}
		}
		return tab[49]; // A Modfier
	}

	/**
	 * 
	 * Méthode utilitaire permettant de tester si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes d'une grille de 7 lignes sur 7 colonnes.
	 *  
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les les positions passées en paramètre sont les positions de deux cases différentes et adjacentes d'une grille de 7 lignes sur 7 colonnes, false sinon.
	 */
	private static boolean casesAdjacentes(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		if ((posLigCase1<0)||(posLigCase2<0)||(posLigCase1>6)||(posLigCase2>6)) return false;
		if ((posColCase1<0)||(posColCase2<0)||(posColCase1>6)||(posColCase2>6)) return false;
		int distLigne=posLigCase1-posLigCase2;
		if (distLigne<0) distLigne=-distLigne;
		int distColonne=posColCase1-posColCase2;
		if (distColonne<0) distColonne=-distColonne;
		if ((distLigne>1)||(distColonne>1)||((distColonne+distLigne)!=1))
			return false;
		return true;
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de tester si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes 
	 * de la grille de jeu et qu'il est possible de passer d'une cas à l'autre compte tenu des deux pièces posées sur les deux cases du plateau.
	 * 
	 * @param posLigCase1 Un entier quelconque.
	 * @param posColCase1 Un entier quelconque.
	 * @param posLigCase2 Un entier quelconque.
	 * @param posColCase2 Un entier quelconque.
	 * @return true si les positions passées en paramètre sont les positions de deux cases différentes et adjacentes de la grille de jeu et qu'il est possible de passer d'une cas à l'autre compte tenu des deux pièces posées sur les deux cases du plateau, false sinon.
	 */
	private boolean passageEntreCases(int posLigCase1,int posColCase1,int posLigCase2,int posColCase2){
		
		// A Compléter
		Piece PieceCase1 =  getPiece(posLigCase1, posColCase1);
		Piece PieceCase2 = getPiece(posLigCase2, posColCase2);

		//Piece PieceCase1 = this.plateau[posLigCase1][posColCase1];
		//Piece PieceCase2 = this.plateau[posLigCase2][posColCase2];

		if(((posColCase1 != posColCase2 && posLigCase1 == posLigCase2) || (posColCase1 == posColCase2 && posLigCase1 != posLigCase2)) && casesAdjacentes(posLigCase1, posColCase1, posLigCase2, posColCase2)){
			if(posLigCase1 == posLigCase2){
				if(posColCase1 < posColCase2){
					return (PieceCase1.getPointEntree(1) && PieceCase2.getPointEntree(3));
				}
				else return (PieceCase1.getPointEntree(3) && PieceCase2.getPointEntree(1));
			}
			else {
				if(posLigCase1 < posLigCase2){
					return (PieceCase1.getPointEntree(2) && PieceCase2.getPointEntree(0));
				}
				else return (PieceCase1.getPointEntree(0) && PieceCase2.getPointEntree(2));
			}
		}
		else return false; // A Modifier
	}

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de retourner un éventuel chemin entre deux cases du plateau compte tenu des pièces posées sur le plateau.
	 * Dans le cas où il n'y a pas de chemin entre les deux cases, la valeur null est retournée.
	 * Dans le cas où il existe un chemin, un chemin possible est retourné sous forme d'un tableau d'entiers à deux dimensions.
	 * La première dimension correspond aux cases du plateau à emprunter pour aller de la case de départ à la case d'arrivée.
	 * Dans ce tableau, chaque case est un tableau de deux entiers avec le premier entier qui correspond à la ligne de la case et
	 * le second entier qui correspond à la colonne de la case. La première case d'un chemin retourné correspond toujours 
	 * à la case (posLigCaseDep,posColCaseDep) et la dernière case correspond toujours à la case (posLigCaseArr,posColCaseArr).
	 *
	 * @param posLigCaseDep La ligne de la case de départ (un entier compris entre 0 et 6).
	 * @param posColCaseDep La colonne de la case de départ (un entier compris entre 0 et 6).
	 * @param posLigCaseArr La ligne de la case d'arrivée (un entier compris entre 0 et 6).
	 * @param posColCaseArr La colonne de la case d'arrivée (un entier compris entre 0 et 6).
	 * @return null si il n'existe pas de chemin entre les deux case, un chemin sinon.
	 */
	public int[][] calculeChemin(int posLigCaseDep,int posColCaseDep,int posLigCaseArr,int posColCaseArr){
		/*
		 * Étape 1 : Modéliser l'ensemble des chemins possibles depuis la case départ.
		 * 	sous étape 1 :
		 * Étape 2 : Récupérer le chemin le plus court depuis le tableau récupérant l'ensemble des chemins possible.
		 * Étape 3 : Adapter resultat[][] pour qu'il retourne le chemin résultat conformément à ce qui est demandé.
		 */
		/**
		// création d'un tableau qui va enregistrer les pièces présentes sur tous les chemins possible de la pièce de départ
		int[][] totalPiece = new int[49][2];
		// affectation de la valeur null, celle-ci sera utile pour la boucle while
		for(int i = 0; i<49; i++){
			totalPiece[i][0] = -1;
			totalPiece[i][1] = -1;
		}
		// affectation de la pièce de départ à la liste
		totalPiece[0][0] = posLigCaseDep;
		totalPiece[0][1] = posColCaseDep;
		boolean verif = true;
		int inc_boucle = 0;
		int inc_placement = 0;
		// obtention de l'ensemble des pièces sur lesquels on peut aller
		while((totalPiece[inc_boucle][0] != -1) && (totalPiece[inc_boucle][0] != -1) && inc_boucle<49){
			int posLigCaseActu = totalPiece[inc_boucle][0];
			int posColCaseActu = totalPiece[inc_boucle][1];
			//Haut
			if(posLigCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)){
				for(int j=0; j<totalPiece.length; j++){
					if(totalPiece[j][0]==posLigCaseActu-1 && totalPiece[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					totalPiece[inc_placement + 1][0] = posLigCaseActu - 1;
					totalPiece[inc_placement + 1][1] = posColCaseActu;
					inc_placement++;
				}
				verif = true;
			}
			//Droite
			if(posColCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu+1)){
				for(int j=0; j<totalPiece.length; j++){
					if(totalPiece[j][0]==posLigCaseActu && totalPiece[j][1]==posColCaseActu+1) verif = false;
				}
				if(verif) {
					totalPiece[inc_placement + 1][0] = posLigCaseActu;
					totalPiece[inc_placement + 1][1] = posColCaseActu + 1;
					inc_placement++;
				}
				verif = true;
			}
			//Bas
			if(posLigCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)){
				for(int j=0; j<totalPiece.length; j++){
					if(totalPiece[j][0]==posLigCaseActu+1 && totalPiece[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					totalPiece[inc_placement + 1][0] = posLigCaseActu + 1;
					totalPiece[inc_placement + 1][1] = posColCaseActu;
					inc_placement++;
				}
				verif = true;
			}
			//Gauche
			if(posColCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)){
				for(int j=0; j<totalPiece.length; j++){
					if(totalPiece[j][0]==posLigCaseActu && totalPiece[j][1]==posColCaseActu-1) verif = false;
				}
				if(verif) {
					totalPiece[inc_placement + 1][0] = posLigCaseActu;
					totalPiece[inc_placement + 1][1] = posColCaseActu - 1;
					inc_placement++;
				}
				verif = true;
			}
			inc_boucle++;
		}

		// renvoie null si la pièce d'arrivé n'existe pas dans la liste
		for(int i=0; i< totalPiece.length; i++){
			if(totalPiece[i][0] == posLigCaseArr && totalPiece[i][1] == posColCaseArr) return null;
		}
		*/
		/*

		Explication de la suite du processus :
		Création d'un chemin initial qui sera réaffecté et qui nous servira de repère
		test dans une boucle while par ordre inverse du chemin initial afin de récupérer les points d'intersections
		2 branches
		si points d'intersection :
		- ajout de la piece dans une liste exception
		- récupération de la piece de la branche secondaire par exception si piece n'est pas dans chmemin initial
		- récupération de la première partie du chemin de la branche commune jusqu'à la pièce d'intersection
		- ajout de la seconde partie du chemin à partir du même procédé que la création du chemin initial
		- affectation d'un nouveau chemin initial à partir du chemin créé

		! pbm si 3 branches mais impossible puisque pointsEntréesMax = 3 _|_, ___ et _|

		 */
		/**
		// obtention d'un premier chemin
		int[][] chemin_initial = new int[49][2];

		// affectation de la valeur null à la liste
		for(int i = 0; i<49; i++){
			chemin_initial[i][0] = -1;
			chemin_initial[i][1] = -1;
		}

		// affectation de la pièce de départ à la liste
		chemin_initial[0][0] = posLigCaseDep;
		chemin_initial[0][1] = posColCaseDep;
		verif = true;
		int inc = 0;

		// boucle
		while(chemin_initial[inc][0] != -1 && chemin_initial[inc][1] != -1 && inc_boucle<49){
			int posLigCaseActu = chemin_initial[inc][0];
			int posColCaseActu = chemin_initial[inc][1];
			//Haut
			if(posLigCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)){
				for(int j=0; j<chemin_initial.length; j++){
					if(chemin_initial[j][0]==posLigCaseActu-1 && chemin_initial[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					chemin_initial[inc + 1][0] = posLigCaseActu - 1;
					chemin_initial[inc + 1][1] = posColCaseActu;
					verif = false;
				}
			}
			//Droite
			if(posColCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu+1)){
				for(int j=0; j<chemin_initial.length; j++){
					if(chemin_initial[j][0]==posLigCaseActu && chemin_initial[j][1]==posColCaseActu+1) verif = false;
				}
				if(verif) {
					chemin_initial[inc + 1][0] = posLigCaseActu;
					chemin_initial[inc + 1][1] = posColCaseActu + 1;
					verif = false;
				}
			}
			//Bas
			if(posLigCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)){
				for(int j=0; j<chemin_initial.length; j++){
					if(chemin_initial[j][0]==posLigCaseActu+1 && chemin_initial[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					chemin_initial[inc + 1][0] = posLigCaseActu+1;
					chemin_initial[inc + 1][1] = posColCaseActu;
					verif = false;
				}
			}
			//Gauche
			if(posColCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)){
				for(int j=0; j<chemin_initial.length; j++){
					if(chemin_initial[j][0]==posLigCaseActu && chemin_initial[j][1]==posColCaseActu-1) verif = false;
				}
				if(verif) {
					chemin_initial[inc + 1][0] = posLigCaseActu;
					chemin_initial[inc + 1][1] = posColCaseActu - 1;
					verif = false;
				}
			}
			inc++;
			verif = true;
		}

		/**
		 * Trouver chemin contenant la solution
		 */
		/**
		// initialisation
		int[][] cheminActuel = new int[49][2];
		int[][] piece_branche = new int[totalPiece.length][2];
		int inc_piece_branche = 0;

		for(int i=0; i< totalPiece.length; i++){
			if(totalPiece[i][0]!=-1 || totalPiece[i][1]!=-1) {
				if (getPiece(totalPiece[i][0], totalPiece[i][1]).getModelePiece() == 2) {
					piece_branche[inc_piece_branche][0] = totalPiece[i][0];
					piece_branche[inc_piece_branche][1] = totalPiece[i][1];
				}
			}
		}

		for(int i =0; i<cheminActuel.length; i++){
			cheminActuel[i][0] = -1;
			cheminActuel[i][1] = -1;
		}

		cheminActuel[0][0] = posLigCaseDep;
		cheminActuel[0][1] = posColCaseDep;

		inc = 0;
		int posLigCaseActu = -1;
		int posColCaseActu = -1;
		verif = true;


		//intialisation chemin initial

		while(cheminActuel[inc][0]!=(-1) && cheminActuel[inc][1]!=(-1)){
			posLigCaseActu = cheminActuel[inc][0];
			posColCaseActu = cheminActuel[inc][1];
			if(posLigCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)){
				for(int j=0; j<cheminActuel.length; j++){
					if(cheminActuel[j][0]==posLigCaseActu-1 && cheminActuel[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					cheminActuel[inc + 1][0] = posLigCaseActu - 1;
					cheminActuel[inc + 1][1] = posColCaseActu;
					inc++;
				}
				verif = true;
			}
			//Droite
			 else if(posColCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu+1)){
				for(int j=0; j<cheminActuel.length; j++){
					if(cheminActuel[j][0]==posLigCaseActu && cheminActuel[j][1]==posColCaseActu+1) verif = false;
				}
				if(verif) {
					cheminActuel[inc + 1][0] = posLigCaseActu;
					cheminActuel[inc + 1][1] = posColCaseActu + 1;
					inc++;
				}
				verif = true;
			}
			//Bas
			else if(posLigCaseActu<6 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)){
				for(int j=0; j<cheminActuel.length; j++){
					if(cheminActuel[j][0]==posLigCaseActu+1 && cheminActuel[j][1]==posColCaseActu) verif = false;
				}
				if(verif) {
					cheminActuel[inc + 1][0] = posLigCaseActu + 1;
					cheminActuel[inc + 1][1] = posColCaseActu;
					inc++;
				}
				verif = true;
			}
			//Gauche
			else if(posColCaseActu>0 && passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)){
				for(int j=0; j<cheminActuel.length; j++){
					if(cheminActuel[j][0]==posLigCaseActu && cheminActuel[j][1]==posColCaseActu-1) verif = false;
				}
				if(verif) {
					cheminActuel[inc + 1][0] = posLigCaseActu;
					cheminActuel[inc + 1][1] = posColCaseActu - 1;
					inc++;
				}
				verif = true;
			}
			inc_boucle++;
		}
		return cheminActuel;

		/*
		//int[][] pieceException = new int[49][2];
		//int[][] cheminActuel = new int[49][2];
		//int[][] cheminTemoin = new int[49][2];
		for(int i=0; i<chemin_initial.length; i++){
			for(int j=0; j< chemin_initial[0].length; j++){
				cheminActuel[i][j] = chemin_initial[i][j];
			}
		}
		cheminActuel[0][0] = posLigCaseDep;
		cheminActuel[0][1] = posColCaseDep;
		verif = true;
		boolean non_fini = true;
		boolean verif_exception = true;
		int inc_chemin = 0;
		int inc_exception = 0;

		// tant que le chemin n'est pas trouvé
		while(non_fini){
			for(int i=0; i<cheminActuel.length; i++){
				// Si le chemin est trouvé, la boucle s'arrete
				if(cheminActuel[i][0]==posLigCaseArr && cheminActuel[i][1]==posColCaseArr)non_fini=false;
			}
			// Si la boucle ne s'arrete pas
			if(non_fini){

			}
		}
		*/
		/*
		while(non_fini){
			for(int i=0; i<cheminActuel.length; i++){
				if(cheminActuel[i][0]==posLigCaseArr && cheminActuel[i][1]==posColCaseArr)non_fini=false;
			}
			if(non_fini){
				for(int i=0; i<cheminActuel.length; i++){
					if((getPiece(cheminActuel[-i][0],cheminActuel[-i][1])).getModelePiece()==2){
						pieceException[inc_exception][0] = cheminActuel[-i][0];
						pieceException[inc_exception][1] = cheminActuel[-i][1];
					}
					inc_exception++;
					for(int g=0; g<i; g++){
						//Haut
						if(cheminActuel[-i+g][0]>0 && passageEntreCases(cheminActuel[-i+g][0],cheminActuel[-i+g][1],cheminActuel[-i+g][0]-1,cheminActuel[-i+g][1])){
							for(int j=0; j<cheminActuel.length-i; j++){
								if(cheminActuel[j][0]==cheminActuel[-i+g][0]-1 && cheminActuel[j][1]==cheminActuel[-i+g][1]) verif = false;
							}

							for(int k=0; k<pieceException.length; k++){
								if((cheminActuel[-i+g][0]-1)==pieceException[k][0]&&(cheminActuel[-i+g][1])==pieceException[k][1]){
									verif_exception = false;
								}
							}

							if(verif && verif_exception) {
								cheminActuel[-i+g+1][0] = cheminActuel[-i+g][0] - 1;
								cheminActuel[-i+g+1][1] = cheminActuel[-i+g][1];
								verif = false;
							}
							verif_exception=true;
						}
						//Droite
						if(cheminActuel[-i+g][1]<6 && passageEntreCases(cheminActuel[-i+g][0],cheminActuel[-i+g][1],cheminActuel[-i+g][0],cheminActuel[-i+g][1]+1)){
							for(int j=0; j<cheminActuel.length-i; j++){
								if(cheminActuel[j][0]==cheminActuel[-i+g][0] && cheminActuel[j][1]==cheminActuel[-i+g][1]+1) verif = false;
							}

							for(int k=0; k<pieceException.length; k++){
								if((cheminActuel[-i+g][0])==pieceException[k][0]&&(cheminActuel[-i+g][1]+1)==pieceException[k][1]){
									verif_exception = false;
								}
							}

							if(verif && verif_exception) {
								cheminActuel[-i+g+1][0] = cheminActuel[-i+g][0];
								cheminActuel[-i+g+1][1] = cheminActuel[-i+g][1]+1;
								verif = false;
							}
							verif_exception=true;
						}
						//Bas
						if(cheminActuel[-i+g][0]<6 && passageEntreCases(cheminActuel[-i+g][0],cheminActuel[-i+g][1],cheminActuel[-i+g][0]+1,cheminActuel[-i+g][1])){
							for(int j=0; j<cheminActuel.length-i; j++){
								if(cheminActuel[j][0]==cheminActuel[-i+g][0]+1 && cheminActuel[j][1]==cheminActuel[-i+g][1]) verif = false;
							}

							for(int k=0; k<pieceException.length; k++){
								if((cheminActuel[-i+g][0]+1)==pieceException[k][0]&&(cheminActuel[-i+g][1])==pieceException[k][1]){
									verif_exception = false;
								}
							}

							if(verif && verif_exception) {
								cheminActuel[-i+g+1][0] = cheminActuel[-i+g][0] + 1;
								cheminActuel[-i+g+1][1] = cheminActuel[-i+g][1];
								verif = false;
							}
							verif_exception=true;
						}
						//Gauche
						if(cheminActuel[-i+g][1]>0 && passageEntreCases(cheminActuel[-i+g][0],cheminActuel[-i+g][1],cheminActuel[-i+g][0],cheminActuel[-i+g][1]-1)){
							for(int j=0; j<cheminActuel.length-i; j++){
								if(cheminActuel[j][0]==cheminActuel[-i+g][0] && cheminActuel[j][1]==cheminActuel[-i+g][1]-1) verif = false;
							}

							for(int k=0; k<pieceException.length; k++){
								if((cheminActuel[-i+g][0])==pieceException[k][0]&&(cheminActuel[-i+g][1]-1)==pieceException[k][1]){
									verif_exception = false;
								}
							}

							if(verif && verif_exception) {
								cheminActuel[-i+g+1][0] = cheminActuel[-i+g][0];
								cheminActuel[-i+g+1][1] = cheminActuel[-i+g][1]-1;
								verif = false;
							}
							verif_exception=true;
						}
					}

					inc_chemin = i+1;
					for(int k=inc_chemin; k<cheminActuel.length; k++){
						//Haut
						if(cheminActuel[k][0]>0 && passageEntreCases(cheminActuel[k][0],cheminActuel[k][1],cheminActuel[k][0]-1,cheminActuel[k][1])){
							for(int j=0; j<cheminActuel.length; j++){
								if(chemin_initial[j][0]==cheminActuel[k][0]-1 && cheminActuel[j][0]==cheminActuel[k][0]) verif = false;
							}
							if(verif) {
								cheminActuel[k+1][0] = cheminActuel[k][0] - 1;
								cheminActuel[k+1][1] = cheminActuel[k][1];
								verif = false;
							}
						}
						//Droite
						if(cheminActuel[k][1]<6 && passageEntreCases(cheminActuel[k][0],cheminActuel[k][1],cheminActuel[k][0],cheminActuel[k][1]+1)){
							for(int j=0; j<cheminActuel.length; j++){
								if(chemin_initial[j][0]==cheminActuel[k][0] && cheminActuel[j][0]==cheminActuel[k][0]+1) verif = false;
							}
							if(verif) {
								cheminActuel[k+1][0] = cheminActuel[k][0];
								cheminActuel[k+1][1] = cheminActuel[k][1]+1;
								verif = false;
							}
						}
						//Bas
						if(cheminActuel[k][0]<6 && passageEntreCases(cheminActuel[k][0],cheminActuel[k][1],cheminActuel[k][0]+1,cheminActuel[k][1])){
							for(int j=0; j<cheminActuel.length; j++){
								if(chemin_initial[j][0]==cheminActuel[k][0]+1 && cheminActuel[j][0]==cheminActuel[k][0]) verif = false;
							}
							if(verif) {
								cheminActuel[k+1][0] = cheminActuel[k][0] + 1;
								cheminActuel[k+1][1] = cheminActuel[k][1];
								verif = false;
							}
						}
						//Gauche
						if(cheminActuel[k][1]>0 && passageEntreCases(cheminActuel[k][0],cheminActuel[k][1],cheminActuel[k][0],cheminActuel[k][1]-1)){
							for(int j=0; j<cheminActuel.length; j++){
								if(chemin_initial[j][0]==cheminActuel[k][0] && cheminActuel[j][0]==cheminActuel[k][0]-1) verif = false;
							}
							if(verif) {
								cheminActuel[k+1][0] = cheminActuel[k][0];
								cheminActuel[k+1][1] = cheminActuel[k][1]-1;
								verif = false;
							}
						}
					}
				}
			}
		}

		 */
		/*
		int inc_final = 0;
		while(cheminActuel[inc_final][0] != posLigCaseArr && cheminActuel[inc_final][1] != posColCaseArr){
			inc_final++;
		}

		int[][] resultat = new int[inc_final][2];
		for(int i=0; i<resultat.length; i++){
			resultat[i][0] = cheminActuel[i][0];
			resultat[i][1] = cheminActuel[i][1];
		}

		return resultat;
		*/














		/**
		 * Décomposition de la méthode en 3 parties :
		 * 1 - Récupération de toutes les pièces possibles sur les chemins
		 * 2 - obtention d'un chemin intitial
		 * 3 - Récupération du chemin final
		 */



		/**
		 * 1 - Récupération de toutes les pièces possibles sur les chemins :
		 * 		1 - initialisation des données
		 * 		2 - test avec exceptions
		 * 		3 - retour avec int[][] de la liste des pièces
		 * 		4 - Déclenchemnent du retour si la piece d'arrivée n'existe pas dans totalpieces
		 */

		// 1/1 - Initialisation :
		// totalpieces -> 49 pièces max / ligne ou colonne
		int[][] totalpieces = new int[49][2];
		// création d'un vérificateur
		boolean verif = true;
		// incrémentateur de la boucle
		int inc_boucle = 0;
		// incrémentateur de la liste
		int inc_liste = 0;
		// affectation à 0; voir boucle suivante
		for(int i=0; i<totalpieces.length; i++){
			totalpieces[i][0] = -1;
			totalpieces[i][1] = -1;
		}
		// affectation de la pièce de départ à la liste
		totalpieces[0][0] = posLigCaseDep;
		totalpieces[0][1] = posColCaseDep;

		// données boucle
		int posLigCaseActu;
		int posColCaseActu;

		// 1/2 - test avec exceptions
		// création de la boucle récupérant toutes les pièces
		while(totalpieces[inc_boucle][0]!=-1 && totalpieces[inc_boucle][1]!=-1){
			posLigCaseActu = totalpieces[inc_boucle][0];
			posColCaseActu = totalpieces[inc_boucle][1];
			// Haut
			if(posLigCaseActu>0){
				if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)) {
					for (int j = 0; j < totalpieces.length; j++) {
						if (totalpieces[j][0] == posLigCaseActu - 1 && totalpieces[j][1] == posColCaseActu)
							verif = false;
					}
					if (verif) {
						totalpieces[inc_liste + 1][0] = posLigCaseActu - 1;
						totalpieces[inc_liste + 1][1] = posColCaseActu;
						inc_liste++;
					}
					verif = true;
				}
			}
			//Droite
			if(posColCaseActu<6) {
				if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,(posColCaseActu+1))) {
					for (int j = 0; j < totalpieces.length; j++) {
						if (totalpieces[j][0] == posLigCaseActu && totalpieces[j][1] == posColCaseActu + 1)
							verif = false;
					}
					if (verif) {
						totalpieces[inc_liste + 1][0] = posLigCaseActu;
						totalpieces[inc_liste + 1][1] = posColCaseActu + 1;
						inc_liste++;
					}
					verif = true;
				}
			}
			//Bas
			if(posLigCaseActu<6){
				if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)) {
					for (int j = 0; j < totalpieces.length; j++) {
						if (totalpieces[j][0] == posLigCaseActu + 1 && totalpieces[j][1] == posColCaseActu)
							verif = false;
					}
					if (verif) {
						totalpieces[inc_liste + 1][0] = posLigCaseActu + 1;
						totalpieces[inc_liste + 1][1] = posColCaseActu;
						inc_liste++;
					}
					verif = true;
				}
			}
			//Gauche
			if(posColCaseActu>0){
				if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)) {
					for (int j = 0; j < totalpieces.length; j++) {
						if (totalpieces[j][0] == posLigCaseActu && totalpieces[j][1] == posColCaseActu - 1)
							verif = false;
					}
					if (verif) {
						totalpieces[inc_liste + 1][0] = posLigCaseActu;
						totalpieces[inc_liste + 1][1] = posColCaseActu - 1;
						inc_liste++;
					}
					verif = true;
				}
			}
			inc_boucle++;
		}
		boolean verif_ensemble = false;
		for(int i=0; i<totalpieces.length; i++){
			if(totalpieces[i][0]==posLigCaseArr && totalpieces[i][1]==posColCaseArr) verif_ensemble = true;
		}

		// 1/4 - Déclenchemnent du retour si la piece d'arrivée n'existe pas dans totalpieces
		if(verif_ensemble){
			/**
			 * 2 - obtention d'un chemin intitial
			 * 		1 Récupération des pièces d'intersection à l'aide de totalpieces
			 * 		2 Initialisation du chemin
			 * 		3 Changement de chemin jusqu'à ce que la pièce d'arrivée existe dans cheminActuel
			 */

			// 2/1 Récupération des pièces d'intersection à l'aide de totalpieces
			int inc_inter = 0;
			for(int i=0; i< totalpieces.length; i++){
				if(totalpieces[i][0]!=-1 && totalpieces[i][1]!=-1){
					if(getPiece(totalpieces[i][0], totalpieces[i][1]).getModelePiece() == 2) {
						inc_inter++;
					}
				}
			}

			int[][] interpieces = new int[inc_inter][2];
			inc_inter = 0;

			for(int i=0; i< totalpieces.length; i++){
				if(totalpieces[i][0]!=-1 && totalpieces[i][1]!=-1){
					if(getPiece(totalpieces[i][0], totalpieces[i][1]).getModelePiece() == 2) {
						interpieces[inc_inter][0] = totalpieces[i][0];
						interpieces[inc_inter][1] = totalpieces[i][1];
						inc_inter++;
					}
				}
			}

			// 2/2 Initialisation du chemin
			int[][] cheminActuel = new int[49][2];
			for(int i=0; i<cheminActuel.length; i++){
				cheminActuel[i][0] = -1;
				cheminActuel[i][1] = -1;
			}
			cheminActuel[0][0] = posLigCaseDep;
			cheminActuel[0][1] = posColCaseDep;
			inc_boucle = 0;
			boolean pose = false;

			while(cheminActuel[inc_boucle][0]!=-1 && cheminActuel[inc_boucle][1]!=-1){
				posLigCaseActu = cheminActuel[inc_boucle][0];
				posColCaseActu = cheminActuel[inc_boucle][1];
				// Haut
				if(posLigCaseActu>0 && !pose){
					if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)) {
						for (int j = 0; j < cheminActuel.length; j++) {
							if (cheminActuel[j][0] == posLigCaseActu - 1 && cheminActuel[j][1] == posColCaseActu)
								verif = false;
						}
						if (verif) {
							cheminActuel[inc_boucle + 1][0] = posLigCaseActu - 1;
							cheminActuel[inc_boucle + 1][1] = posColCaseActu;
							pose = true;
						}
						verif = true;
					}
				}
				//Droite
				if(posColCaseActu<6 && !pose) {
					if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,(posColCaseActu+1))) {
						for (int j = 0; j < cheminActuel.length; j++) {
							if (cheminActuel[j][0] == posLigCaseActu && cheminActuel[j][1] == posColCaseActu + 1)
								verif = false;
						}
						if (verif) {
							cheminActuel[inc_boucle + 1][0] = posLigCaseActu;
							cheminActuel[inc_boucle + 1][1] = posColCaseActu + 1;
							pose = true;
						}
						verif = true;
					}
				}
				//Bas
				if(posLigCaseActu<6 && !pose){
					if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)) {
						for (int j = 0; j < cheminActuel.length; j++) {
							if (cheminActuel[j][0] == posLigCaseActu + 1 && cheminActuel[j][1] == posColCaseActu)
								verif = false;
						}
						if (verif) {
							cheminActuel[inc_boucle + 1][0] = posLigCaseActu + 1;
							cheminActuel[inc_boucle + 1][1] = posColCaseActu;
							pose = true;
						}
						verif = true;
					}
				}
				//Gauche
				if(posColCaseActu>0 && !pose){
					if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)) {
						for (int j = 0; j < cheminActuel.length; j++) {
							if (cheminActuel[j][0] == posLigCaseActu && cheminActuel[j][1] == posColCaseActu - 1)
								verif = false;
						}
						if (verif) {
							cheminActuel[inc_boucle + 1][0] = posLigCaseActu;
							cheminActuel[inc_boucle + 1][1] = posColCaseActu - 1;
							pose = true;
						}
						verif = true;
					}
				}
				pose = false;
				inc_boucle++;
			}

			// 3/2 Changement de chemin jusqu'à ce que la pièce d'arrivée existe dans cheminActuel
			int inc = 0;
			boolean verif_trouve = false;
			boolean inter = false;
			int[][] inter_valides = new int[interpieces.length][interpieces[0].length];
			for(int i=0; i<inter_valides.length; i++){
				inter_valides[i][0] = -2;
				inter_valides[i][0] = -2;
			}
			int inc_inter_valide = 0;
			int[] piece_exception = new int[2];


			while(!verif_trouve){
				for(int i=0; i<cheminActuel.length; i++){
					if(cheminActuel[i][0]==posLigCaseArr && cheminActuel[i][1]==posColCaseArr) verif_trouve = true;
				}
				// Réaffectation du chemin
				if(!verif_trouve) {
					// Parcours le chemin actuel
					for (int i = 0; i < cheminActuel.length; i++) {
						// Parcours les pièces de jointures
						for (int j = 0; j < interpieces.length; j++) {
							// Parcours par décrémentation
							// Si la pièce parourue est une jointure et n'est pas !?inter?!
							for(int l=0; l<interpieces.length; l++){
								if(cheminActuel[cheminActuel.length-i-1][0] == interpieces[j][0] && cheminActuel[cheminActuel.length-i-1][1] == interpieces[j][1]){
									if(cheminActuel[cheminActuel.length-i-1][0]==inter_valides[l][0] && cheminActuel[cheminActuel.length-i-1][1]==inter_valides[l][1]){
										inter = true;
									}
								}
							}
							if (cheminActuel[cheminActuel.length-i-1][0] == interpieces[j][0] && cheminActuel[cheminActuel.length-i-1][0] == interpieces[j][0] && !inter) {
								// ajout de la piece d'intersection dans la liste d'exception
								inter_valides[inc_inter][0] = cheminActuel[cheminActuel.length-i-1][0];
								inter_valides[inc_inter][1] = cheminActuel[cheminActuel.length-i-1][1];
								inc_inter_valide++;
								// piece exeption pour dévier de chemin
								if(i!=cheminActuel.length-1) {
									piece_exception[0] = cheminActuel[cheminActuel.length - i - 1 + 1][0];
									piece_exception[1] = cheminActuel[cheminActuel.length - i - 1 + 1][1];
								}
								// vidage de la suite
								for (int k = i + 1; k < cheminActuel.length; k++) {
									cheminActuel[k][0] = -1;
									cheminActuel[k][1] = -1;
								}
								inc_boucle = i;
								while(cheminActuel[inc_boucle][0]!=-1 && cheminActuel[inc_boucle][1]!=-1){
									posLigCaseActu = cheminActuel[inc_boucle][0];
									posColCaseActu = cheminActuel[inc_boucle][1];
									// Haut
									if(posLigCaseActu>0 && !pose && posLigCaseActu-1!=piece_exception[0] && posColCaseActu!=piece_exception[1]){
										if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu-1,posColCaseActu)) {
											for (int l = 0; l < cheminActuel.length; l++) {
												if (cheminActuel[l][0] == posLigCaseActu - 1 && cheminActuel[l][1] == posColCaseActu)
													verif = false;
											}
											if (verif) {
												cheminActuel[inc_boucle + 1][0] = posLigCaseActu - 1;
												cheminActuel[inc_boucle + 1][1] = posColCaseActu;
												pose = true;
											}
											verif = true;
										}
									}
									//Droite
									if(posColCaseActu<6 && !pose && posLigCaseActu!=piece_exception[0] && posColCaseActu+1!=piece_exception[1]) {
										if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,(posColCaseActu+1))) {
											for (int l = 0; l < cheminActuel.length; l++) {
												if (cheminActuel[l][0] == posLigCaseActu && cheminActuel[l][1] == posColCaseActu + 1)
													verif = false;
											}
											if (verif) {
												cheminActuel[inc_boucle + 1][0] = posLigCaseActu;
												cheminActuel[inc_boucle + 1][1] = posColCaseActu + 1;
												pose = true;
											}
											verif = true;
										}
									}
									//Bas
									if(posLigCaseActu<6 && !pose && posLigCaseActu+1!=piece_exception[0] && posColCaseActu!=piece_exception[1]){
										if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu+1,posColCaseActu)) {
											for (int l = 0; l < cheminActuel.length; l++) {
												if (cheminActuel[l][0] == posLigCaseActu + 1 && cheminActuel[l][1] == posColCaseActu)
													verif = false;
											}
											if (verif) {
												cheminActuel[inc_boucle + 1][0] = posLigCaseActu + 1;
												cheminActuel[inc_boucle + 1][1] = posColCaseActu;
												pose = true;
											}
											verif = true;
										}
									}
									//Gauche
									if(posColCaseActu>0 && !pose && posLigCaseActu!=piece_exception[0] && posColCaseActu!=piece_exception[1]-1){
										if(passageEntreCases(posLigCaseActu,posColCaseActu,posLigCaseActu,posColCaseActu-1)) {
											for (int l = 0; l < cheminActuel.length; l++) {
												if (cheminActuel[l][0] == posLigCaseActu && cheminActuel[l][1] == posColCaseActu - 1)
													verif = false;
											}
											if (verif) {
												cheminActuel[inc_boucle + 1][0] = posLigCaseActu;
												cheminActuel[inc_boucle + 1][1] = posColCaseActu - 1;
												pose = true;
											}
											verif = true;
										}
									}
									pose = false;
									inc_boucle++;
								}
							}
							inter = true;
						}
					}
				}
			}



			/**
			 * 3 - Récupération du chemin final
			 * 		1 - Raccourcissement du chemin de la case d'arrivée jusqu'à la case d'arrivée
			 * 		2 - retour sous forme d'un tableau de MAX[49] pièces avec la ligne [0] et la colonne [1] de chaque pièce
			 * 			style int[][] resultat = new int[49][2]
			 */
			int inc_final = 0;
			while((cheminActuel[inc_final][0]!=posLigCaseArr) && (cheminActuel[inc_final][1]!=posColCaseArr)){
				System.out.println(cheminActuel[inc_final][0] + " " + cheminActuel[inc_final][0]);
				System.out.println(posLigCaseArr + " " + posColCaseArr);
				System.out.println((cheminActuel[inc_final][0]!=posLigCaseArr) + " " + (cheminActuel[inc_final][1]!=posColCaseArr));
				inc_final++;
			}

			int[][] resultat = new int[inc_final][2];
			for(int i=0; i<inc_final; i++){
				resultat[i][0] = cheminActuel[i][0];
				resultat[i][1] = cheminActuel[i][1];
			}
			System.out.println(inc_final+" gagné");
			return resultat;
		}
		else {
			System.out.println("perdu");
			return null;
		}








		// test
		/**

		System.out.println("TEST");
		System.out.println("TEST_range "+i);
		System.out.println("taille chemin "+cheminActuel.length+" rang = "+i+" : "+cheminActuel[i][0]+" "+cheminActuel[i][1]);
		System.out.println("TEST");
		*/
	}





	/**
	 * 
	 * Méthode permettant de calculer un chemin détaillé (chemin entre sous-cases) à partir d'un chemin entre cases.
	 *  
	 * @param chemin Un tableau représentant un chemin de cases.
	 * @param numJoueur Le numéro du joueur pour lequel nous souaitons construire un chemin détaillé.
	 * 
	 * @return Le chemin détaillé correspondant au chemin de positions de pièces données en paramètre et pour le numéro de joueur donné.
	 */
	public int[][] calculeCheminDetaille(int[][] chemin,int numJoueur){
		if (chemin.length==1)
			return new int[0][0];
		int[][] cheminDetaille=new int[chemin.length*5][4];
		int pos=0;
		int col,lig,colS,ligS;
		for (int i=0;i<chemin.length-1;i++){
			lig=chemin[i][0];
			col=chemin[i][1];
			ligS=chemin[i+1][0];
			colS=chemin[i+1][1];
			if (ligS<lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
			}
			else if (ligS>lig){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=2;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=0;
				cheminDetaille[pos++][3]=1;
			} else if (colS<col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
			} else if (colS>col){
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=1;
				cheminDetaille[pos][0]=lig;
				cheminDetaille[pos][1]=col;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=2;
				cheminDetaille[pos][0]=ligS;
				cheminDetaille[pos][1]=colS;
				cheminDetaille[pos][2]=1;
				cheminDetaille[pos++][3]=0;
			}
		}
		cheminDetaille[pos][0]=chemin[chemin.length-1][0];
		cheminDetaille[pos][1]=chemin[chemin.length-1][1];
		cheminDetaille[pos][2]=1;
		cheminDetaille[pos++][3]=1;

		int debut=0;
		if ((numJoueur==0)&&((cheminDetaille[pos-2][2]==0)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==1)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==2))) pos--;
		if ((numJoueur==2)&&((cheminDetaille[pos-2][2]==2)||(cheminDetaille[pos-2][3]==0))) pos--;
		if ((numJoueur==0)&&((cheminDetaille[1][2]==0)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==1)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==2))) debut++;
		if ((numJoueur==2)&&((cheminDetaille[1][2]==2)||(cheminDetaille[0][3]==0))) debut++;

		int[][] resultat=new int[pos-debut][4];
		for (int i=debut;i<pos;i++)
			for (int j=0;j<4;j++)
				resultat[i-debut][j]=cheminDetaille[i][j];
		return resultat;	
	}

	/**
	 * 
	 * Méthode retournant une copie du plateau avec des copies de ses pièces.
	 * 
	 * @return Une copie du plateau avec une copie de toutes ses pièces.
	 */
	public Plateau copy(){
		Plateau plateau=new Plateau();
		for (int ligne=0;ligne<7;ligne++)
			for (int colonne=0;colonne<7;colonne++)
				plateau.positionnePiece((this.plateau[ligne][colonne]).copy(), ligne, colonne);
		return plateau;
	}

}
