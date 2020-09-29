
/**
 * Thrown when password do not match.
 */

public class UnmatchedException extends Exception{
	public UnmatchedException() {
		
		super("The passwords do not match. Please try again.");
	}

}
