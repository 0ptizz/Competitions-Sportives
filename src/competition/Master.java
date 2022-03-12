package competition;
import match.*;
import competitor.*;
import java.util.*;
import observer.Observer;
import util.MapUtil;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public abstract class Master extends Competition{
    protected int Nb_competitors;
    protected int Nb_teams;

    protected List<League> leagues;
    protected Tournament tournament;

	protected List<List<Competitor>> group_stage;
    protected List<Map<Competitor,Integer>> rank_stage;
	protected List<Competitor> finalists;

    /** Constructor Master
     * @param competitors The List of competitors
     * @param Nb_competitors The numbers of competitors
     * @param Nb_teams The numbers of teams
     */
    public Master(List<Competitor> competitors, int Nb_competitors, int Nb_teams) {
        super(competitors);
        this.Nb_competitors = Nb_competitors;
        this.Nb_teams = Nb_teams;
        List<Competitor> cop = new ArrayList<Competitor>(competitors);

        //Create the list of groups with competitors + Create leagues
        this.leagues = new ArrayList<League>(this.Nb_teams);
        this.group_stage = new ArrayList<List<Competitor>>(this.Nb_teams);
        for (int i = 0; i < Nb_teams; i++) {
            List<Competitor> grp = new ArrayList<Competitor>();
            //Fill the list randomly
            for(int j = 0; j < Nb_competitors/Nb_teams; j++) {
                Random random = new Random();
                int sup = random.nextInt(cop.size());
                grp.add(cop.get(sup));
                cop.remove(sup);
            }
            this.group_stage.add(grp);
            League lg = new League(grp);
			Match match = new MatchRandom(lg);
			lg.setMatch(match);
            this.leagues.add(lg);
        }
        //Create the finalists list
        this.finalists = new ArrayList<Competitor>();
        //Create the score list of each players
        this.rank_stage = new ArrayList<Map<Competitor,Integer>>(this.Nb_teams);
    }

    /** This method get number of teams
     * @return Number of teams
     */
    public int getNbteams(){
        return Nb_teams;
    }
    /** This method get number of competitors
     * @return Number of competitors
     */
    public int getNbcompetitors(){
        return Nb_competitors;
    }

    /** This method get finalist of list
     * @return Finalist of list
     */
    public List<Competitor> getfinalist(){
        return finalists;
    }

    /** This method set the observers on the leagues
     */
    private void setObserversLeagues() {
        
        for (League lg : this.leagues) {
            for (Observer obs : this.getObserver()) {
                lg.addObserver(obs);
            }
        }
    }

    /** This method set the observers on the tournament
     */
    private void setObserversTournament() {
        for (Observer obs : this.getObserver()) {
                tournament.addObserver(obs);
        }
    }

    /** This method dysplay the group stage
     */
    private void displayGroupStage() {
        System.out.println("Les équipes :");
        System.out.println("-------------\n");
        int nb_groupe = 1;
        for (League l : this.leagues) {
            System.out.format("%-30s","Poule " + nb_groupe);
            nb_groupe += 1;
        }

        System.out.println();
        for (League l : this.leagues) {
            System.out.format("%-30s","=======");
        }

        System.out.println();
        nb_groupe = this.leagues.get(0).getCompetitors().size();
        int cpt = 0;
        while ( nb_groupe > 0) {
            for ( League l : this.leagues) {
                System.out.format("%-30s",l.getCompetitors().get(cpt).getName());
            }
            System.out.println();
            nb_groupe -= 1;
            cpt += 1;
        }

        System.out.println("\n======================================");
        System.out.println("======================================\n");
    }

    /** This method dysplay the finalists stage
     */
    private void displayFinalistStage() {
        System.out.println("\nÉquipes sélectionnées\n");
        int nb_groupe = 1;
        for (League l : this.leagues) {
            System.out.format("%-30s","Poule " + nb_groupe);
            nb_groupe += 1;
        }

        System.out.println();
        for (League l : this.leagues) {
            System.out.format("%-30s","=======");
        }

        System.out.println();
        nb_groupe = this.leagues.get(0).getCompetitors().size();
        int cpt = 0;
        int cpt_map = 0;
        while ( nb_groupe > 0) {
            for ( League l : this.leagues) {
                Map<Competitor,Integer> tri = MapUtil.sortByDescendingValue(l.getMap());
                String stock = "";
                for (Map.Entry<Competitor,Integer> entry : tri.entrySet()) {
                    if (cpt_map == cpt) {
                        stock = entry.getKey().getName();
                        break;
                    }
                    cpt_map += 1;
                }
                for ( Competitor cmp_f : this.finalists) {
                    if (cmp_f.getName() == stock) {
                        stock += " *";
                        break;
                    }
                }
                System.out.format("%-30s",stock);
                cpt_map = 0;
            }
            System.out.println();
            nb_groupe -= 1;
            cpt += 1;
        }
    }
    /** This method play each groups like a League and in terms of the strategy play a Tournament
     * @param competitors The List of competitors
     */
    public void play(List<Competitor> competitors){
        this.setObserversLeagues();
        this.displayGroupStage();
		playGroup(this.leagues);
        strat();
        this.displayFinalistStage();
        playFinalists(this.finalists);
    }
    /** This method play each Leagues
     * @param lgs The List of leagues
     */
    public void playGroup(List<League> lgs) {
		int res = 1;
        for (League league : lgs) {
			System.out.println("\nGroup Match "+res+"\n");
			league.play();
            Map<Competitor,Integer> map = league.getMap();
            for (Map.Entry<Competitor,Integer> entry : map.entrySet()) {
                Competitor comp = entry.getKey();
                Integer score = entry.getValue();
                this.getMap().replace(comp,score);
            }
			System.out.println("\nGroup "+res+" rank");
			Map<Competitor,Integer> rank = league.ranking();
            rank = MapUtil.sortByDescendingValue(rank);
            this.rank_stage.add(rank);
			res++;
		}
	}
    /** This method play the list of finalists like a Tournament
     * @param finals The list of finalists
     */
    public void playFinalists(List<Competitor> finals) {
        this.tournament = new Tournament(finals);
        Match match = new MatchRandom(tournament);
        tournament.setMatch(match);
        this.setObserversTournament();
	    System.out.println("\nFinal Match !\n");
        this.tournament.displayCompetitors();
        tournament.play();
        Map<Competitor,Integer> map = tournament.getMap();
        for (Map.Entry<Competitor,Integer> entry : map.entrySet()) {
            String nom = entry.getKey().getName();
            Competitor comp = entry.getKey();
            Integer score = entry.getValue();
            Map<Competitor,Integer> mapMaster = this.getMap();
            for (Map.Entry<Competitor,Integer> entry2 : mapMaster.entrySet()) {
                String nom2 = entry.getKey().getName();
                Competitor comp2 = entry2.getKey();
                Integer score2 = entry2.getValue();
                if (nom==nom2){
                    this.getMap().replace(comp2,score2+score);
                    break;
                }
            }
        }
		System.out.println("\nFinal rank\n");
        tournament.ranking();
    }

    /**This method put in the list of finalists the player position l of each Leagues
     * @param l The position in the League
     */
    protected void takeLine(int l) {
        int cpt_line;
        List<Competitor> best = new ArrayList<Competitor>();
        for (Map<Competitor,Integer> map : this.rank_stage) {
            cpt_line = 0;
            for (Map.Entry<Competitor,Integer> entry : map.entrySet()) {
                if ( cpt_line==(l-1) ) {
                    Competitor comp = entry.getKey();
                    best.add(comp);
                    break;
                }
                cpt_line++;
            }
        }
        this.finalists.addAll(best);
    }

    /**This method put in the list of finalists the best x players position l of each Leagues
     * @param l The position in the League
     * @param x The Number best players
     */
    protected void takeXBestOfLine(int l,int x) {
        int cpt_line;
        Map<Competitor,Integer> res = new HashMap<>();
        /*Parcours la liste des ranks de chaque groupes */
        for (Map<Competitor,Integer> map : this.rank_stage) {
            cpt_line = 0;
            /*Parcours les ranks de chaque competitors et prend le competiteur a la ligne l*/
            for (Map.Entry<Competitor,Integer> entry : map.entrySet()) {
                if ( cpt_line==(l-1) ) {
                    Competitor comp = entry.getKey();
                    Integer score = entry.getValue();
                    res.put(comp,score);
                }
                cpt_line++;
            }
        }
        /* Tri res */
        res = MapUtil.sortByDescendingValue(res);
        /*Ajoute à la liste le nombre de x */
        Iterator<Competitor> truc = res.keySet().iterator();
        for (int i = 0; i < x; i++) {
            this.finalists.add(truc.next());
        }
    }

    /** This method build strategy
     *
     */
    protected abstract void strat();
}