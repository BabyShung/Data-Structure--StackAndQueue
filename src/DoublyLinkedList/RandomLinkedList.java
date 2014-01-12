package DoublyLinkedList;

import java.util.Random;

public class RandomLinkedList<T> extends DoublyLinkedList<T> {
	// While you don't have to, I will keep the random number generator as
	// an instance variable, created once when the list is created.
	private Random randomGenerator;

	// The empty-parameter constructor simply creates an empty linked list and
	// initializes our random number generator
	public RandomLinkedList() {
		super();
		randomGenerator = new Random();
	}

	// The single-parameter constructor creates a linked list containing only
	// one non-sentinel node, which holds elem. It also initializes our
	// random number generator.
	public RandomLinkedList(T elem) {
		super(elem);
		randomGenerator = new Random();
	}

	// Insert elem into a random position in the linked list
	public void insertRandom(T elem) {
		// Set the cursor to the first non-head node in the list
		DoublyLinkedListNode<T> cursor = getNode(randomGenerator
				.nextInt(getSize() + 1));
		// Create a new node and insert it between cursor and cursor's previous
		// reference. We have to be careful that we 'get' the previous
		// reference before using 'set', or we "lose" the reference.
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(elem,
				cursor.getPrev(), cursor);
		cursor.getPrev().setNext(newNode);
		cursor.setPrev(newNode);
		// Add one to the size of the list.
		addToSize(1);
	}

	// Returns a random element from the linked list
	public T getRandom() {
		return (getNode(randomGenerator.nextInt(getSize()))).getElement();
	}

	// Returns a String representation of a "shuffling" of the elements: at
	// every step, either the first or last unprinted element is equally likely
	// to be added to the String.
	public String randomOrderToString() {
		DoublyLinkedListNode<T> front = getHead();
		DoublyLinkedListNode<T> back = getTail();
		String listString = new String();
		// We are going to keep adding elements to our String until our front
		// and back cursors meet (meaning all but one element has been added
		// to the string).
		while (front != back) {
			// We'll generate randomly a boolean, and use it to determine
			// whether to add from the front or the back. Once adding the
			// element to the String, we'll move the correct 'cursor' to the
			// next/prev node.
			if (randomGenerator.nextBoolean()) {
				listString += front.toString() + " -> ";
				front = front.getNext();
			} else {
				listString += back.toString() + " -> ";
				back = back.getPrev();
			}
		}
		// We haven't printed the final element from the list yet, so we
		// append its String representation to listString and return it
		return listString + front.toString();
	}

	// A helper method which returns a reference to the node at position 'pos'
	// (assume 0 is the first non-head node).
	private DoublyLinkedListNode<T> getNode(int pos) {
		DoublyLinkedListNode<T> cursor = getHead().getNext();
		// 'jump over' 'pos' nodes
		for (int i = 0; i < pos && cursor != getTail(); i++) {
			cursor = cursor.getNext();
		}
		// return the node pointed to (either the node at 'pos' or the tail,
		// depending upon the given 'pos').
		return cursor;
	}
}