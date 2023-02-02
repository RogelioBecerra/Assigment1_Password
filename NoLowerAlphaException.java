/**
 * NoLowerAlphaException - thrown if password does not a lower case character
 * @author rogeliobecerra
 *
 */
public class NoLowerAlphaException extends Exception{

	/**
	 * when thrown display message 
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}
