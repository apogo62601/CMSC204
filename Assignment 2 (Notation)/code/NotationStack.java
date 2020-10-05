
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {
	
	private Object[] element;
	private int numElement;
	private int cap;
	private int first;
	private int last;
	
	
	public NotationStack() {
		this.cap = 20;
		this.element = new Object[cap];
	}
  

	public NotationStack(int cap) {
		this.cap = cap;
		this.first = this.last = -1;
		this.numElement = 0;
		element = new Object[cap];
	}


  @Override
    public boolean isEmpty() {
	    return numElement == 0;
  }


  @Override
    public boolean isFull() {
	    return cap == numElement;
  }


  @Override
    public T pop() throws StackUnderflowException {
	    if (isEmpty()) {
		    throw new StackUnderflowException();
		    
	    }
	    
    @SuppressWarnings("unchecked")
    T firstInTop = (T) element[last];
    if (firstInTop == null)
    	return null;
    element[last] = null;
    last--;
    numElement--;
    return firstInTop;
    }


  @Override
  	public T top() throws StackUnderflowException {
	    if (isEmpty()) {
		    throw new StackUnderflowException();
	    }
    @SuppressWarnings("unchecked")
      T firstInTop = (T) element[last];
      return firstInTop;
    }


  @Override
    public int size() {
	    return numElement;
    }


  @Override
    public boolean push(T e) throws StackOverflowException {
	  
	  if (isFull()) {
		    throw new StackOverflowException(); 
	    }
	  
  	  if (isEmpty()) {
		  first = last = 0;
		  
	  } else {
		  last++;
		  
	  }
	  numElement++;
	  element[last] = e;
	  return true;
	  
  }


  @Override
  public String toString() {
	  	StringBuilder sb = new StringBuilder();

	  	for (int i = first; i <= last; i++) {
	  		sb.append(element[i]);
	  		
	  	}
	  	return sb.toString();
  }
 

  @Override
    public String toString(String delimiter) {
	  StringBuilder sb = new StringBuilder();

    for (int i = first; i < last; i++) {
      sb.append(element[i] + delimiter);
    }
    sb.append(element[last]);
    return sb.toString();
  }


  @Override
    public void fill(ArrayList<T> list) {
	  ArrayList<T> cloneList = new ArrayList<>(list);
	  cloneList.forEach(t -> {
		  try {
			  push(t);
		  }
		  catch (StackOverflowException ex) {
			  ex.getMessage();  
		  }
		  
	  });
	  
  }
  
}