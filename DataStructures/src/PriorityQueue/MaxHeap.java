package PriorityQueue;

import Utilities.ChangeArrayLength;

public class MaxHeap implements MaxPriorityQueue {

	// data members
	Comparable[] heap; // array for complete binary tree
	// number of elements in heap
	int size;

	/**
	 * create a heap with the given initial capacity
	 * 
	 * @throws IllegalArgumentException
	 *             when initialCapacity < 1
	 */
	public MaxHeap(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException("initialCapacity must be >= 1");
		}
		heap = new Comparable[initialCapacity + 1];
		size = 0;
	}

	/**
	 * create a heap with initial capacity 10
	 */
	public MaxHeap() {
		this(10);
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public Comparable getMax() {

		return heap[1];
	}

	public int size() {

		return size;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("[");
		// put elements into the buffer
		for (int i = 1; i <= size; i++)
			if (heap[i] == null)
				s.append("null, ");
			else
				s.append(heap[i].toString() + ", ");

		if (size > 0)
			s.delete(s.length() - 2, s.length());

		s.append("]");
		// create equivalent String
		return new String(s);
	}

	/**
	 * put theElement into the heap
	 */
	public void put(Comparable theElement) {
		// increase array size if necessary
		if (size == heap.length - 1) {
			heap = (Comparable[]) ChangeArrayLength.changeLength1D(heap,
					2 * heap.length);
		}
		// find place for theElement
		// currentNode starts at new leaf and moves up tree
		int currentNode = ++size;
		while (currentNode != 1
				&& heap[currentNode / 2].compareTo(theElement) < 0) {
			// cannot put theElement in heap[currentNode]
			heap[currentNode] = heap[currentNode / 2];
			currentNode /= 2; // move to parent
		}
		heap[currentNode] = theElement;
	}

	/**
	 * remove max element and return it
	 */
	public Comparable removeMax() {
		if (size == 0) {
			return null;
		}
		Comparable maxElement = heap[1];
		Comparable lastElement = heap[size--];
		// find place for lastElement starting at root
		int currentNode = 1,
		// child of currentNode
		child = 2;
		while (child <= size) {
			// heap[child] should be larger child of currentNode
			if (child < size && heap[child].compareTo(heap[child + 1]) < 0) {
				child++;
			}
			// can we put lastElement in heap[currentNode]?
			if (lastElement.compareTo(heap[child]) >= 0) {
				break; // yes
			}// no
			heap[currentNode] = heap[child]; // move child up
			currentNode = child;
			// move down a level
			child *= 2;
		}
		heap[currentNode] = lastElement;
		return maxElement;
	}

	/**
	 * initialize max heap to element array theHeap
	 */
	public void initialize(Comparable[] theHeap, int theSize) {
		heap = theHeap;
		size = theSize;
		for (int root = size / 2; root >= 1; root--) {
			Comparable rootElement = heap[root];
			// find place to put rootElement
			int child = 2 * root; // parent of child is target
			// location for rootElement
			while (child <= size) {
				// heap[child] should be larger sibling
				if (child < size && heap[child].compareTo(heap[child + 1]) < 0) {
					child++;
				}
				// can we put rootElement in heap[child/2]?
				if (rootElement.compareTo(heap[child]) >= 0) {
					break; // yes
				}// no
				heap[child / 2] = heap[child]; // move child up
				child *= 2; // move down a level
			}
			heap[child / 2] = rootElement;
		}
	}

}