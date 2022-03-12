package competition;
import java.util.*;
import competitor.*;
/**
 * @author Roelants Axel, Dewame Remi
 * @version 3.0
 */
public class Tournament extends Competition{

    /** Constructor Tournament
     * @param competitors The List of competitors
     * @throws TournamentException if the size of list competitors is not power of two
     */
    public Tournament (List<Competitor> competitors) throws TournamentException {
        super(competitors);
        if (!isPowerOfTwo(competitors.size())) { throw new TournamentException(competitors.size() + " pas une puissance de 2"); }
    }
    
    /**
	 * This method verify if the number of players in this Tournament is a power of two.
	 * @param nbPlayer		The the number of Competitor subscribed in the Tournament
	 * @return	If true the number of Competitor is a power of two else it's not
	 */
	protected static boolean isPowerOfTwo(int nbPlayer) {
		return (int)(Math.ceil((Math.log(nbPlayer) / Math.log(2)))) == (int)(Math.floor(((Math.log(nbPlayer) / Math.log(2)))));
	}
    
    /** This method play each competitor with the other on the list and the winner add new list for next round
     * @param competitors The List of competitors
     */
    public void play(List<Competitor> competitors) {
        int score = 1;
        List<Competitor> copy = new ArrayList<Competitor>(competitors);
        List<Competitor> winners = new ArrayList<Competitor>();
        while (copy.size() != 1) {

            if ( copy.size() == 2) {
                System.out.println("Finale\n");
            }
            else {
                System.out.println("1/"+ (copy.size()/2) +" finales\n");
            }

            winners.clear();

            for(int i = 0; i < copy.size(); i = i + 2) {

                playMatch(copy.get(i),copy.get(i+1));

                /* Ligne avant les observers
                System.out.println( copy.get(i).getName()+"   "+this.rank.get(copy.get(i))+" vs "+this.rank.get(copy.get(i+1))+"   "+ copy.get(i+1).getName() );*/
            }
            for(int i = 0; i < copy.size(); i++) {
                if (this.rank.get(copy.get(i)) == score) {
                    winners.add(copy.get(i));
                }
            }
            System.out.println("\n");
            copy.retainAll(winners);
            score+=1;
        }
    }
}