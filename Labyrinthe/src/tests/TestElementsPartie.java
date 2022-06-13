package tests;

import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import partie.ElementsPartie;

public class TestElementsPartie {

    public static void main(String[] args) {
        // Création de la fenêtre
        Object parametresJeu[];
        parametresJeu=IG.saisirParametres();
        int  nbJoueurs=((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie=new ElementsPartie(joueurs);
        IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu

        // Initialise les joueurs
        for (int i = 0; i < nbJoueurs; i++) {
            IG.changerNomJoueur(joueurs[i].getNumJoueur(), joueurs[i].getNomJoueur() + " (" + joueurs[i].getCategorie() + ")");
            IG.changerImageJoueur(joueurs[i].getNumJoueur(), joueurs[i].getNumeroImagePersonnage());
            //System.out.println(joueurs[i].getPosLigne());
            IG.placerJoueurSurPlateau(i, joueurs[i].getPosLigne(), joueurs[i].getPosColonne());
        }

        // Affichage d'un message
        String message[]={
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.afficherMessage(message); // On change de message de la fenêtre de jeu
        IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
        IG.attendreClic();  // On attend un clic de souris

        message[1] = "Choisissez un chemin ...";
        IG.afficherMessage(message);
        IG.miseAJourAffichage();

        for(int i=0; i<4; i++){
            int[] tab = joueurs[0].choisirOrientationEntree(null);
            elementsPartie.insertionPieceLibre(tab[1]);
            IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
            IG.attendreClic();  // On attend un clic de souris
        }

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
