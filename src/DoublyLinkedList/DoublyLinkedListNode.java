package DoublyLinkedList;

public class DoublyLinkedListNode<T> {
	// Instance variables for the element and next/prev references
	private T element;
	private DoublyLinkedListNode<T> next;
	private DoublyLinkedListNode<T> prev;

	public DoublyLinkedListNode(){
		this(null,null,null);
	}
	
	
	// Creates a new doubly-linked list node with element elem, next pointer
	// set to nxt, and previous pointer set to prv.
	public DoublyLinkedListNode(T elem, DoublyLinkedListNode<T> prv,
			DoublyLinkedListNode<T> nxt) {
		element = elem;
		next = nxt;
		prev = prv;
	}

	// Accessor methods for next, prev, and element
	public T getElement() {
		return element;
	}

	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	public DoublyLinkedListNode<T> getPrev() {
		return prev;
	}

	// Mutator methods for the next/prev pointers, as well as the element
	public void setElement(T elem) {
		element = elem;
	}

	public void setNext(DoublyLinkedListNode<T> nxt) {
		next = nxt;
	}

	public void setPrev(DoublyLinkedListNode<T> prv) {
		prev = prv;
	}

	// A simple toString method
	@Override
	public String toString() {
		return "Element: " + element;
	}
}
