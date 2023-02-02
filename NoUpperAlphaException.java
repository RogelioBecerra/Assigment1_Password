
/**
 * NoUpperAlphaException - thrown if password does not have a upper case character
 * @author rogeliobecerra
 *
 */
public class NoUpperAlphaException extends Exception {
	/**
	 * when thrown display message 
	 */
	public NoUpperAlphaException(){
		super("The password must contain at least one uppercase alphabetic character");
	}
}
