/**
 * WeakPasswordException - thrown if password is weak
 * @author rogeliobecerra
 *
 */
public class WeakPasswordException extends Exception {
	/**
	 * when thrown display message 
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
