import competition.*;
import competitor.*;
import match.*;
import observer.*;
import java.util.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class MainMaster {


    public static void main(String[] args) {

        Competitor c1 = new Competitor("Fnatic");
        Competitor c2 = new Competitor("MAD Lions");
        Competitor c3 = new Competitor("Rogue");
        Competitor c4 = new Competitor("Team Liquid");
        Competitor c5 = new Competitor("T1");
        Competitor c6 = new Competitor("DWG KIA");
        Competitor c7 = new Competitor("Unicorns Of Love");
        Competitor c8 = new Competitor("Cloud 9");
        Competitor c9 = new Competitor("G2 Esports");
        Competitor c10 = new Competitor("Excel");
        Competitor c11 = new Competitor("Team Vitality");
        Competitor c12 = new Competitor("Misfits Gaming");
        Competitor c13 = new Competitor("SK Gaming");
        Competitor c14 = new Competitor("Astralis");
        Competitor c15 = new Competitor("Schalke 04");
        Competitor c16 = new Competitor("FunPlus Phoenix");
        Competitor c17 = new Competitor("Edward Gaming");
        Competitor c18 = new Competitor("100 Thieves");
        Competitor c19 = new Competitor("PSG Talon");
        Competitor c20 = new Competitor("Royal Never Give Up");
        Competitor c21 = new Competitor("Gen G");
        Competitor c22 = new Competitor("DetonatioN FocusMe");
        Competitor c23 = new Competitor("LNG Esports");
        Competitor c24 = new Competitor("Hanwha Life Esport");

        Journalist journalist = new Journalist("Henry");
        Bookmaker bookmaker = new Bookmaker("Bob");

        System.out.println("Choose the strategy BestOne : Tap 1");
        System.out.println("Choose the strategy TwoBestAndTwoThird : Tap 2");
        System.out.println("Choose the strategy FirstAndTwoSecondAndTwoLast : Tap 3");
        Scanner scanner = new Scanner( System.in ) ;
        int a = scanner.nextInt();

        if (a==1) {

        List<Competitor> competitors1 = new ArrayList<>();
        competitors1.add(c1);
        competitors1.add(c2);
        competitors1.add(c3);
        competitors1.add(c4);
        competitors1.add(c5);
        competitors1.add(c6);
        competitors1.add(c7);
        competitors1.add(c8);
        competitors1.add(c9);
        competitors1.add(c10);
        competitors1.add(c11);
        competitors1.add(c12);
        competitors1.add(c13);
        competitors1.add(c14);
        competitors1.add(c15);
        competitors1.add(c16);

        Master competition1 = new StrategyBestOne(competitors1,16,4);

        Match match1 = new MatchRandom(competition1);
        competition1.setMatch(match1);

        // ajout d'observers
        competition1.addObserver(journalist);
        competition1.addObserver(bookmaker);

        System.out.println("\n==================");
        System.out.println("Le Master commence");
        System.out.println("==================\n");
        competition1.displayCompetitors();
        competition1.play();

        }
        else if (a==2) {
        List<Competitor> competitors2 = new ArrayList<>();
        competitors2.add(c1);
        competitors2.add(c2);
        competitors2.add(c3);
        competitors2.add(c4);
        competitors2.add(c5);
        competitors2.add(c6);
        competitors2.add(c7);
        competitors2.add(c8);
        competitors2.add(c9);
        competitors2.add(c10);
        competitors2.add(c11);
        competitors2.add(c12);
        competitors2.add(c13);
        competitors2.add(c14);
        competitors2.add(c15);
        competitors2.add(c16);
        competitors2.add(c17);
        competitors2.add(c18);
        competitors2.add(c19);
        competitors2.add(c20);
        competitors2.add(c21);
        competitors2.add(c22);
        competitors2.add(c23);
        competitors2.add(c24);

        Master competition2 = new StrategyTwoBestAndTwoThird(competitors2,24,3);

        Match match2 = new MatchRandom(competition2);
        competition2.setMatch(match2);

        // ajout d'observers
        competition2.addObserver(journalist);
        competition2.addObserver(bookmaker);

        System.out.println("\n==================");
        System.out.println("Le Master commence");
        System.out.println("==================\n");
        competition2.displayCompetitors();
        competition2.play();
        }

        else if (a==3) {
            List<Competitor> competitors3 = new ArrayList<>();

            competitors3.add(c1);
            competitors3.add(c2);
            competitors3.add(c3);
            competitors3.add(c4);
            competitors3.add(c5);
            competitors3.add(c6);
            competitors3.add(c7);
            competitors3.add(c8);
            competitors3.add(c9);
            competitors3.add(c10);
            competitors3.add(c11);
            competitors3.add(c12);
            competitors3.add(c13);
            competitors3.add(c14);
            competitors3.add(c15);
            competitors3.add(c16);

            Master competition3 = new StrategyFirstAndTwoSecondAndTwoLast(competitors3,16,4);

            Match match3 = new MatchRandom(competition3);
            competition3.setMatch(match3);

            // ajout d'observers
            competition3.addObserver(journalist);
            competition3.addObserver(bookmaker);

            System.out.println("\n==================");
            System.out.println("Le Master commence");
            System.out.println("==================\n");
            competition3.displayCompetitors();
            competition3.play();
        }
        scanner.close();
    }
}