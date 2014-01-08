package Exceptions;

public class StackFullException extends RuntimeException {
	public StackFullException(String msg) {
		super(msg);
	}
}