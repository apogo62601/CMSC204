
public class QueueOverflowException extends RuntimeException {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 4910243681180546004L;

public QueueOverflowException() {
		
		super("Enqueue method has been called on a full queue");
		
	}

}