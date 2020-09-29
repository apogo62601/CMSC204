
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tests for valid passwords.
 * @author Aelina Pogosian
 */
public class PasswordCheckerUtility {

	/**
	 * Method for checking passwords for validity. Throws exceptions according to the error found.
	 * @param password String containing password to be checked.
	 * @return True if all criteria are met.
	 * @throws LengthException Password is under 6 characters.
	 * @throws NoUpperAlphaException Password does not contain an uppercase letter.
	 * @throws NoLowerAlphaException Password does not contain a lowercase letter.
	 * @throws NoDigitException Password does not contain a number.
	 * @throws NoSpecialSymbolException Password does not contain a symbol.
	 * @throws InvalidSequenceException Password contains more than 3 of the same characters.
	 */
	static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		// Create Pattern and Matcher objects to search for special characters.
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		// Check for password length.
		if (password.length() <= 6) {
			
			throw new LengthException();
		}
		
		// Check for uppercase letters in sequence.
		for (int counter = 0; counter < password.length(); counter++) {
			
			if (Character.isUpperCase(password.charAt(counter)) ) {
				
				break;
			}
			else if (counter == password.length() - 1) {
				
				throw new NoUpperAlphaException();
			}
		}
		
		// Check for lowercase letters in sequence.
		for (int counter = 0; counter < password.length(); counter++) {
			
			if (Character.isLowerCase(password.charAt(counter))) {
			
				break;
			}
			else if (counter == password.length() - 1) {
				
				throw new NoLowerAlphaException();
			}
		}
		
		// Check for numbers in sequence.
		for (int counter = 0; counter < password.length(); counter++) {
			
			if (Character.isDigit(password.charAt(counter))) {
				
				break;
			}
			else if (counter == password.length() - 1) {
				
				throw new NoDigitException();
			}
		}
		
		// Check for special characters in sequence.
		if (matcher.matches()) {
			
			throw new NoSpecialCharacterException();
		}
		
		// Check for duplicate characters in sequence.
		for (int counter = 0, duplicateCount = 0; counter < password.length() - 1; counter++) {
			
			if (password.charAt(counter) == password.charAt(counter + 1)) {
				
				duplicateCount++;
			}
			else {
				duplicateCount = 0;
			}
			
			if (duplicateCount > 1) {
				
				throw new InvalidSequenceException();
			}
		}
		
		// Return true is all criteria are met.
		return true;
	}

	/**
	 * Method for checking if password is under 10 characters.
	 * @param password String containing password to be checked.
	 * @return False if password is over 10 characters long.
	 * @throws WeakPasswordException Password is under 10 characters.
	 */
	static boolean isWeakPassword(String password) throws WeakPasswordException {
		
		// Check password length.
		if (password.length() > 6 && password.length() < 10) {
			
			return true;
		}
		
		// Return false if password is under 10 character.
		return false;
	}
	
	/**
	 * Method for compiling invalid passwords from a list.
	 * @param passwords ArrayList contain passwords to be checked.
	 * @return ArrayList containing invalid passwords.
	 */
	static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for (int counter = 0; counter < passwords.size(); counter++) {
				
			try {
					
				// Check for Invalid passwords.
				isValidPassword(passwords.get(counter));
			}
				
			catch (Exception ex) {
					
				// Add Invalid passwords to ArrayList.
				invalidPasswords.add(passwords.get(counter));
			}
		}
			
		// Return ArrayList of invalid passwords.
		return invalidPasswords;
	}
}
