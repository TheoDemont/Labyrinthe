package composants;

import java.util.Date;
import java.util.Random;

/**
 *
 * Classe contenant quelques fonctions utilitaires.
 *
 */
public class Utils {

    private static Random generateur=new Random((new Date().getTime()));

    /**
     * A Faire (11/05/21 Baptiste Finalisé)
     *
     * Méthode permettant de générer aléatoirement un nombre entier.
     *
     * @param max Le nombre entier maximal pouvant étre retourné.
     * @return Un nombre entier compris entre 0 et max (inclus).
     */
    public static int genererEntier(int max){

        return generateur.nextInt(max+1);
    }
    /**
     * A Faire (11/05/21 Alexandre Finalisé)
     *
     * Méthode permettant de générer un tableau d'entiers dont la longueur longTab est donnée en paramètre.
     * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
     * dans le tableau doit étre aléatoire.
     *
     * @param longTab La longueur du tableau.
     * @return Un tableau contenant les entiers 0,...,longTab-1 placés aléatoirement dans le tableau.
     */
    public static int[] genereTabIntAleatoirement(int longTab){
        int tab[]=new int[longTab];
        int tab2[]=new int[longTab];
        for(int i=0; i<longTab;i++){
            tab2[i]=i;
        }
        int i = 0;
        while(i!=(longTab)) {
            int a=generateur.nextInt(longTab);
            boolean test=false;
            for(int j=0; j<i; j++){
                if(tab[j]==tab2[a]){
                    test = true;
                }
            }
            if (test==false) {
                tab[i]=tab2[a];
                i = i+1;
            }
        }
        return tab;
    }
    /**
     * Programme testant la méthode genereTabIntAleatoirement.
     * @param args arguments du programme
     */
    public static void main(String[] args) {
        int tab[]=genereTabIntAleatoirement(18);
        for (int i=0;i<tab.length;i++)
            System.out.print(tab[i]+" ");

    }

}