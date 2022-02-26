package util;

/**
 * Classe représentant le maillon d'une liste d'objet disques.
 *
 * Remarque: Si le maillon courrant est déjà vide, getNext va générer
 * une exception de type NullPointerException.
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class ChainLink {

    private Object    disk;
    private ChainLink next;

    /**
     * Constructeur
     * @param disk  Disk à insérer dans le maillon
     * @param next  Prochain maillon, null si 1er maillon
     * @since 1.0
     */
    public ChainLink(Object disk, ChainLink next){
        this.disk  = disk;
        this.next  = next;
    }

    /**
     * Retourne le disque courrant.
     * @return disk
     * @throws NullPointerException si le maillon ne contient aucun disque
     * @since 1.0
     */
    public Object  getDisk(){
        if(disk == null)
            throw new NullPointerException("Contain an empty Disk");
        return disk;
    }

    /**
     * Retourne la chainLinkSuivante. Retourne NULL en fin de chaine.
     * @return  prochaine chainLink
     * @since 1.0
     */
    public ChainLink getNext(){
        return next;
    }
}