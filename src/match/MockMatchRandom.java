package match;

import competition.Competition;
import competitor.Competitor;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 1.0
 */
public class MockMatchRandom extends MatchRandom {
    /** Constructor MockMatchRandom
     * @param competition The competiton
     */
    public MockMatchRandom(Competition competition) {
        super(competition);
    }

    /** This method return the winner, the competitor 1 always win
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     * @return The winner, competitor 1
     */
    public Competitor giveWinner(Competitor c1, Competitor c2) {
            return c1;
        }

    }
