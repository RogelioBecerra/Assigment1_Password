
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Rogelio Becerra
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	String pw1;
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		pw1 = "PerfectPasword$9";
		
		String[] p = {"BMW14", "MAXBLACK27", "Messi-10", "japan1010"};
		passwords = new ArrayList<>();
		passwords.addAll(Arrays.asList(p));
		
	} 

	@After
	public void tearDown() throws Exception {
		pw1 = null;
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pw1));		//Good case
		 	assertEquals(true,PasswordCheckerUtility.isValidPassword("sS!1"));	//Bad case
		}
		catch(LengthException e) {
		assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pw1));		//Good case
		 	assertEquals(true,PasswordCheckerUtility.isValidPassword("no-upper8"));	//Bad case
		}
		catch(NoUpperAlphaException e) {
		assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(pw1));		//Good case
		 	assertEquals(true,PasswordCheckerUtility.isValidPassword("NO-LOWER1"));	//Bad case
		}
		catch(NoLowerAlphaException e) {
		assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(pw1));		// Good case
			assertFalse(PasswordCheckerUtility.isWeakPassword("isWeak!1"));	// Bad case
			}
			catch(WeakPasswordException e) {
			assertTrue("Successfully threw a WeakPasswordException",true);
			}
			catch(Exception e)
			{
				assertTrue("Threw some other exception",false);
			}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
		 	assertTrue(PasswordCheckerUtility.isValidPassword(pw1));		//Good case
		 	assertEquals(true,PasswordCheckerUtility.isValidPassword("bb12345$M"));		//Bad case
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(pw1));		// Good case
			assertFalse(PasswordCheckerUtility.isWeakPassword("noDigit!"));	// Bad case
			}
			catch(NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException",true);
			}
			catch(Exception e)
			{
				assertTrue("Threw some other exception",false);
			}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()          
	{
		try{
		 	assertTrue(PasswordCheckerUtility.isValidPassword(pw1));		//Good cases
		 	assertTrue(PasswordCheckerUtility.isValidPassword("Gud123$"));		
		 	assertTrue(PasswordCheckerUtility.isValidPassword("F1!race"));		
		}
		catch(Exception e)
		{
			assertTrue("Threw some exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner sc = new Scanner(results.get(0)); 
		assertEquals(sc.next(), "BMW14");
		String nextResults = sc.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		sc = new Scanner(results.get(1));  
		assertEquals(sc.next(), "MAXBLACK27");
		nextResults = sc.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("lower"));
		
		 
		sc = new Scanner(results.get(2));  
		assertEquals(sc.next(), "Messi-10");
		nextResults = sc.nextLine().toLowerCase();
		assertTrue(nextResults.contains("character"));
		
				sc = new Scanner(results.get(3));  
		assertEquals(sc.next(), "japan1010");
		nextResults = sc.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		sc.close();
		
		
	}
	
}