
/**
 * Thrown when password contains no special characters.
 */

public class NoSpecialCharacterException extends Exception{
	public NoSpecialCharacterException() {
		
		super("Password must contain at least one special character. Please try again.");
	}

}
