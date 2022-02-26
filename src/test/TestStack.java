package test;
import util.Stack;
import util.Iterator;
import java.util.EmptyStackException;

/**
 * Classe de Test de la classe Stack
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class TestStack {

    public static void main(String[] args) {

        System.out.println("Tests relatifs a la classe pile representant une des tours " +
                           "d'Hanoi.");
        System.out.println("Les cas limites sont testes via des try-catch..");
        System.out.println("________________________________________________________________");


        // initialisaiton:
        System.out.println("Test de la pile de Hanoi");
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        /**
         * 1) Test empilement:
         */
        String s0 = "D0",
               s1 = "D1",
               s2 = "D2",
               s3 = "D3";
        System.out.println("1) Test d'empilement, 4 disques de types string contenant " +
                           "D0,D1,D2, D3 sont ajoutes.");
        System.out.println("   tower1.add(new Object()) x 4, le contenu sera affiche " +
                           "plus loin.");
        stack1.add(s0);
        stack1.add(s1);
        stack1.add(s2);
        stack1.add(s3);
        System.out.print("1.2) Ajout d'un disque null sur tower3: ");

        stack3.add(null);

        System.out.println("\n___________________________________________");

        /**
         * 2) Test Taille:
         */
        System.out.println("2) Test permettant de recuperer le nombre de disques, l'on test " +
                           "notre premiere pile et une pile vide.");
        System.out.println("2.1) tower1.getNbDisk(): " + stack1.getNbDisk());
        System.out.println("2.2) tower2.getNbDisk(): " + stack2.getNbDisk());
        System.out.println("___________________________________________");

        /**
         * 3) Test désempilement
         *    - avec une pleine et vide
         */
        System.out.println("3) Test de desempilement, la taille initiale de la pile 1 " +
                           "etant de 4.");
        stack1.pop();
        System.out.println("3.1) tower1.getNbDisk() apres tower.pop(): " + stack1.getNbDisk());
        System.out.print(  "3.2) tower2.pop d'une tour vide          : ");
        try{
            stack2.pop();
        }catch (EmptyStackException e){
            System.out.print("\n Exception catch: " + e + " from tower2.pop()\n");
        }
        System.out.println("___________________________________________");

        /**
         * 4) Affichage avec toString
         *    - pile pleine et vide
         */
        System.out.println("4) Test de la fonction toString() sur la tour 1 et 2 (la vide).");
        System.out.println("4.1) tower1.toString(): " + stack1.toString());
        System.out.println("4.2) tower2.toString(): " + stack2.toString());
        System.out.println("___________________________________________");

        /**
         * 5) Test du tableau d'objets
         */
        Object[] state1 = stack1.getState();
        Object[] state2 = stack2.getState();

        System.out.println("5) tower.getState: On verifie l'etat des deux piles via " +
                           "cette fonction. ");
        System.out.println("5.1) Taille du tableau: " + state1.length);
        System.out.print("     Contenu du tableau : [ ");
        for(int i = 0; i < state1.length; ++i)
            System.out.print(state1[i] + " ");
        System.out.print("]\n");
        System.out.println("5.2) Tableau est nulle? : " + (boolean)(state2 == null));
        System.out.println("___________________________________________");

        /**
         * 6) Test obtention d'un Iterateur sur la pile
         */
        System.out.println("6) Ici on testera la classe Iterator au travers de la pile.");
        Iterator i1 = stack1.getIterator();
        Iterator i2 = stack2.getIterator();
        System.out.println("Extraction du disque via l'iterateur");
        System.out.println("6.1) i1.getData() : " +  i1.getData());
        System.out.print("6.2) i2.getData() : ");
        try{
            i2.getData();
        }catch (NullPointerException e ){
            System.out.print("\n    Exception catch: " + e + "for i2.getData()\n");
        }
        System.out.println("  ___________");

        System.out.println("On verifie si l'iterateur a bien un iterateur suivant");
        System.out.println("6.2.1) i1.hasNext(): " +  (boolean)i1.hasNext());
        System.out.println("6.2.2) i2.hasNext(): " +  (boolean)i2.hasNext());
        System.out.println("  ___________");
        System.out.println("On accede a l'iterateur suivant");
        System.out.println("6.3) i1.next(), i2.next(): ");
        i1.next();
        try{
            i2.next();
        }catch (EmptyStackException e ){
            System.out.print("\n Exception catch: " + e + "for i2.next()\n");
        }
        System.out.println("6.3.1) i1.getData() (next) : " +  i1.getData());
        System.out.print("6.3.2) i2.getData() (next) : ");
        try{
            i2.getData();
        }catch (NullPointerException e ){
            System.out.print("\n Exception catch: " + e + "for i2.getData()\n");
        }
    }
}