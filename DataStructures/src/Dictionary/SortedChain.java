package Dictionary;

public class SortedChain implements Dictionary{
       
    // top-level nested class
    protected static class SortedChainNode {
    // data members
        protected Comparable key;
        protected Object element;
        protected SortedChainNode next;

        private SortedChainNode(Object theKey, Object theElement, SortedChainNode p) {
            key = (Comparable) theKey;
            element = theElement;
            next = p;
        }
    }
    
    // data members of SortedChain
    protected SortedChainNode firstNode;
    protected int size;
    
    // methods
    public boolean isEmpty() {
        return size == 0;
    }    
    
    /**
     * @return element with specified key
     * @return null if there is no matching element
     */
    public Object get(Object theKey) {
        SortedChainNode currentNode = firstNode;
    // search for match with theKey
        while (currentNode != null && currentNode.key.compareTo(theKey) < 0) 
        {
            currentNode = currentNode.next;
        }
    // verify match
        if (currentNode != null && currentNode.key.equals(theKey)) // yes, found match
        {
            return currentNode.element;
        }
    // no match
        return null;
    }
    
    /**
     * @return matching element and remove it
     * @return null if no matching element
     */
    public Object remove(Object theKey) {
        SortedChainNode p = firstNode, tp = null; // tp trails p
    // search for match with theKey
        while (p != null && p.key.compareTo(theKey) < 0) {
            tp = p;
            p = p.next;
        }
    // verify match
        if (p != null && p.key.equals(theKey)) {// found a match
            Object e = p.element; // the matching element
    // remove p from the chain
            if (tp == null) {
                firstNode = p.next;
            } else {
                tp.next = p.next;
            }
            size--;
            return e;
        }
    // no matching element to remove
        return null;
    }

    /**
     * insert an element with the specified key overwrite old element if there
     * is already an element with the given key
     *
     * @return old element (if any) with key theKey
     */
    public Object put(Object theKey, Object theElement) {
        SortedChainNode p = firstNode,
                tp = null; // tp trails p
    // move tp so that theElement can be inserted after tp
        while (p != null && p.key.compareTo(theKey) < 0) {
            tp = p;
            p = p.next;
        }
    // check if there is a matching element
        if (p != null && p.key.equals(theKey)) {// replace old element
            Object elementToReturn = p.element;
            p.element = theElement;
            return elementToReturn;
        }
    // no match, set up node for theElement
        SortedChainNode q = new SortedChainNode(theKey, theElement, p);
    // insert node just after tp
        if (tp == null) {
            firstNode = q;
        } else {
            tp.next = q;
        }
        size++;
        return null;
    }
    
    public String toString () {
        StringBuffer s = new StringBuffer("[");
        // put elements into the buffer
        SortedChainNode currentNode = firstNode;
        while(currentNode!=null) {
            s.append("("+currentNode.key.toString()+" * "+currentNode.element.toString()+"), ");
            currentNode = currentNode.next;
        }    
            
        if (size > 0)
            s.delete(s.length() - 2, s.length());

        s.append("]");
        // create equivalent String
        return new String(s);
    }
    
}
