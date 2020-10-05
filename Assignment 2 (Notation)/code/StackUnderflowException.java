
public class StackUnderflowException extends RuntimeException {

	/**
	 * 
	 */

	private static final long serialVersionUID = -6692733135467470072L;

	public StackUnderflowException() {
		
		super("Pop or top method has been called on an empty stack");
	}

}