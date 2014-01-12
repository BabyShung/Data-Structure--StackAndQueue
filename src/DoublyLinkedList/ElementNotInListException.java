package DoublyLinkedList;

public class ElementNotInListException extends Exception {

	public ElementNotInListException(String msg) {
		super(msg);
	}

	// I'll include this, since some students have in their code.
	public ElementNotInListException() {
	}

}