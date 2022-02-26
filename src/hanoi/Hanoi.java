package hanoi;
import util.Stack;

/**
 * Classe représentant les 3 tours du problème de la tour de Hanoi.
 * Cette classe propose une résolution récursive dont le nombre d'itérations
 * est dépendant du nombre de tour donné à sa construction.
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class Hanoi {

    private final int MAX_DISK = 20;  //Pour se protéger de valeur trop grandes
    private final int NB_TOWER = 3;

    private int nbDisk;
    private int turnCnter;

    private HanoiDisplayer hanoiDisplayer;
    private Stack[] stacks = {new Stack(), new Stack(), new Stack()};

    /**
     * Constructeur de la tour. Initialise les disques à la 1er tour à gauche et les compteurs.
     * @param disks Nombre de disque total
     * @throws IllegalArgumentException Si nbDisk est une valeur > MAX_DISK ou < à 0.
     * @since 1.0
     */
    public Hanoi(int disks){
        this(disks, new HanoiDisplayer());
    }

    /**
     * Constructeur de la tour avec un HanoiDisplayer.
     * @param disks     Nombre de disque total
     * @param displayer Instance de la classe HanoiDisplayer
     * @throws IllegalArgumentException Si nbDisk est une valeur > MAX_DISK ou < à 0.
     * @since 1.0
     */
    public Hanoi(int disks, HanoiDisplayer displayer){
        if(disks <= 0 || disks > MAX_DISK)
            throw new IllegalArgumentException("Number of disk must be between 0 and "
                    + MAX_DISK + "\n");

        this.nbDisk = disks;
        turnCnter   = 0;
        this.hanoiDisplayer = displayer;

        //Initialisation de la 1er tour
        for(int i = 0; i < nbDisk; ++i)
        {
            //On ajoute un int pour récuperer un numéro d'objet lors de l'appel
            //de ChainLink.getData()
            stacks[0].add(nbDisk - i);
        }
    }

    /**
     * Affiche l'état de toute les tours à un tour donné.
     * @since 1.0
     */
    public String toString(){
        String str = ("-- Turn: " + turn() + "\n");
        String[] towerNames = {"One:","Two:","Three:"};
        for(int i = 0; i < 3; ++i){
            String s = String.format("%-7s",towerNames[i]);
            str = str.concat(s);
            str = str.concat(stacks[i].toString());
            str = str.concat("\n");
        }
        return str;
    }

    /**
     * Solve lance la récursion de transfert avec les attributs adéquats.
     * @since 1.0
     */
    public void solve(){
        hanoiDisplayer.display(this);
        transfer(stacks[0], stacks[1], stacks[2], nbDisk);
    }

    /**
     * Méthode récursive de résolution de la tour de hanoi
     * transfer() poursuit sa recursion tant que n >= 0.
     * @param from 1er tour à gauche
     * @param via  Tour au centre
     * @param to   Dernière tour à droite
     * @param n    Nombre de disque
     * @since 1.0
     */
    private void transfer(Stack from, Stack via, Stack to, int n){
        if(n!=0){
            transfer(from,to, via, n-1);
            to.add(from.pop());
            ++turnCnter;
            hanoiDisplayer.display(this);
            transfer(via, from,to, n-1);
        }
    }

    /**
     * Rend un tableau de tableaux représentant l’état des aiguilles. Pour un tel tableau t,
     * l’élément t[i][j] correspond à la taille du j-ème disque (en partant du haut) de
     * la i-ème aiguille.
     * @return Tableau 2d correspondant à l'état des 3 tours
     * @since 1.0
     */
    public int[][] status(){
        int[][] towerState = new int[NB_TOWER][];

        for(int i = 0; i < NB_TOWER; ++i){
            Object[] listDisk = stacks[i].getState();
            int[] towerSize   = new int[listDisk.length];
            towerState[i]     = towerSize;

            for(int j = 0; j < towerState[i].length; ++j){
                towerState[i][j] = (Integer)listDisk[j];
            }
        }

        return towerState;
    }

    /**
     * Indique si le déplacement des disques est terminé.
     * @return true Si la derniere tour contient le nombre total de disques
     * @since 1.0
     */
    public boolean finished(){
        return stacks[2].getNbDisk() == nbDisk;
    }

    /**
     * Retourne l'état du compteur de tour
     * @return valeur de turnCnter
     * @since 1.0
     */
    public int turn(){
        return turnCnter;
    }
}