package tests;

import composants.Objet;
import grafix.interfaceGraphique.IG;


public class TestObjet {

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

        //création des objets
        Objet[] objet = Objet.nouveauxObjets();
        for(int i=0; i< objet.length; i++){
            IG.placerObjetPlateau(objet[i].getNumeroObjet(), objet[i].getPosLignePlateau(),objet[i].getPosColonnePlateau());
        }
        IG.miseAJourAffichage();
        IG.attendreClic();

        //Fin
        IG.fermerFenetreJeu();
        System.exit(0);
    }

}

