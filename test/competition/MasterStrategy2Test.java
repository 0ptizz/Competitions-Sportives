package competition;

/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public class MasterStrategy2Test extends MasterTest{

    @Override
    protected Competition createCompetition() {
        competitors.add(c17);
        competitors.add(c18);
        competitors.add(c19);
        competitors.add(c20);
        competitors.add(c21);
        competitors.add(c22);
        competitors.add(c23);
        competitors.add(c24);
        return new StrategyTwoBestAndTwoThird(competitors, 24, 3);
    }

    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(competition.MasterStrategy2Test.class);
    }
}
