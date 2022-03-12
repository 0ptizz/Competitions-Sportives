package competition;
import java.util.*;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class League extends Competition{

    /** Constructor League
     * @param competitors The List of competitors
     */
    public League (List<Competitor> competitors)  {
        super(competitors);
    }

    /** This method play each competitor with the other on the list (They both meet twice)
     * @param competitors The List of competitors
     */
    public void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size(); i++) {
            for (int j = 0; j < competitors.size(); j++) {
                if (competitors.get(i)==competitors.get(j)) {
                    continue;
                }
                else {

                    playMatch(competitors.get(i),competitors.get(j));

                    /* Ligne avant les observers
                    System.out.println( competitors.get(i).getName()+"   "+this.rank.get(competitors.get(i))+" vs "+this.rank.get(competitors.get(j))+"   "+ competitors.get(j).getName() );*/

                }
            }
        }
    }
}