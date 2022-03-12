package match;
import competition.*;
import competitor.*;
import static org.junit.Assert.*;
import org.junit.*;


import java.util.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 1.0
 */
public class MockMatchRandomTest {
    private Competitor c1;
    private Competitor c2;
    private MockMatchRandom match;
    private Competition competition;
    @Before
    public void setUp() {
        /**
         * This method create setup before all tests
         */
        // Create Competitor
        this.c1 = new Competitor("Goku");
        this.c2 = new Competitor("Vegeta");
        // Create List
        List<Competitor> competitors = new ArrayList<>();
        // Add competitor in list
        competitors.add(this.c1);
        competitors.add(this.c2);
        // create and set league competition
        this.competition = new League(competitors);
        // create and set match for league competition
        this.match = new MockMatchRandom(competition);
        this.competition.setMatch(match);
    }

    @Test
    public void TestgiveWinner() {
        /**
         * Check if givewinner return correctly the winner c1
         */
        assertEquals(match.giveWinner(c1,c2), c1);
    }

    @Test
    public void Testplay() {
        /**
         * Check if total score is correct
         */
        Map<Competitor,Integer> map = this.competition.getMap();
        Integer res = map.get(c1);
        assertTrue(res == 0);
        this.match.play(c1,c2);
        res = map.get(c1);
        assertTrue(res == 1);
    }

        // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(match.MockMatchRandomTest.class);
    }
    
}

