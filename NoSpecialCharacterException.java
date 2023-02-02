/**
 * NoSpecialCharacterException - thrown if password does not have a special character
 * @author rogeliobecerra
 *
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * when thrown display message 
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}
