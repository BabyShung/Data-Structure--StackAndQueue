package applications;

import interfaces.Stack;
import Exceptions.EmptyStackException;
import Exceptions.StackFullException;
import Stack.ArrayStack;

public class MinArrayStack extends ArrayStack<Integer> {

	private Stack<Integer> stackMin;
	private int[] elements;
	
	
	public MinArrayStack(int capacity) {
		super();
		elements = new int[capacity];
		stackMin = new ArrayStack<Integer>(capacity);
	}

	// new defined
	public Integer getMin() {
		if (stackMin.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			try {
				return stackMin.top();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			return null;
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
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("MinStack: (bottom) - ");
		for(int i = 0;i<size;i++){
			sb.append(elements[i]).append(" - ");
		}
		sb.append("(top)");
		return sb.toString();
	}
	
}