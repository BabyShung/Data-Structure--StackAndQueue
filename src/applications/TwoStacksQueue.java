package applications;

import interfaces.Queue;
import interfaces.Stack;
import Queue.EmptyQueueException;
import Stack.ArrayStack;
import Stack.EmptyStackException;

/**
 * Question: use two stacks to perform the methods of a queue
 * @author haozheng
 *
 * @param <T>
 */

public class TwoStacksQueue<T> implements Queue<T> {

	private Stack<T> inputStack;
	private Stack<T> outputStack;

	public TwoStacksQueue(int capacity) {

		int half;
		if (capacity % 2 == 0) {
			half = capacity / 2;
		} else {
			half = capacity / 2 + 1;
		}

		inputStack = new ArrayStack<T>(half);
		outputStack = new ArrayStack<T>(half);
	}

	@Override
	public void enqueue(T element) {
		inputStack.push(element);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		stackShift();
		try {
			return outputStack.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int size() {
		return inputStack.size() + outputStack.size();
	}

	@Override
	public boolean isEmpty() {
		return inputStack.size() == 0 && outputStack.size() == 0;
	}

	@Override
	public T front() throws EmptyQueueException {
		stackShift();
		try {
			return outputStack.top();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void stackShift() {
		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				try {
					outputStack.push(inputStack.pop());
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
