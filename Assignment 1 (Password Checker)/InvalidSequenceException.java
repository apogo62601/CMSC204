
/**
 * Thrown when password contains more than 2 of the same characters in a row.
 */

public class InvalidSequenceException extends Exception{
	public InvalidSequenceException() {
		
		super("The password cannot contain more than two of the same character in sequence. Please try again.");
	}

}
