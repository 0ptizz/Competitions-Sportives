package competition;

import org.junit.*;

/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public class TournamentTest extends CompetitionTest {
    @Override
    protected Competition createCompetition() {
        return new Tournament(competitors);
    }

    @Override
    protected int calculateTotalOfPoints() {
        return competition.competitors.size()-1;
    }

    @Test(expected=TournamentException.class)
    public void IsNotPow2() {
        /**
         * Check if this exception is thrown
         */
        this.competitors.add(c17);
        System.out.println(this.competitors);
        this.competition = new Tournament(competitors);
    }


    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(competition.TournamentTest.class);
    }
}