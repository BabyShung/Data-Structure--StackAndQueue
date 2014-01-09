package Stack;

import interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {

	protected int size; // default 0
	protected T[] elements;

	// Create an ArrayStack with the given capacity. Notice the casting we
	// do - Java does not allow you to create new arrays of a generic type.
	public ArrayStack(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	public ArrayStack(){
		
	}
	
	@Override
	public void push(T element) {
		// Make sure the element will fit in our array before we 'push' it
		if (size < elements.length) {
			elements[size] = element;
			size++;
		} else {

			throw new StackFullException("Your stack is full.");
			
		}
	}

	@Override
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot pop from empty stack!");
		}
		size--;
		return elements[size];
	}

	// 'Peeks' at the top element of the stack. Throws an EmptyStackException
	// if the stack is empty.
	@Override
	public T top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot view top of empty stack!");
		}
		return elements[size - 1];
	}

	// Returns the size of the stack
	@Override
	public int size() {
		return size;
	}

	// Tells us if the stack is empty or not
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: (bottom) - ");
		for(int i = 0;i<size;i++){
			sb.append(elements[i]).append(" - ");
		}
		sb.append("(top)");
		return sb.toString();
	}
}