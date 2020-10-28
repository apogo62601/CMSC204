import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList <T> implements Iterable <T>{

	Node<T> head, tail;
	int listSize;
	
	BasicDoubleLinkedList(){
		head = null;
		tail = null;
		listSize = 0;
	}
	
	public int getSize() {
		
		return listSize;
	}
	
	public void addToEnd(T data){
		
		if (head == null && tail == null) {
			
			tail = new Node<T> (data);
			head = tail;
			listSize += 1;
		}
		else {
			
			tail.next = new Node<T>(data);
			tail = tail.next;
			listSize += 1;
		}
	}
	
	public void addToFront(T data){
		
		if (head == null && tail == null) {
			
			head = new Node<T> (data);
			tail = head;
		}
		else {
			Node <T> newNode = new Node <T> (data);
			newNode.next = head;
			head = newNode; 
			
		}
		listSize += 1;
	}

	public T getFirst() {
		
		return head.data;
	}
	
	public T getLast() {
		
		return tail.data;
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
           
		class Iterator implements ListIterator<T> {
			Node <T> iteration = null;
			Node <T> iterationFollow = head;
			
			@Override
			public void add(Object arg0) {
				throw new UnsupportedOperationException("Invalid operation for basic and sorted list");
			}

			@Override
			public boolean hasNext() {
				if (iteration == null) {
					return (Boolean) null;
				}
					
				if (iteration.next != null ) {
					return true;
				}
				
				else {
					return false;
				}
			}

			@Override
			public boolean hasPrevious() {
				if (iteration != head || iteration != null) {
					return true;
				}
				
				else {
					return false	;
				}
				
			}

			@Override
			public T next() {
				
				if (iteration == null) {
					iteration = head;
					return iteration.data;
				}
				else if (iteration.next == null) {
					throw new NoSuchElementException();
				}
				else {
					iteration = iteration.next;
					return iteration.data;
				}
			}

			@Override
			public int nextIndex() {
				throw new UnsupportedOperationException("Invalid operation for basic and sorted list");
			}

			@Override
			public T previous() {
				
				if (iteration == head) {
					throw new NoSuchElementException();
				}
				
				for (int counter = 1; counter < listSize; counter++) {
					
					if (iterationFollow.next == iteration) {
						
						iteration = iterationFollow;
						break;
					}
					
					iterationFollow = iterationFollow.next;
				}
				
				iterationFollow = head;
				return iteration.data;
			}

			@Override
			public int previousIndex() {
				throw new UnsupportedOperationException("Invalid operation for basic and sorted list");
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Invalid operation for basic and sorted list");
			}

			@Override
			public void set(T e) {
				throw new UnsupportedOperationException("Invalid operation for basic and sorted list");
			}
			
		}
		return new Iterator();
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		
		Node <T> compare = head;
		Node <T> compareFollow = head;
		
		for(int counter = 1; counter <= listSize; counter++) {
			if (counter == 1) {
				if (comparator.compare(targetData, compare.data) == 0) {
					
					head = head.next;
					listSize -= 1;
					break;
				}
				compare = compare.next;
				continue;
			}
		}
		return null;
	}
	

	public T retrieveFirstElement() {
		
		T element = head.data;
		head = head.next;
		listSize--;
		return element;
	}
	
	public T retrieveLastElement() {
		
		T element = tail.data;
		Node <T> newNode;
		newNode = head;
		for (int steps = 1; steps < listSize - 1; steps++) {		
			newNode = newNode.next;
		}
		tail = null;
		tail = newNode;
		listSize--;
		return element;
	}
	
	public ArrayList<T> toArrayList(){
		
		ArrayList<T> arrayList = new ArrayList<T>();
		Node <T> newNode;
		newNode = head;
		for (int steps = 0; steps < listSize; steps++) {	
			arrayList.add(newNode.data);
			if (newNode.next != null)
			newNode = newNode.next;
		}
		return arrayList;

	}
	
	protected class Node<T> {
		
		protected T data;
		protected Node<T> next;
		
		public Node(T element) {
			data = element;
			
		}
		
		
	}
	
}
