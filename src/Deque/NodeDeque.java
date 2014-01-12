package Deque;

import interfaces.Deque;
import DoublyLinkedList.DoublyLinkedListNode;

public class NodeDeque<T> implements Deque<T> {
	protected DoublyLinkedListNode<T> head, tail;
	protected int size;

	public NodeDeque() {
		head = new DoublyLinkedListNode<T>();
		tail = new DoublyLinkedListNode<T>();
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}

	public T getFirst() throws EmptyDequeException {
		if (this.isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		}
		return head.getNext().getElement();
	}

	public T getLast() throws EmptyDequeException {
		if (this.isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		}
		return tail.getPrev().getElement();
	}

	public void addFirst(T elem) {
		DoublyLinkedListNode<T> oldFirst = head.getNext();
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(elem,
				head, oldFirst);
		oldFirst.setPrev(newNode);
		head.setNext(newNode);
		size++;
	}

	public void addLast(T elem) {
		DoublyLinkedListNode<T> oldLast = tail.getPrev();
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(elem,
				oldLast, tail);
		tail.setPrev(newNode);
		oldLast.setNext(newNode);
		size++;
	}

	public T removeFirst() throws EmptyDequeException {
		if (this.isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		}
		DoublyLinkedListNode<T> oldFirst = head.getNext();
		T elem = oldFirst.getElement();
		DoublyLinkedListNode<T> newFirst = oldFirst.getNext();
		newFirst.setPrev(head);
		head.setNext(newFirst);
		size--;
		return elem;
	}

	public T removeLast() throws EmptyDequeException {
		if (this.isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		}
		DoublyLinkedListNode<T> oldLast = tail.getPrev();
		T elem = oldLast.getElement();
		DoublyLinkedListNode<T> newLast = oldLast.getPrev();
		tail.setPrev(newLast);
		newLast.setNext(tail);
		size--;
		return elem;
	}

	@Override
	public String toString() {

		DoublyLinkedListNode<T> cursor = head.getNext();
		String listString = "Front -> ";

		while (cursor != tail) {

			listString += cursor.toString() + " -> ";
			cursor = cursor.getNext();
		}

		return listString + "Rear";
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
