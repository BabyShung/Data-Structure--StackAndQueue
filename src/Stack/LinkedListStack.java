package Stack;

import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.ElementNotInListException;
import interfaces.Stack;

public class LinkedListStack<T> implements Stack<T> {

	private DoublyLinkedList<T> list;

	// initialize the linked list being used.
	public LinkedListStack() {
		list = new DoublyLinkedList<T>();
	}

	// 'pushing' an element onto our stack is equivalent to simply adding
	// that element to the front of our linked list.
	// Note that, unlike our array implementation, we don't have to worry about
	// throwing exceptions for stacks reaching their capacity.
	@Override
	public void push(T elem) {
		list.addToFront(elem);
	}

	// To pop an element, remove the first element in the linked list, and then
	// delete it.
	@Override
	public T pop() throws EmptyStackException {
		// Check if the list is empty. If it is, the stack is empty, so
		// we'll throw an exception.
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty, cannot pop!");
		}
		// Get the first element from the stack *and* delete it. Note we
		// use a try-catch block and do nothing - we don't actually expect an
		// exception to be thrown here.
		T element = list.getFirstElement();
		try {
			list.deleteElement(element);
		} catch (ElementNotInListException e) {
		}
		return element;
	}

	// The top element on the stack is at the front of our linked list. If
	// the list is empty, throw an exception
	@Override
	public T top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty, cannot get top!");
		}
		return list.getFirstElement();
	}

	// Simply check to see if the size is 0 -- the list must be empty then.
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	// Return the number of elements in our linked list.
	@Override
	public int size() {
		return list.getSize();
	}
}