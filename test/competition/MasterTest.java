package competition;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 2.0
 */
public abstract class MasterTest extends CompetitionTest {

    @Override
    protected int calculateTotalOfPoints() {
        Master master = (Master) competition;
        return (((master.competitors.size()/master.getNbteams())*((master.competitors.size()-1)/master.getNbteams()))*master.getNbteams()+master.getfinalist().size())-1;

    }

    @Test
    public void testMasterGetFinalPhaseWinner(){
        /**
         * This method verify if list of finalist is empty before and after play match
         */
        Master master = (Master) competition;
        assertTrue(master.getfinalist().isEmpty());
        master.play();
        assertFalse(master.getfinalist().isEmpty());
    }

    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MasterTest.class);
    }
}
