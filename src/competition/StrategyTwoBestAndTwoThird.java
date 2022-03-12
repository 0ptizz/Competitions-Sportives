package competition;

import competitor.*;
import java.util.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public class StrategyTwoBestAndTwoThird extends Master{
    /** Constructor Master with StrategyTwoBestAndTwoThird
     * @param competitors The List of competitors
     * @param Nb_competitors The numbers of competitors
     * @param Nb_teams The numbers of teams
     */
    public StrategyTwoBestAndTwoThird(List<Competitor> competitors, int Nb_competitors, int Nb_teams) {
        super(competitors, Nb_competitors, Nb_teams);
    }
    /**This method build strategy
     *
     */
    protected void strat() {
        takeLine(1);
        takeLine(2);
        takeXBestOfLine(3, 2);
    }
}
