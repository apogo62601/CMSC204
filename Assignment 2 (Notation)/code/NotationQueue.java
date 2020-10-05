
import java.util.ArrayList;
import java.util.Objects;

public class NotationQueue<T> implements QueueInterface<T> {

  private Object[] element;
  private int numElement;
  private int cap;
  private int first;
  private int last;
  

  /**
   * Creates a NotationQueue with fixed cap
   *
   */
  public NotationQueue() {
    cap = 20;
    element = new Object[cap];

  }

  /**
   * Creates a NotationQueue with the given (fixed)
   * cap.
   *
   * @param cap the cap of this queue
   */
  public NotationQueue(int cap) {
    this.cap = cap;
    this.first = this.last = -1;
    this.numElement = 0;
    element = new Object[cap];
  }

  /**
   * Determines if Queue is empty
   * @return true if Queue is empty, false if not
   */
  @Override
  public boolean isEmpty() {
    return numElement == 0;
  }

  /**
   * Determines if Queue is full
   * @return true if Queue is full, false if not
   */
  @Override
  public boolean isFull() {
    return cap == numElement;
  }

  /**
   * Deletes and returns the element at the front of the Queue
   * @return the element at the front of the Queue
   */
  @Override
  public T dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException();
    }
    @SuppressWarnings("unchecked")
    T firstInLine = (T) element[first];
    if (firstInLine == null)
      return null;
    element[first] = null;
    first++;
    numElement--;
    return firstInLine;
  }

  /**
   * Number of element in the Queue
   * @return the number of element in the Queue
   */
  @Override
  public int size() {
    return numElement;
  }

  /**
   * Adds an element to the end of the Queue
   * @param e the element to add to the end of the Queue
   * @return true if the add was successful, false if not
   */
  @Override
  public boolean enqueue(T e) throws QueueOverflowException {
    if (isFull()) {
      throw new QueueOverflowException();
    }
    
    if(isEmpty()) {
      first = last = 0;
    } else {
      last++;
    }
    numElement++;
    element[last] = e;
    return true;
  }

  /**
   * Returns the string representation of the element in the Queue, 
   * the beginning of the string is the front of the queue
   * @return string representation of the Queue with element
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
   
    for (int i = first; i <= last; i++) {
      sb.append(element[i]);
    }
    return sb.toString();
  }

  /**
   * Returns the string representation of the element in the Queue, 
   * the beginning of the string is the front of the queue
   * Place the delimiter between all element of the Queue
   * @param delimiter - string used to separate queue element
   * @return string representation of the Queue with element separated with the delimiter
   */
  @Override
  public String toString(String delimiter) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = first; i < last; i++) {
      sb.append(element[i] + delimiter);
    }
    sb.append(element[last]);
    return sb.toString();
  }

  /**
   * Fills the Queue with the element of the ArrayList, First element in the ArrayList
   * is the first element in the Queue
   * @param list element to be added to the Queue
   */
  @Override
  public void fill(ArrayList<T> list) {
    ArrayList<T> cloneList = new ArrayList<>(list);
    cloneList.forEach(t -> {
      try {
        enqueue(t);
      } catch (QueueOverflowException ex) {
        ex.getMessage();
      }
    });
  }

}