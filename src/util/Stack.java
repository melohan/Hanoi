package util;
import java.util.NoSuchElementException;
import java.util.EmptyStackException;

/**
 * Classe représentant une pile LIFO.
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */

public class Stack {

    private int nbDisk;
    private ChainLink lastIn;

    /**
     * Retourne le nombre d éléments
     * @return Iterateur sur la pile
     * @since 1.0
     */
    public int getNbDisk(){
        return nbDisk;
    }

    /**
     * Ajoute un élément au sommet de la pile
     * @param disk Objet disque
     * @throws NoSuchElementException Si on tente d'ajouter un objet null
     * @since 1.0
     */
    public void add(Object disk) {
        lastIn  = new ChainLink(disk,lastIn);
        ++nbDisk;
    }

    /**
     * Retire le dernier élément au sommet de la pile et le renvoi.
     * @return Le disque retiré
     * @throws EmptyStackException Si la pile est vide.
     * @since 1.0
     */
    public Object pop() {
        if(nbDisk == 0)
            throw new EmptyStackException();

        Object disk = lastIn.getDisk();
        lastIn  = lastIn.getNext();      //L'actuel devient le suivant
        --nbDisk;

        return disk;
    }

    /**
     * Renvoi un tableau sur l'état de la pile. Son contenu allant du dernier
     * disque au 1er ajouté.
     * @return Tableau
     * @since 1.0
     */
    public Object[] getState() {
        Object[] state = new Object[nbDisk];
        ChainLink chainLink = lastIn;

        int i = 0;
        while(chainLink != null){
            state[i]  = chainLink.getDisk();
            chainLink = chainLink.getNext();
            ++i;
        }

        return state;
    }

    /**
     * Obtenir un iterateur sur la pile
     * @return Iterateur sur la pile
     * @since 1.0
     */
    public Iterator getIterator(){
        return new Iterator(lastIn);
    }

    /**
     * Converti le contenu de la pile en chaîne de caractère
     * @return de la pile au format [...]
     * @since 1.0
     */
    public String toString(){
        String str = "[ ";

        // Pour ne pas instancier inutilement chainLink
        if(lastIn != null){
            ChainLink chainLink = lastIn;
            do{
                str = str.concat("<");
                str = str.concat(chainLink.getDisk().toString());
                str = str.concat("> ");
                chainLink = chainLink.getNext();
            }while(chainLink != null );
        }

        str = str.concat("]");
        return str;
    }
}