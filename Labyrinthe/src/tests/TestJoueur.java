package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
		public static void main(String[] args) {
			Object parametresJeu[];
			parametresJeu=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie


			Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);

			// Création de la fenêtre de jeu et affichage de la fenêtre
			int nbJoueurs=joueurs.length; // Récupération du nombre de joueurs
			IG.creerFenetreJeu("Titre à mettre", nbJoueurs); // On crée la fenêtre
			IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu

			Plateau plateau=new Plateau();
			//Piece pieceHorsPlateau=plateau.placerPiecesAleatoirement();
			Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
			for(int i=0; i<7; i++){
				for(int j=0; j<7; j++){
					IG.changerPiecePlateau(i, j, (plateau.getPiece(i, j)).getModelePiece(), (plateau.getPiece(i, j)).getOrientationPiece());
				}
			}
			// IG.changerPieceHorsPlateau(plateau.getPiece(-1,-1));
			IG.miseAJourAffichage();
			IG.attendreClic();

			


					
			//Initialise les joueurs
			for(int i=0; i<nbJoueurs; i++) {
			IG.changerNomJoueur(joueurs[i].getNumJoueur(), joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
			IG.changerImageJoueur(joueurs[i].getNumJoueur(),joueurs[i].getNumeroImagePersonnage());
			//System.out.println(joueurs[i].getPosLigne());
			IG.placerJoueurSurPlateau(i, joueurs[i].getPosLigne(), joueurs[i].getPosColonne());
			}
			
			// Affichage du message de bienvenue + mise à jour affichage + attente clic
			String message[]={
				"",
				"",
				"Cliquez pour continuer...",
				""
			};
			IG.afficherMessage(message); // On change de message de la fenêtre de jeu
			

			IG.miseAJourAffichage();
			IG.attendreClic();

			for(int i=0; i<3; i++){
				/*
				String message[]={
						"",
						"",
						"Cliquez pour continuer...",
						""
				};
				IG.afficherMessage(message);
				*/
				if(joueurs[i].getCategorie() != "Ordinateur") {

					message[0] = "";
					message[1] = "Au tour du joueur " + (i + 1);
					message[2] = "Sélectionner une case ...";
					message[3] = "";
					IG.afficherMessage(message);
					IG.miseAJourAffichage();

					int[] tabArrivee = joueurs[i].choisirCaseArrivee(null);
					int ligArrivee = tabArrivee[0];
					int colArrivee = tabArrivee[1];

					IG.selectionnerPiecePlateau(ligArrivee, colArrivee);

					IG.placerJoueurSurPlateau(i, ligArrivee, colArrivee);
					IG.miseAJourAffichage();
				}
			}
			/*
			while(1!=0) {
				int[] tabArrivee = joueurs[0].choisirCaseArrivee(null);
				int ligArrivee = tabArrivee[0];
				int colArrivee = tabArrivee[1];

				IG.selectionnerPiecePlateau(ligArrivee,colArrivee);

				IG.placerJoueurSurPlateau(0, ligArrivee, colArrivee);
				IG.miseAJourAffichage();

			}

			 */
			message[0]="";
			message[1]="C'est terminé !";
			message[2]="Cliquer pour quitter ...";
			IG.afficherMessage(message);
			IG.miseAJourAffichage();
			IG.attendreClic();
			IG.fermerFenetreJeu();
			System.exit(0);
		}
		
}
