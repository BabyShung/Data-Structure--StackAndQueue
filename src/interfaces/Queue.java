package interfaces;

import Queue.EmptyQueueException;

public interface Queue<T>
{
    // Add the element to the queue
    void enqueue( T element );
    
    // Remove and return the 'first' element in the queue (oldest element).
    // Throw an EmptyQueueException if the queue is empty.
    T dequeue( ) throws EmptyQueueException;
    
    // Return the number of elements in the queue
    int size( );
    
    // Return 'true' exactly when there are no elements in the queue
    boolean isEmpty( );
    
    // Return (but do not remove) the first element in the queue.  Throw an
    // exception if the queue is empty.
    T front( ) throws EmptyQueueException;
}
