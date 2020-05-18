package Array_Chain_Stack;

public class Chain implements LinearList {
    
    protected ChainNode firstNode;
    protected int size;
        
    public Chain (int initialCapacity) { }
    
    public Chain () { 
        this(0); 
    }
    
    public boolean isEmpty() {
        
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    void checkIndex (int index) {
        if (index < 0 || index >=  size) 
            throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);                    
    }
    
    public Object get (int index) {
        checkIndex (index);
        ChainNode currentNode = firstNode;
        for (int i=0; i<index; i++)
            currentNode =  currentNode.next;
        
        return currentNode.element;
    }
    
    public void set (int index, Object theElement) {
    	checkIndex (index);
        ChainNode currentNode = firstNode;
        for (int i=0; i<index; i++)
            currentNode =  currentNode.next;
        currentNode.element = theElement;
    }
    
    public int indexOf (Object theElement) {
        ChainNode currentNode = firstNode;
        int index=0;
        while (currentNode != null && !currentNode.element.equals(theElement)) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null) return -1;
        else return index;
    }
    
    public String toString () {
        StringBuffer s = new StringBuffer("[");
        
        // put elements into the buffer
        ChainNode currentNode = firstNode;

        while(currentNode != null)
        {
            if (currentNode.element == null)
                s.append("null, ");
            else
                s.append(currentNode.element.toString().concat(", "));
        currentNode = currentNode.next;
        }
        
        // remove last ", "
        if (size > 0)
            s.delete(s.length() - 2, s.length());
        
        s.append("]");
        
        // create equivalent String
        return new String(s);
        
    }
    
    public Object remove(int index) {
        checkIndex(index);
        Object removedElement;
        if (index == 0) // remove first node
        {
            removedElement = firstNode.element;
            firstNode = firstNode.next;
        }
        else
        { 
            // use q to get to predecessor of desired node
            ChainNode q = firstNode;
            for (int i = 0; i < index - 1; i++)
                q = q.next;
            removedElement = q.next.element;
            q.next = q.next.next; // remove desired node
        }
        size--;
        return removedElement;
    }
    
    public void add(int index, Object theElement)
    {
        // invalid list position
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);
        
        if (index == 0)
            // insert at front
            firstNode = new ChainNode(theElement, firstNode);
        else
        { // find predecessor of new element
            ChainNode p = firstNode;
            for (int i = 0; i < index - 1; i++)
            p = p.next;
            // insert after p
            p.next = new ChainNode(theElement, p.next);
        }
        size++;
    }
    
}
