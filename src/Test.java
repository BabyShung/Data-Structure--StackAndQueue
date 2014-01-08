import interfaces.Stack;
import Stack.ArrayStack;
import Stack.ArrayStackWithMin;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 Stack<Integer> myStack = new ArrayStack<Integer>( 10 );
		 
         myStack.push( 1 );
         myStack.push( 2 );
         myStack.push( 3 );
         System.out.println(myStack);
         
         ArrayStackWithMin stackMin = new ArrayStackWithMin(10);
         
         stackMin.push( 4 );
         stackMin.push( 2 );
         stackMin.push( 3 );
         stackMin.push( 1 );
         stackMin.push( 8 );
         stackMin.push( 0 );
         
         System.out.println(stackMin);
         System.out.println("min: " + stackMin.getMin());
	}

}
