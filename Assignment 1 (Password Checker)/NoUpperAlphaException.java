
/**
 * Thrown when password contains no uppercase alphabetic characters.
 */

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		
		super("Password must contain at least one uppercase alphabetic character. Please try again.");
	}

}
