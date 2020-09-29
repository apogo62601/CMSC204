
/**
 * Thrown when password contains no lowercase alphabetic characters.
 */

public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		
		super("Password must contain at least one lowercase alphabetic character. Please try again.");
	}

}
