import Queue.EmptyQueueException;
import Stack.EmptyStackException;
import applications.MinArrayStack;
import applications.SetOfStacks;
import applications.TwoStacksQueue;

public class Test {

	public static void main(String[] args) throws EmptyQueueException,
			EmptyStackException {

		// MinArrayStack stackMin = new MinArrayStack(10);
		//
		// stackMin.push( 4 );
		// stackMin.push( 2 );
		// stackMin.push( 3 );
		// stackMin.push( 1 );
		// stackMin.push( 8 );
		//
		// System.out.println(stackMin);
		// System.out.println("min: " + stackMin.getMin());
		//
		//
		// TwoStacksQueue<Object> tsq = new TwoStacksQueue<Object>(10);
		// tsq.enqueue(2);
		// tsq.enqueue(4);
		// tsq.enqueue(3);
		// tsq.enqueue(2);
		// tsq.enqueue(1);
		//
		// while(!tsq.isEmpty()){
		// System.out.println(tsq.front());
		// System.out.println(tsq.dequeue());
		// }

		SetOfStacks<Object> sos = new SetOfStacks<Object>(3);
		sos.push(2);
		sos.push(4);
		sos.push(3);
		sos.push(2);
		sos.push(1);
		sos.push(2);
		sos.push(1);
		sos.push(2);
		sos.push(1);
		System.out.println("size: " + sos.size());
		while (!sos.isEmpty()) {
			System.out.println(sos.pop());
		}
		System.out.println("size: " + sos.size());

	}

}
