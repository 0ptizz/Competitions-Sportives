package observer;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class Bookmaker implements Observer{
    private String name;

    /** Constructor Bookmaker
     * @param name The name bookmaker
     */
    public Bookmaker(String name) {
        this.name = name;
    }

    /** This method return the name bookmaker
     * @return The name bookmaker
     */
    public String getName() {
        return this.name;
    }

    /** This method display the rating of c1, c2 and the winner
     * @param c1 A competitor
     * @param c2 A competitor
     * @param winner The winner between c1 and c2
     */
    public void observerTraitement(Competitor c1, Competitor c2, Competitor winner) {
        Integer rating_c1 = c1.getRating();
        Integer rating_c2 = c2.getRating();
        if (winner.equals(c1)) {
            c1.setRating(rating_c1-1);
            c2.setRating(rating_c2+1);
            System.out.println(c1.getName() + " wins " + " (rating " + c1.getRating() + ") against " + c2.getName() + " (rating " + c2.getRating() + ")");
        }
        else {
            c1.setRating(rating_c1+1);
            c2.setRating(rating_c2-1);
            System.out.println(c2.getName() + " wins " + " (rating " + c2.getRating() + ") against " + c1.getName() + " (rating " + c1.getRating() + ")");
        }
    }

    /** Indicates whether some other object is "equal to" this one.
     * @param new_rating obj - the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Bookmaker) {
            Bookmaker other = (Bookmaker) o;
            return (this.name == other.name);
        }
        else {
            return false;
        }
    }
}