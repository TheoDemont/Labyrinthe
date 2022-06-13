package tests;

import composants.Piece;
import grafix.interfaceGraphique.IG;


public class TestPieces {

    public static void main(String[] args) {
        // Une petite démonstration conernant l'interface graphique


        // Saisie des différents paramètres
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fenêtre de paramétrage pour la saisie

        // Création de la fenêtre de jeu et affichage de la fenêtre
        int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
        IG.creerFenetreJeu("TestPieces",nbJoueurs); // On crée la fenêtre
        IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu

        IG.jouerUnSon(2); // On joue le son numéro 2
        IG.pause(300); // On attend 300 ms
        IG.jouerUnSon(2); // On joue de nouveau le son numéro 2

        // Affichage d'un message
        String message[]={
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.afficherMessage(message); // On change de message de la fenêtre de jeu
        IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
        IG.attendreClic();  // On attend un clic de souris

        //Changement du plateau
        Piece[] PiecePlateau = Piece.nouvellesPieces();
        /*
        int compteur = 0;
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                IG.changerPiecePlateau(i, j, PiecePlateau[compteur].getModelePiece() ,PiecePlateau[compteur].getOrientationPiece());
                compteur++;
            }
        }

        IG.changerPieceHorsPlateau(PiecePlateau[PiecePlateau.length-1].getModelePiece() ,PiecePlateau[PiecePlateau.length-1].getOrientationPiece());
        System.out.println(PiecePlateau[PiecePlateau.length-1].toString());
        IG.miseAJourAffichage();
        IG.attendreClic();
         */

        // Placement des pièce dans l'ordre
        Piece[] Tableau_modele_0 = new Piece[20];
        Piece[] Tableau_modele_1 = new Piece[12];
        Piece[] Tableau_modele_2 = new Piece[18];
        int inc_0 = 0;
        int inc_1 = 0;
        int inc_2 = 0;
        Piece[] Tableau_final = new Piece[50];

        for(int i = 0; i<50; i++){
            if(PiecePlateau[i].getModelePiece()==0){
                Tableau_modele_0[inc_0] = PiecePlateau[i];
                inc_0++;
            }
            else if(PiecePlateau[i].getModelePiece()==1){
                Tableau_modele_1[inc_1] = PiecePlateau[i];
                inc_1++;
            }
            else {
                Tableau_modele_2[inc_2] = PiecePlateau[i];
                inc_2++;
            }
        }

        for(int i = 0; i<20; i++){
            Tableau_final[i] = Tableau_modele_0[i];
        }
        for(int i = 0; i<12; i++){
            Tableau_final[i+20] = Tableau_modele_1[i];
        }
        for(int i = 0; i<18; i++){
            Tableau_final[i+20+12] = Tableau_modele_2[i];
        }

        int compteur_2 = 0;
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                IG.changerPiecePlateau(i, j, Tableau_final[compteur_2].getModelePiece() ,Tableau_final[compteur_2].getOrientationPiece());
                compteur_2++;
            }
        }

        IG.changerPieceHorsPlateau(Tableau_final[Tableau_final.length-1].getModelePiece() ,Tableau_final[Tableau_final.length-1].getOrientationPiece());
        IG.miseAJourAffichage();
        IG.attendreClic();

        //Rotation 4*
        for(int x = 0; x<4; x++) {
            int compteur_3 = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    Tableau_final[compteur_3].rotation();
                    IG.changerPiecePlateau(i, j, Tableau_final[compteur_3].getModelePiece(), Tableau_final[compteur_3].getOrientationPiece());
                    compteur_3++;
                }
            }
            Tableau_final[49].rotation();
            IG.changerPieceHorsPlateau(Tableau_final[Tableau_final.length-1].getModelePiece() ,Tableau_final[Tableau_final.length-1].getOrientationPiece());
            System.out.println(PiecePlateau[PiecePlateau.length-1].toString());
            IG.miseAJourAffichage();
            IG.attendreClic();
        }

        //Fin
        IG.fermerFenetreJeu();
        System.exit(0);
    }

}

