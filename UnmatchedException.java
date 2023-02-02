/**
 * UnmatchedException - happens when passwords do not match
 * @author rogeliobecerra
 *
 */
public class UnmatchedException extends Exception{
	/**
	 * when thrown display message 
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
	
}
