package competition;

import static org.junit.Assert.*;
import org.junit.*;


import competitor.*;
import match.*;
import observer.*;
import observer.Observer;

import java.beans.Transient;
import java.util.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public abstract class CompetitionTest {

    protected List<Competitor> competitors = new ArrayList<Competitor>();
    protected Competition competition;
    protected Competitor c1;
    protected Competitor c2;
    protected Competitor c3;
    protected Competitor c4;
    protected Competitor c5;
    protected Competitor c6;
    protected Competitor c7;
    protected Competitor c8;
    protected Competitor c9;
    protected Competitor c10;
    protected Competitor c11;
    protected Competitor c12;
    protected Competitor c13;
    protected Competitor c14;
    protected Competitor c15;
    protected Competitor c16;
    protected Competitor c17;
    protected Competitor c18;
    protected Competitor c19;
    protected Competitor c20;
    protected Competitor c21;
    protected Competitor c22;
    protected Competitor c23;
    protected Competitor c24;
    protected Match match;

    protected Journalist journalist;
    protected Bookmaker bookmaker;

    protected abstract Competition createCompetition();
    protected abstract int calculateTotalOfPoints();

    @Before
    public void setUp() {
        /**
         * This method create setup before all tests
         */
        competitors.add(this.c1 = new Competitor("Goku"));
        competitors.add(this.c2 = new Competitor("Vegeta"));
        competitors.add(this.c3 = new Competitor("Cell"));
        competitors.add(this.c4 = new Competitor("Buu"));
        competitors.add(this.c5 = new Competitor("Babidi"));
        competitors.add(this.c6 = new Competitor("Videl"));
        competitors.add(this.c7 = new Competitor("Bulma"));
        competitors.add(this.c8 = new Competitor("Majin buu"));
        competitors.add(this.c9 = new Competitor("Beerus"));
        competitors.add(this.c10 = new Competitor("Gohan"));
        competitors.add(this.c11 = new Competitor("Whis"));
        competitors.add(this.c12 = new Competitor("Freezer"));
        competitors.add(this.c13 = new Competitor("Moro"));
        competitors.add(this.c14 = new Competitor("Black Goku"));
        competitors.add(this.c15 = new Competitor("Zamasu"));
        competitors.add(this.c16 = new Competitor("Goten"));
        this.c17 = new Competitor("Pan");
        this.c18 = new Competitor("Piccolo");
        this.c19 = new Competitor("Karin");
        this.c20 = new Competitor("Krilin");
        this.c21 = new Competitor("Kaio Shin");
        this.c22 = new Competitor("Champa");
        this.c23 = new Competitor("Chichi");
        this.c24 = new Competitor("Bra");

        this.journalist = new Journalist("Axel");
        this.bookmaker = new Bookmaker("Rémi");

        competition = createCompetition();
        this.match = new MockMatchRandom(competition);
        competition.setMatch(match);
        competition.addObserver(journalist);
        competition.addObserver(bookmaker);
    }
    @Test
    public void testInit() {
        /**
         * This method verify if competitors score this 0
         */
        for (Competitor c : competitors) {
            int score = competition.getMap().get(c);
            assertEquals(score,0);
        }
    }

    @Test
    public void testPlayMatch() {
        /**
         * Check if return correctly the winner
         */
        Map<Competitor,Integer> map = competition.getMap();
        Integer res = map.get(c1);
        assertEquals(0, (int) res);
        competition.playMatch(c1, c2);
        res = map.get(c1);
        assertEquals(1, (int) res);
    }
    // Strategy 1 == 51 point
    // Strategy 2 == 175 point
    // Strategy 3 == 55 point
    @Test
    public void testCorrectNumberOfPoints() {
        /**
         * This method verify if total point assigned is correct
         */
        competition.play();
        Map<Competitor, Integer> ranks = competition.getMap();
        assertNotNull(ranks);
        int total = 0;
        System.out.println("\n*** Ranking ***");
        for (Competitor competitor : ranks.keySet()) {
            total += ranks.get(competitor);
            System.out.printf("%s - %d\n", competitor.getName(), ranks.get(competitor));
        }
        System.out.println();

        assertEquals(calculateTotalOfPoints(), total);
    }

    @Test
    public void testAddObservers() {
        Journalist nv = new Journalist("Xavier");
        assertEquals(2,competition.getObserver().size()); // au debut dans le setup il y en a 2
        competition.addObserver(nv);
        assertEquals(3,competition.getObserver().size());
        assertTrue(nv.equals(competition.getObserver().get(2)));
    }

    @Test
    public void testRemoveObservers() {
        Journalist nv = new Journalist("Xavier");
        assertEquals(2,competition.getObserver().size()); // au debut dans le setup il y en a 2
        competition.addObserver(nv);
        assertEquals(3,competition.getObserver().size());
        assertTrue(nv.equals(competition.getObserver().get(2)));

        competition.removeObserver(nv);
        assertEquals(2,competition.getObserver().size());
        for (Observer obs : competition.getObserver()) {
            assertFalse(obs.equals(nv));
        }
    }

    // ---Allow permission for tests----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(competition.CompetitionTest.class);
    }
}