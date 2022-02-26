package test;
import util.ChainLink;

/**
 * Classe de Test de la classe ChainLink
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class TestChainLink {
    //itérateurs nécessaires au tests:
    public ChainLink c1;
    public ChainLink c2;
    public ChainLink c3;
    public ChainLink c4;

    public static void main(String[] args) {

        System.out.println("Tests relatifs a la classe ChainLink representant" +
                           " les maillons de la chaine.");
        System.out.println("Les cas limites sont testes via des try-catch..");
        System.out.println("________________________________________________________________");

        /**
         * Initialisation des disques
         */
        String d1  = "D1",
               d2  = null,
               d3  = "D3",
               d4  = "D4";

        /**
         * 1) Test sur les constructeurs:
         */

        System.out.println("1) Initialisation des maillons, avec un disque non vides et" +
                           " un disque null:");
        TestChainLink  testCL = new TestChainLink();
        System.out.println("1.1) new ChainLink()");
        testCL.c1 = new ChainLink(d1, testCL.c1);


        System.out.println("1.2) new ChainLink(null,c2)");
        try{
            testCL.c2 = new ChainLink(d2, testCL.c2);
        }catch(RuntimeException e){
            System.out.print("    Exception catch: '" + e + "'for  new " +
                             "ChainLink(d2, testCL.c2)\n");
        }
        System.out.println("___________________________________________");

        /**
         * 2) Test getDisk()
         */

        System.out.println("2) Test de l'acces au disque vide et non vide");
        System.out.println("2.1) c1.getDisk(): " + testCL.c1.getDisk());
        System.out.println("2.2) c2.getDisk(): ");

        try{
            testCL.c2.getDisk();
        }catch(NullPointerException e){
            System.out.print("    Exception catch: '" + e + "'from c2.getDisk()\n");
        }
        System.out.println("___________________________________________");

        /**
         * 3) Test getNext()
         * On ne test pas le suivant de c2 car le courant est déjà vide.
         */

        System.out.println("3) Test d'acces a l'iterateur suivant");
        System.out.println("3.1) c1.getNext(): " + testCL.c1.getNext());
    }
}