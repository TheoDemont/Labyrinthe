package tests;
import grafix.interfaceGraphique.IG;

public class MaDemoIG {

    public static void main(String[] args) {

        Object parametres[];
        parametres = IG.saisirParametres();

        int nbJoueurs = ((Integer) parametres[0]).intValue();
        IG.creerFenetreJeu("MaDémoIG version 1.0", nbJoueurs);
        IG.rendreVisibleFenetreJeu();

        IG.jouerUnSon(2);
        IG.pause(300);
        IG.jouerUnSon(2);

        String message[]= {
                "",
                "Bonjour !",
                "Cliquez pour continuer ...",
                ""
        };
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.attendreClic();

        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(0, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(1, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(2, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(3, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(4, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(5, j, 2, 0);
        }
        for (int j = 0; j < 7; j++) {
            IG.changerPiecePlateau(6, j, 2, 0);
        }
        IG.miseAJourAffichage();
        IG.attendreClic();

        IG.changerPieceHorsPlateau(1,0);

        IG.miseAJourAffichage();
        IG.attendreClic();

        for(int i = 0; i<nbJoueurs; i++) {
            int numImageJoueur0 = ((Integer) parametres[3+3*i]).intValue();
            String nomJoueur0 = (String) parametres[1+3*i];
            String categorieJoueur0 = (String) parametres[2+3*i];
            IG.attendreClic();
            IG.changerNomJoueur(i, nomJoueur0 + " (" + categorieJoueur0 + ")");
            IG.changerImageJoueur(i, numImageJoueur0);
            IG.miseAJourAffichage();
            IG.attendreClic();


        }


        // Changement d'objets au premier joueur et second joueur

        if(nbJoueurs==3) {
            for (int i = 0; i < 6; i++) {
                IG.changerObjetJoueur(0, i, i);
                IG.changerObjetJoueur(1, i + 7, i);
                IG.changerObjetJoueur(2, i + 12, i);
            }
            IG.miseAJourAffichage();
            IG.attendreClic();
        }

        else {
            for (int i = 0; i < 9; i++) {
                IG.changerObjetJoueur(0, i, i);
                IG.changerObjetJoueur(1, i + 7, i);
            }
            IG.miseAJourAffichage();
            IG.attendreClic();
        }

        // Place des objets sur le plateau
        int numObjet=0;
        for (int i=0;i<3;i++)
            for (int j=0;j<7;j++) {
                if(i<2 || (i==2 && j<4)) {
                    if (numObjet == 6 || numObjet == 13) ++numObjet;
                    IG.placerObjetPlateau((numObjet++) % 18, i, j);
                }
            }
        IG.miseAJourAffichage();
        IG.attendreClic();

        // Place les joueurs sur le plateau

        for (int i=0;i<nbJoueurs-1;i++)
            IG.placerJoueurPrecis(i,3,6*i, 1, 2*i);
        IG.miseAJourAffichage();
        IG.attendreClic();

        for(int x=1; x<5; x++){
            for(int i = 0; i<7; i++) {
                for (int j = 0; j < 7; j++) {
                    IG.changerPiecePlateau(i, j, 2, x%4);
                    IG.changerPieceHorsPlateau(1, x%4);
                    IG.placerJoueurPrecis(0,3,0,1,x);
                    IG.placerJoueurPrecis(1,3,6,1,2-x);
                    IG.placerBilleSurPlateau(3,(x-1)/3,1,(x-1)%3,0);
                    IG.placerBilleSurPlateau(3,6-(x-1)/3,1,2-(x-1)%3,0);
                }
            }
            IG.miseAJourAffichage();
            IG.attendreClic();
        }

        for(int i = 0; i < 4; i++){
            IG.enleverObjetPlateau(0,i);
            IG.changerObjetJoueurAvecTransparence(0,i,i);
            IG.attendreClic();
            IG.miseAJourAffichage();
        }





    }

}