package Stack;

import java.util.EmptyStackException;

public class LinkedStack implements Stack {

	// data members
	protected ChainNode topNode;

	public LinkedStack(int initialCapacity) {
	}

	public LinkedStack() {
		this(0); 
	}
	
	public boolean empty() {
   		return topNode == null;
	}

	public Object peek() {
		if (empty())
   			throw new EmptyStackException();
		return topNode.element;
	}
	
	public void push(Object theElement) {
   		topNode = new ChainNode(theElement, topNode);
	}
	
	public Object pop() {
		if (empty())
   			throw new EmptyStackException();
		Object topElement = topNode.element;
		topNode = topNode.next;
		return topElement;
	}
	  
}