

/**
 * InvalidSequenceException - thrown if password has to of the same characters in sequence of each other
 * @author rogeliobecerra
 *
 */
public class InvalidSequenceException extends Exception {

	/**
	 * when thrown display message 
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
}
