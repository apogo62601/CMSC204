
public class QueueUnderflowException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4128603798523826231L;

	public QueueUnderflowException() {
		
		super("Dequeue method has been called on an empty queue");
		
	}

}