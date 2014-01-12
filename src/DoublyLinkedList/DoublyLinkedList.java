package DoublyLinkedList;

public class DoublyLinkedList<T> {

	private DoublyLinkedListNode<T> head = new DoublyLinkedListNode<>(null,
			null, null);
	private DoublyLinkedListNode<T> tail = new DoublyLinkedListNode<>(null,
			null, null);
	private int size = 0;

	public DoublyLinkedList(T elem) {
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(elem,
				head, tail);
		head.setNext(newNode);
		tail.setPrev(newNode);
		size = 1;
	}

	public DoublyLinkedList() {
		head.setNext(tail);
		tail.setPrev(head);
	}

	public void addToFront(T elem) {
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(elem,
				head, head.getNext());
		head.getNext().setPrev(newNode);
		head.setNext(newNode);
		size++;
	}

	public void addToBack(T elem) {
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(elem,
				tail.getPrev(), tail);
		tail.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		size++;
	}

	public T getFirstElement() {
		return head.getNext().getElement();
	}

	public T getLastElement() {
		return tail.getPrev().getElement();
	}

	public void insertBefore(T elem1, T elem2) throws ElementNotInListException {

		DoublyLinkedListNode<T> cursor = findNode(elem2);
		
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(elem1,
				cursor.getPrev(), cursor);
		newNode.getPrev().setNext(newNode);
		newNode.getNext().setPrev(newNode);
		size++;
	}

	public void deleteElement(T elem) throws ElementNotInListException {

		DoublyLinkedListNode<T> nodeToDelete = findNode(elem);

		nodeToDelete.getPrev().setNext(nodeToDelete.getNext());
		nodeToDelete.getNext().setPrev(nodeToDelete.getPrev());
		size--;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		// Set the cursor to the node immediately after the head node, and
		// create the String we will build.
		DoublyLinkedListNode<T> cursor = head.getNext();
		String listString = "HEAD -> ";
		// As long as we haven't reached the tail node, repeat:
		while (cursor != tail) {
			// add the current node to the string, along with the arrow ->
			listString += cursor.toString() + " -> ";
			cursor = cursor.getNext();
		}
		// We have reached the tail, so add 'TAIL' to the end of the String and
		// return it.
		return listString + "TAIL";
	}

	// Accessor methods for subclasses to read the head and tail nodes
	protected DoublyLinkedListNode<T> getHead() {
		return head;
	}

	protected DoublyLinkedListNode<T> getTail() {
		return tail;
	}

	protected void addToSize(int add) {
		size += add;
	}

	private DoublyLinkedListNode<T> findNode(T elem)
			throws ElementNotInListException {
		DoublyLinkedListNode<T> cursor = head.getNext();
		
		while (cursor != tail && !cursor.getElement().equals(elem)) {
			cursor = cursor.getNext();
		}
		
		if (cursor == tail) {
			throw new ElementNotInListException("Element " + elem
					+ " not in list.");
		}
		return cursor;
	}
}
