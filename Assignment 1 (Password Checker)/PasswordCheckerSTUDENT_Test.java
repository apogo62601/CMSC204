
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Aelina Pogosian
 *
 */
public class PasswordCheckerSTUDENT_Test {
	String invalidPassword, validPassword = "Abc1234567!";
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
		invalidPasswork = null;
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		invalidPassword = "Abc2!";
		
		try {
				
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidPassword));
		}
		catch (LengthException ex) {
			
			// Pass if the LengthException is thrown.
			assertTrue("Success! LengthException thrown!", true);
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		invalidPassword = "abcdef123456!";
		
		try {
				
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidPassword));
		}
		catch (NoUpperAlphaException ex) {
			
			// Pass if the NoUpperAlphaException is thrown.
			assertTrue("Success! NoUpperAlphaException thrown!", true);
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		invalidPassword = "ABCDEF123456!";
		
		try {
				
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidPassword));
		}
		catch (NoLowerAlphaException ex) {
			
			// Pass if the NoLowerAlphaException is thrown.
			assertTrue("Success! NoLowerAlphaException thrown!", true);
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		invalidPassword = "Abc123!";
		
		try {
				
			// Pass if the isWeakPassword returns false.
			assertFalse(PasswordCheckerUtility.isWeakPassword(validPassword));
			
			// Pass if the isWeakPassword returns true.
			assertTrue(PasswordCheckerUtility.isWeakPassword(invalidPassword));
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		invalidPassword = "AAAbbbccc123!";
		
		try {
				
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidPassword));
		}
		catch (InvalidSequenceException ex) {
			
			// Pass if the InvalidSequenceException is thrown.
			assertTrue("Success! InvalidSequenceException thrown!", true);
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
invalidPassword = "AAAbbbcccddd!";
		
		try {
				
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidPassword));
		}
		catch (NoDigitException ex) {
			
			// Pass if the NoDigitException is thrown.
			assertTrue("Success! NoDigitException thrown!", true);
		}
		catch(Exception ex) {
			
			assertTrue("Failed! Other exception thrown!", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			
			// Pass if isValidPassword returns true.
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
		}
		catch(Exception ex) {
			
			assertTrue("Failed! An exception was thrown!", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwordList = new ArrayList<String>();
		ArrayList<String> invalidPasswordList = new ArrayList<String>();
		ArrayList<String> officialInvalidPasswordList = new ArrayList<String>();
			
		String[] passwords = {"a1A#b1Bc1Cd1D", "334455BB#", "Im2cool4U#", "george2ZZZ#", 
				"4Sale#", "bertha22", "4wardMarch#", "august30", "a2cDe", "ApplesxxYYzz#", 
				"aa11bb", "pilotProject", "myPassword", "myPassword2", "myPassword2#"};
		
		String[] officialInvalidPasswords = {"334455BB#", "george2ZZZ#", "4Sale#", "bertha22", "august30", 
				"a2cDe", "ApplesxxYYzz#", "aa11bb", "pilotProject", "myPassword", "myPassword2"};
		
		passwordList.addAll(Arrays.asList(passwords));
		officialInvalidPasswordList.addAll(Arrays.asList(officialInvalidPasswords));
		
		invalidPasswordList = PasswordCheckerUtility.getInvalidPasswords(passwordList);
		
		if (invalidPasswordList.size() == officialInvalidPasswordList.size()) {
			for (int counter = 0; counter < officialInvalidPasswordList.size(); counter++) {
			
				assertEquals(invalidPasswordList.get(counter), officialInvalidPasswordList.get(counter));
			}
		}
		else {
			
			// Fail if invalid password list contains errors.
			assertTrue("Invalid password list contains errors!", false);
		}
	}
	
}