package match;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 1.0
 */
public interface Match {

    /** This method play competitor 1 vs competitor 2
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     */
    public void play(Competitor c1, Competitor c2);

    /** This method return the winner
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     * @return The winner
     */
    public Competitor giveWinner(Competitor c1, Competitor c2);
} 