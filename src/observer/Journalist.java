package observer;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class Journalist implements Observer{
    private String name;

    /** Constructor Journalist
     * @param name The name journalist
     */
    public Journalist(String name) {
        this.name = name;
    }

    /** This method return the name journalist
     * @return The name journalist
     */
    public String getName() {
        return this.name;
    }

    /** This method display the winner between c1 and c2
     * @param c1 A competitor
     * @param c2 A competitor
     * @param winner The winner between c1 and c2
     */
    public void observerTraitement(Competitor c1, Competitor c2, Competitor winner) {
        System.out.println( c1.getName()+"   vs     " + c2.getName() + "   ---->    " + winner.getName() + " wins !");
    }

    /** Indicates whether some other object is "equal to" this one.
     * @param new_rating obj - the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Journalist) {
            Journalist other = (Journalist) o;
            return (this.name == other.name);
        }
        else {
            return false;
        }
    }
}