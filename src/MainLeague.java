import competition.*;
import competitor.*;
import match.*;
import observer.*;
import java.util.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class MainLeague {


    public static void main(String[] args) {

        Competitor c1 = new Competitor("Fnatic");
        Competitor c2 = new Competitor("MAD Lions");
        Competitor c3 = new Competitor("Rogue");
        Competitor c4 = new Competitor("Team Liquid");
        Competitor c5 = new Competitor("T1");
        Competitor c6 = new Competitor("DWG KIA");
        Competitor c7 = new Competitor("Unicorns Of Love");

        List<Competitor> competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competitors.add(c5);
        competitors.add(c6);
        competitors.add(c7);

        Competition competition = new League(competitors);

        Match match = new MatchRandom(competition);
        competition.setMatch(match);
        // ajout d'observers
        Journalist journalist = new Journalist("Henry");
        Bookmaker bookmaker = new Bookmaker("Bob");
        competition.addObserver(journalist);
        competition.addObserver(bookmaker);

        System.out.println("\n==================");
        System.out.println("La League commence");
        System.out.println("==================\n");
        competition.displayCompetitors();
        competition.play();
        competition.ranking();

    }
}