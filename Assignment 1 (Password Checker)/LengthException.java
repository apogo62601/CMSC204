
/**
 * Thrown when password contains less than 6 characters long.
 */

public class LengthException extends Exception{
	public LengthException() {
		
		super("Password much be greater than six characters long. Please try again.");
	}

}
