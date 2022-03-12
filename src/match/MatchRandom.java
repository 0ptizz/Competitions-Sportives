package match;
import competitor.*;
import competition.*;
import java.util.Random;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 1.0
 */
public class MatchRandom implements Match{
    private Competition competition;

    /** Constructor Matchrandom
     * @param competition The competition
     */
    /*mettre une competition en param ?  */
    public MatchRandom(Competition competition/*Competitor c1 , Competitor c2*/) {
        /*super(c1,c2);*/
        this.competition = competition;
    }

    /** This method play a match between competitor c1 and competitor c2
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     */
    public void play(Competitor c1, Competitor c2) {
        this.competition.playMatch(c1,c2);
    }

    /** This method return the winner, the competitors each have a 50% chance
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     * @return The winner
     */
    public Competitor giveWinner(Competitor c1, Competitor c2) {
        Random rand = new Random();
        int res = rand.nextInt(2);
        if (res == 0) {
            return c1;
        }
        else {
            return c2;
        }

    }
}