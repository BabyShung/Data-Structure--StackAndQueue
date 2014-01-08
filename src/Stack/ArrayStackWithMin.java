package Stack;

import interfaces.Stack;
import Exceptions.EmptyStackException;
import Exceptions.StackFullException;

public class ArrayStackWithMin implements Stack<Integer> {

	private int size; // default 0
	private int[] elements;
	private Stack<Integer> stackMin;

	public ArrayStackWithMin(int capacity) {
		elements = new int[capacity];

		// this stack keeps track of Mins
		stackMin = new ArrayStack<Integer>(capacity);
	}

	public Integer getMin() {
		if (stackMin.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			try {
				return stackMin.top();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			return -1;
		}
	}

	@Override
	public void push(Integer element) {
		if (size < elements.length) {

			if (element < getMin()) {
				stackMin.push(element);
			}

			elements[size] = element;
			size++;

		} else {

			throw new StackFullException("Your stack is full.");

		}
	}

	@Override
	public Integer pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot pop from empty stack!");
		}
		size--;

		if (elements[size] == getMin()) {
			stackMin.pop();
		}

		return elements[size];
	}

	// 'Peeks' at the top element of the stack. Throws an EmptyStackException
	// if the stack is empty.
	@Override
	public Integer top() throws EmptyStackException {
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: (bottom) - ");
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]).append(" - ");
		}
		sb.append("(top)");
		return sb.toString();
	}
}