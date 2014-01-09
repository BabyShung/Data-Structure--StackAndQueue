import applications.MinArrayStack;
import interfaces.Stack;
import Stack.ArrayStack;


public class Test {

	public static void main(String[] args) {
		
         MinArrayStack stackMin = new MinArrayStack(10);

         stackMin.push( 4 );
         stackMin.push( 2 );
         stackMin.push( 3 );
         stackMin.push( 1 );
         stackMin.push( 8 );

         System.out.println(stackMin);
         System.out.println("min: " + stackMin.getMin());
	}

}
