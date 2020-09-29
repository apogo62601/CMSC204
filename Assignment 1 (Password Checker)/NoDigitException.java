
/**
 * Thrown when password contains no digits.
 */

public class NoDigitException extends Exception {
	public NoDigitException() {
		
		super("Password must contain at least one digit. Please try again.");
	}

}
