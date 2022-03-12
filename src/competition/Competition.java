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
public abstract class Competition {
    protected Match match;
    protected List<Competitor> competitors;
    protected Map<Competitor,Integer> rank;
    private List<Observer> observers;

    /** Constructor competition
     * @param competitors The List of competitors
     */
    public Competition (List<Competitor> competitors) {
        this.match = null;
        this.observers = new ArrayList<Observer>();
        this.competitors = competitors;
        this.rank = new HashMap<>();
        for (Competitor key : this.competitors) {
            rank.put(key,0);
        }
    }

    /** This method return the competitors
     *
     * @return the competitors
     */
    public List<Competitor> getCompetitors() {
        return this.competitors;
    }

    /** This method set match of competition
     * @param match The match
     */
    public void setMatch(Match match) {
        this.match = match;
    }

    /** This method return the rank of competition
     *
     * @return the rank of competition
     */
    public Map<Competitor,Integer> getMap() {
        return this.rank;
    }

    /** This method play a competition in list of competitors
     *
     */
    public void play() {
        play(competitors);
    }

    /** This method play a competition in list of competitors
     * @param competitors The List of competitors
     */
    public abstract void play(List<Competitor> competitors);

    /** This method play a match between competitor c1 and competitor c2
     * @param c1 The competitor 1
     * @param c2 The competitor 2
     */
    public void playMatch(Competitor c1, Competitor c2) {
        Competitor win = this.match.giveWinner(c1,c2);
        this.traitement(c1, c2, win);
        Integer points = this.rank.get(win);
        this.rank.put(win,points+1);
    }

    /** This method return the observers
     *
     * @return the observers
     */
    public List<Observer> getObserver() {
        return this.observers;
    }

    /** This method add a observer in the competition
     * @param obs the observers added to the competition
     */
    public void addObserver(Observer obs) {
        if (observers.contains(obs)) { return ; }
        observers.add(obs);
    }

    /** This method remove a observer in the competition
     * @param obs the observers removed to the competition
     */
    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    /** This method treats three competitors on all the observers
     * @param c1 A competitor
     * @param c2 A competitor
     * @param winner The winner between c1 and c2
     */
    public void traitement(Competitor c1, Competitor c2, Competitor winner) {
        if (this.getObserver().size() == 0) { return; }
        for ( Observer obs : this.getObserver()) {
            obs.observerTraitement(c1, c2, winner);
        }
    }
    /**
     * This method sort by the score of competitors
     * @return The ranking of competitors
     */
    public Map<Competitor,Integer> ranking() {
        System.out.println("\n****  Ranking  ****");
        Map<Competitor,Integer> tri = MapUtil.sortByDescendingValue(this.rank);
        for (Map.Entry<Competitor,Integer> entry : tri.entrySet()) {
            String comp = entry.getKey().getName();
            Integer score = entry.getValue();
            System.out.println(comp + " a un score de " + score + " !");
        }
        return rank;
    }

    /** This method display the competitors
     */
    public void displayCompetitors() {

        System.out.println("Les équipes en jeu");
        System.out.println("------------------\n");
        for (Competitor cmp : this.competitors) {
            System.out.println(cmp.getName());
        }
        System.out.println();
    }

}