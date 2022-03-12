package observer;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public interface Observer{

    /** This method return the name observer
     * @return The name observer
     */
    public String getName();

    /** This method treats the three competitors differently depending on the observer
     * @param c1 A competitor
     * @param c2 A competitor
     * @param winner The winner between c1 and c2
     */
    public void observerTraitement(Competitor c1, Competitor c2, Competitor winner);

    /** Indicates whether some other object is "equal to" this one.
     * @param new_rating obj - the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object o);
}