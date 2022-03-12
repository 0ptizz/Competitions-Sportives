package competition;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public class MasterStrategy3Test extends MasterTest{
    @Override
    protected Competition createCompetition() {
        return new StrategyFirstAndTwoSecondAndTwoLast(competitors, 16, 4);
    }

    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(competition.MasterStrategy3Test.class);
    }
}
