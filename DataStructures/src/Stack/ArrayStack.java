package Stack;

import java.util.EmptyStackException;

import Utilities.ChangeArrayLength;

public class ArrayStack implements Stack {
	// data members
	int top; // current top of stack
	Object[] stack; // element array

	// constructors
	public ArrayStack(int initialCapacity) {

		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");
		stack = new Object[initialCapacity];
		top = -1;
	}

	public ArrayStack() {
		this(10);
	}

	// methods
	public boolean empty() {
		return top == -1;
	}

	public Object peek() {
		if (empty())
			throw new EmptyStackException();
		return stack[top];
	}

	public void push(Object theElement) {
		// increase array size if necessary
		if (top == stack.length - 1)
			stack = ChangeArrayLength.changeLength1D(stack, 2 * stack.length);

		// put theElement at the top of the stack
		stack[++top] = theElement;
	}

	public Object pop() {
		if (empty())
			throw new EmptyStackException();
		Object topElement = stack[top];
		stack[top--] = null; // enable garbage collection
		return topElement;
	}

}