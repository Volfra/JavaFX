package Dictionary;

public class HashTable implements Dictionary{

	// data members of HashTable
	protected int divisor; // hash function divisor
	protected HashEntry[] table; // hash table array
	protected int size; // number of elements in table

	// constructors
	public HashTable(int theDivisor) {
		divisor = theDivisor;
		// allocate hash table array
		table = new HashEntry[divisor];
	}

	protected static class HashEntry {
		// data members
		protected Object key;
		protected Object element;

		private HashEntry(Object theKey, Object theElement) {
			key = theKey;
			element = theElement;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * search an open addressed hash table for an element with key theKey
	 * 
	 * @return location of matching element if found, otherwise return location
	 *         where an element with key theKey may be inserted provided the
	 *         hash table is not full
	 */
	private int search(Object theKey, int op) {
		int i = Math.abs(theKey.hashCode()) % divisor;
		int j = i; // start at home bucket
		do {
			if (op == 1) { // find bucket insertion
				if (table[j] == null)
					return j;
				else if (table[j].key.equals(theKey))
					return j;
			}
			if (op == 2 && table[j] != null) { // find key get and remove
				if (table[j].key.equals(theKey)) {
					return j;
				}
			}
			j = (j + 1) % divisor; // next bucket
		} while (j != i);
		// returned to home bucket?
		return j; // table full
	}

	public Object remove(Object theKey) {
		int b = search(theKey, 2);
		if (table[b] != null) {
			Object Element = table[b].element;
			// see if a match was found at table[b]
			if (table[b].key.equals(theKey)) {
				table[b] = null;
				size--;
				return Element;
			}
		}
		return null;
	}

	/**
	 * @return element with specified key
	 * @return null if no matching element
	 */
	public Object get(Object theKey) {
		// search the table
		int b = search(theKey, 2);
		// see if a match was found at table[b]
		if (table[b] == null || !table[b].key.equals(theKey)) {
			return null;
		}
		// no match
		return table[b].element; // matching element
	}

	/**
	 * insert an element with the specified key overwrite old element if there
	 * is already an element with the given key
	 * 
	 * @throws IllegalArgumentException
	 *             when full
	 * @return old element (if any) with key theKey
	 */
	public Object put(Object theKey, Object theElement) {
		// search the table for a matching element
		int b = search(theKey, 1);
		// check if matching element found
		if (table[b] == null) {
			table[b] = new HashEntry(theKey, theElement);
			size++;
			return null;
		} else { // check if duplicate or table full
			if (table[b].key.equals(theKey)) { // duplicate, change
												// table[b].element
				Object elementToReturn = table[b].element;
				table[b].element = theElement;
				return elementToReturn;
			} else // table is full
			{
				throw new IllegalArgumentException("full table");
			}
		}
	}

	/**
	 * 
	 * Print the data structure
	 * 
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < divisor; i++) {
			if (table[i] == null) {
				s.append("null\n");
			} else {
				s.append(Math.abs(table[i].key.hashCode()) + " "
						+ table[i].element + "\n");
			}
		}
		return new String(s);
	}
}