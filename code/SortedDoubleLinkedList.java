import java.util.Comparator;
import java.util.ListIterator;

import BasicDoubleLinkedList.Node;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList <T>{

	Comparator <T> comparator1;
	
	SortedDoubleLinkedList(java.util.Comparator<T> comparator2){
		
		super();
		comparator1 = comparator2;
	}
	
	public void add(T data){
		
		if (head == null && tail == null) {
			
			super.addToFront(data);
		}
		else if (comparator1.compare(data, head.data) <= 0) {
			
			super.addToFront(data);
		}
		else if (comparator1.compare(data, head.data) > 0) {
			
			Node<T> compare = head;
			Node<T> compareFollow = head;
			
			do {
				
				if (compare.next == null) {
					
					super.addToEnd(data);
					break;
				}
				
				if (compareFollow == compare) {
					
					compare = compare.next;
				}
				
				else {
					
					compare = compare.next;
					compareFollow = compareFollow.next;
				}
				
				if (comparator1.compare(data, compare.data) <= 0) {
					
					Node<T> newNode = new Node<T>(data);
					newNode.next = compare;
					compareFollow.next = newNode;
					listSize ++;
					break;
				}
			}
			
			while (comparator1.compare(data, compare.data) != 0 || !(comparator1.compare(data,  compare.data) < 0 ));
			}
			
		}
	
	public void addToEnd(T data) throws UnsupportedOperationException{
	
		throw new UnsupportedOperationException();		
	}
	
	public void addToFront(T data) throws UnsupportedOperationException{
		
		throw new UnsupportedOperationException();
	}
	
	public ListIterator<T> iterator(){
		
		return super.iterator();
	}
	
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		
		
		return null;
	}
	
	
}
