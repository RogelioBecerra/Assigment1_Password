
/**
 * NoDigitException - thrown if password does not have a digit character
 * @author rogeliobecerra
 *
 */
public class NoDigitException extends Exception {
	
	/**
	 * when thrown display message 
	 */
	public NoDigitException() {
	super("The password must contain at least one digit");
	}
}
