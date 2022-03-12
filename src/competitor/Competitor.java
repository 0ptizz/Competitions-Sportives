package competitor;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class Competitor {
    private String name;
    private Integer rating;

    /** Constructor competitor
     * @param name The name competitor
     */
    public Competitor(String name) {
        this.name = name;
        this.rating = 1;
    }

    /** This method return the name competitor
     * @return The name competitor
     */
    public String getName() {
        return this.name;
    }
    /** This method return the rating competitor
     * @return The rating competitor
     */
    public Integer getRating() {
        return this.rating;
    }

    /** This method set the rating competitor.
     * @param new_rating The new rating competitor (if < 1 do nothing)
     */
    public void setRating(Integer new_rating) {
        if (new_rating < 1) {
            ;
        }
        else {
            this.rating = new_rating;
        }
    }
    /** Indicates whether some other object is "equal to" this one.
     * @param new_rating obj - the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Competitor) {
            Competitor other = (Competitor) o;
            return (this.name == other.name) && (this.rating == other.rating);
        }
        else {
            return false;
        }
    }
}