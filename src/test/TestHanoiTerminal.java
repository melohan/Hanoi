package test;
import hanoi.Hanoi;

/**
 * Classe de Test de la classe Hanoi pour le mode console
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class TestHanoiTerminal {

    public static void main(String[] args) {

        System.out.println("Tests relatifs a la classe Hanoi. L'on s'assure du bon" +
                           " deroulement du code depuis le terminal.");
        System.out.println("Les cas limites sont testes via des try-catch..");
        System.out.println("________________________________________________________________");


        int ndisk0 = 0,
            ndisk1 = 1,
            ndisk2 = 2,
            ndisk3 = 3,
            ndisk4 = 21,
            ndisk5 = -1;

        System.out.println("1) Initialisation avec erreurs, respectivement 0, 21, -1. ");
        System.out.print("1.1) new Hanoi("+ndisk0+")");
        try{
          Hanoi h0 = new Hanoi(ndisk0);
        }catch (IllegalArgumentException e ){
            System.out.print("\n Exception catch: " + e + "for new Hanoi(" + ndisk0 + ")\n");
        }
        System.out.print("1.2) new Hanoi(" + ndisk4 + ")");
        try{
            Hanoi h1 = new Hanoi(ndisk4);
        }catch (IllegalArgumentException e ){
            System.out.print("\n Exception catch: " + e + "for new Hanoi("+ndisk4+")\n");
        }
        System.out.print("1.3) new Hanoi(" + ndisk5 + ")");
        try{
            Hanoi h2 = new Hanoi(ndisk4);
        }catch (IllegalArgumentException e ){
            System.out.print("\n Exception catch: " + e + "for new Hanoi(" + ndisk5 + ")\n");
        }
        System.out.println("___________________________________________");

        System.out.println("2) Tests d'affichages avec respectivement " + ndisk2 + ", "
                + ndisk3 + " disques.");
        Hanoi h3 = new Hanoi(ndisk2);
        Hanoi h4 = new Hanoi(ndisk3);

        System.out.println("2.1) h3 = new Hanoi(" + ndisk2 + ")");
        System.out.println(h3);
        System.out.println("2.2) h4 = new Hanoi(" + ndisk3 + ")");
        System.out.println(h4);
        System.out.println("___________________________________________");

        System.out.println("3) Test solve() (on reprend ceux du pt 2), ce test verifie " +
                           "implictement getStatus().");
        System.out.println("3.1) h3.solve(): solve avec " + ndisk2) ;
        h3.solve();
        System.out.println("____________");
        System.out.println("3.2) h4.solve avec " + ndisk3) ;
        h4.solve();

        System.out.println("___________________________________________");
        System.out.println("4) Test finished(), l'on verifie que le probleme des tours " +
                           "d'Hanoi est resolu.");
        System.out.println("   Pour se faire, l'on reprend une tour vide et celle resolue " +
                           "au point 3.");

        System.out.println("4.1) finished sur une nouvelle instance d'Hanoi: ") ;
        Hanoi h5 = new Hanoi(ndisk3);
        System.out.println("     La h5 est finie: " + h5.finished());
        System.out.println("4.2) finished sur une instance du point 3)");
        System.out.println("     La h3 est finie: " + h3.finished());
    }
}