package hanoi;
import hanoi.gui.JHanoi;

/**
 * Programme de résolution du problème des tours de Hanoi.
 *
 * @author Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        try{
            if(args.length == 0){
                //Mode graphique
                new JHanoi();
            }
            else if(args.length == 1){
                //Mode console
                Integer nbDiscs = Integer.parseInt(args[0]); //Argument (nombre de disques)
                Hanoi hanoi = new Hanoi(nbDiscs);
                hanoi.solve();
            }
            else{
                throw new RuntimeException("Too many arguments - Graphic mod = 0 arg | " +
                                           "Console mod = 1 arg (number of discs)");
            }
        }
        catch(RuntimeException exception){
            System.out.println("Exception : " + exception.getMessage());
        }
    }
}