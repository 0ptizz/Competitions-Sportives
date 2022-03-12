package competition;

import competitor.*;
import java.util.*;

/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public class StrategyFirstAndTwoSecondAndTwoLast extends Master{
    /** Constructor Master with StrategyFirstAndTwoSecondAndTwoLast
     * @param competitors The List of competitors
     * @param Nb_competitors The numbers of competitors
     * @param Nb_teams The numbers of teams
     */
    public StrategyFirstAndTwoSecondAndTwoLast(List<Competitor> competitors, int Nb_competitors, int Nb_teams) {
        super(competitors, Nb_competitors, Nb_teams);
    }
    /**This method build strategy
     *
     */
    protected void strat() {
        takeLine(1);
        takeXBestOfLine(2, 2);
        takeXBestOfLine((Nb_competitors/Nb_teams), 2);
    }
}
