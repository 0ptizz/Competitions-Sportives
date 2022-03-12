package competition;

/**
 * @author Roelants Axel, Dewame Remi
 * @version 1.0
 */
public class LeagueTest extends CompetitionTest {
    @Override
    protected Competition createCompetition() {
        return new League(competitors);
    }

    @Override
    protected int calculateTotalOfPoints() {
        return competition.competitors.size()*(competition.competitors.size()-1);
    }




    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(competition.LeagueTest.class);
    }
}