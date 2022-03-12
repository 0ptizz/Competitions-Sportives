package competition;

/**
 * This class refer to a personalize exception when 
 * the number of players in the Tournament is not a power of two.
 */
public class TournamentException extends RuntimeException {

	public TournamentException( String msg) {
		super(msg);
	}
}