package Queue;

import interfaces.Queue;

public class ArrayQueue<T> implements Queue<T> {
	// We'll store the queue in an array. Besides the array, we'll keep track
	// of the index of the first element, and how many elements are in the
	// queue.
	private T[] queue;
	private int front;
	private int size;

	// Create a queue object which can hold at most 'capacity' elements.
	// Note the array cast to get around the generic limitations in Java.
	public ArrayQueue(int capacity) {
		queue = (T[]) new Object[capacity];
	}

	// Add the given element to the queue. Note we throw a RuntimeException
	// subclass, which doesn't need to be thrown explicitly but will still
	// cause the programmer to know of the problem.
	@Override
	public void enqueue(T element) {
		if (size == queue.length) {
			throw new QueueFullException("The queue is at maximum capacity.");
		}

		// Add the element to the next 'open' spot in the array
		queue[(front + size) % queue.length] = element;
		size++;
	}

	// Return the first element from the queue, or throw an exception if the
	// queue is empty.
	@Override
	public T dequeue() throws EmptyQueueException {
		if (size == 0) {
			throw new EmptyQueueException("Queue is empty, cannot dequeue!");
		}

		// Remove the element from the queue and change the 'front' index.
		T element = queue[front];
		front = (front + 1) % queue.length;
		size--;
		return element;
	}
 
	@Override
	public T front() throws EmptyQueueException {
		if (size == 0) {
			throw new EmptyQueueException(
					"Queue empty, cannot get first element.");
		}
		return queue[front];
	}
 
	@Override
	public int size() {
		return size;
	}
 
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
