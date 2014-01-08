package interfaces;

import Exceptions.EmptyStackException;

public interface Stack<T>
{
    // Pushes the given element onto the stack
    void push( T element );
    
    // Removes and returns the top element from the stack.  If there are no
    // elements, an EmptyStackException is thrown
    T pop( ) throws EmptyStackException;
    
    // Returns the number of elements in the stack
    int size( );
    
    // Returns Boolean value 'true' when the stack is empty; false otherwise
    boolean isEmpty( );
    
    // Returns the top element from the stack *without removing it* ('peeks'
    // at the element).  If there are no elements, an EmptyStackException is
    // thrown
    T top( ) throws EmptyStackException;
}
