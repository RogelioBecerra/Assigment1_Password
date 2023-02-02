
/**
 * LengthException - thrown if password is not long enough
 * @author rogeliobecerra
 *
 */
public class LengthException extends Exception {

	
	/**
	 * when thrown display message 
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
