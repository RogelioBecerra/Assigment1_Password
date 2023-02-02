import java.util.ArrayList;

/**
 * Methods that check is a string password is valid
 * @author rogeliobecerra
 *
 */

public class PasswordCheckerUtility {

	//Constructor
	/**
	 * constructor
	 */
	public PasswordCheckerUtility()
	{}
	
	/**
	 * checks if two passwords are the same
	 * @param password - A password
	 * @param passwordConfirm - A Password
	 * @throws UnmatchedException - happens when passwords do not match
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!(passwordConfirm.equals(password)))
		{
			throw new UnmatchedException();
		}
	}
	
	/**
	 * checks if two passwords are the same
	 * @param password - A password
	 * @param passwordConfirm - A password
	 * @return True if the passwords are the same. False if passwords are not the same.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(password.equals(passwordConfirm)){
			return true;
		}
		return false;
	}
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords 
	 * @param passwords - A password
	 * @return A arrayList of invalid passwords with what is exception message
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> InvalidPasswords = new ArrayList<>();
		
		for(int i = 0; i < passwords.size();i++) {

			try {
				isValidPassword(passwords.get(i));
			} catch (LengthException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoDigitException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoUpperAlphaException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoLowerAlphaException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (InvalidSequenceException e) {
				InvalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
	
		return InvalidPasswords;
	}
	
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password - password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChar(String password) {
		
		int size = password.length();
		
		if(size >= 6 && size <=9)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks the password Digit requirement, Password must contain a numeric character
	 * @param password - password string to be checked for
	 * @return true if meet Digit requirement
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		int size = password.length();
		
		for(int i = 0; i < size; i++) {
			
			char val = password.charAt(i);
			
			if(val >= 48 && val <= 57) {
				return true;
			}
		}
	throw new NoDigitException();		
	}
	
	/**
	 * Checks the password lowercase requirement, Password must contain at least one lowercase alpha character
	 * @param password - Password to be checked
	 * @return true if password has a lowercase character
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
	int size = password.length();
			
			for(int i = 0; i < size; i++) {
				
				char val = password.charAt(i);
				
				if(val >= 97 && val <= 122) {
					return true;
				}
			}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password to be checked
	 * @return true if password has a special character 
	 * @throws NoSpecialCharacterException  thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		int size = password.length();
			
			for(int i = 0; i < size; i++) {
				
				char val = password.charAt(i);
				
				if((val >= 33 && val <= 47) || val >=58 && val <=64) {
					return true;
				}
			}
			throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password to be checked
	 * @return true if password has uppercase character
	 * @throws NoUpperAlphaException - thrown if password does not have a upper case character
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		int size = password.length();
		
		for(int i = 0; i < size; i++) {
			
			char val = password.charAt(i);
			
			if(val >= 65 && val <= 90) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password to be checked
	 * @return true if password is at least 6 characters long
	 * @throws LengthException  thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() >= 6)
		{
			return true;
		}
		throw new LengthException();
	}
	
	/**
	 * Validates passwords
	 * @param password to be checked
	 * @return true if password passed all requirements. false if it done not pass all requirements
	 * @throws LengthException -  thrown if does not meet minimum length requirement
	 * @throws NoDigitException - thrown if password does not have a digit
	 * @throws NoUpperAlphaException - thrown if password does not have a upper case character
	 * @throws NoLowerAlphaException - thrown if password does not have a lower case character
	 * @throws NoSpecialCharacterException - thrown if password does not have a special character
	 * @throws InvalidSequenceException - thrown if password has to of the same characters in sequence of each other
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException {
		
		if(isValidLength(password) && hasDigit(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasSpecialChar(password) && noSameCharInSequence(password))
		return true;

		return false;
	}
	
	
	 /**
	  * checks if password is weak
	  * @param password to be checked
	  * @return false if password is not week 
	  * @throws WeakPasswordException - thrown if password is weak
	  * @throws LengthException - thrown if password is not long enough
	  * @throws NoDigitException - thrown if password does not have a digit character
	  * @throws NoUpperAlphaException - thrown if password does not a upper case character
	  * @throws NoLowerAlphaException - thrown if password does not a lower case character
	  * @throws NoSpecialCharacterException - thrown if password does not a special character
	  * @throws InvalidSequenceException - thrown if password has to of the same characters in sequence of each other
	  */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException { 
		
		int size = password.length();
		if(isValidPassword(password) == true && size < 6 || size > 9)
		{
			return false;
		}
		else
			throw new WeakPasswordException();
	}
	
	
	
	
	/**
	 * check that there is no two characters in sequence of each other are the same
	 * @param password to check
	 * @return true if there is no two characters in sequence of each other are the same
	 * @throws InvalidSequenceException - thrown if password has to of the same characters in sequence of each other
	 */
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException { 
		
		int size = password.length();
		
		for(int i = 0; i < size-1; i++) {
			
			char before = password.charAt(i);
			char after = password.charAt(i+1);
			if(before == after)
			{
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	
	
	
}
