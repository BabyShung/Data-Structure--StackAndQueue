package applications;

/**
 * Question:
 * implement a stack that whenever the capacity is out, it creates another stack
 * to keep on pushing or popping data.
 * 
 * use arraylist will be helpful
 * 
 */

import interfaces.Stack;

import java.util.ArrayList;

import Stack.ArrayStack;
import Stack.EmptyStackException;

public class SetOfStacks<T> implements Stack<T> {

	protected int capacity;
	protected ArrayList<Stack<T>> al;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;

		al = new ArrayList<Stack<T>>();
		Stack<T> member = new ArrayStack<T>(capacity);
		al.add(member);
	}

	@Override
	public void push(T element) {

		if (getCurrentStack().size() == capacity) {
			// create new stack and add to al
			Stack<T> newStack = new ArrayStack<T>(capacity);
			al.add(newStack);
		}
		getCurrentStack().push(element);
	}

	private Stack<T> getCurrentStack() {

		return al.get(al.size() - 1);
	}

	@Override
	public T pop() throws EmptyStackException {
		if (getCurrentStack().isEmpty()) {
			// delete this stack and move to previous stack
			al.remove(al.size() - 1);
		}
		return getCurrentStack().pop();
	}

	@Override
	public int size() {
		int size = 0;
		for (Stack<T> tmp : al) {
			size += tmp.size();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {

		return size() == 0;
	}

	@Override
	public T top() throws EmptyStackException {
		if (getCurrentStack().isEmpty()) {
			// delete this stack and move to previous stack
			al.remove(al.size() - 1);
		}
		return getCurrentStack().top();
	}

}
