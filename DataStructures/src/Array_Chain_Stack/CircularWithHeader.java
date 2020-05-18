package Array_Chain_Stack;

public class CircularWithHeader implements LinearList {
    
    protected ChainNode headerNode;
    protected int size;
    
    public CircularWithHeader()
    {
        headerNode = new ChainNode();
        headerNode.next = headerNode;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public int size()
    {
        return size;
    }
    
    void checkIndex(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);
    }
    
    public Object get(int index)
    {
        checkIndex(index);
        ChainNode currentNode = headerNode.next;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next; 
        
        return currentNode.element;
    }
    
    public void set (int index, Object theElement) {
        checkIndex(index);
        ChainNode currentNode = headerNode.next;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next; 
        
        currentNode.element = theElement;
    }
    
    public int indexOf(Object theElement)
    {
        headerNode.element = theElement;
        ChainNode currentNode = headerNode.next;
        int index = 0;
        
        while (!currentNode.element.equals(theElement))
        {
            currentNode = currentNode.next;
            index++;
        }
        
        if (currentNode == headerNode)
            return -1;
        else
            return index;
    }
    
    public Object remove(int index)
    {
        checkIndex(index);
        Object removedElement;
        ChainNode q = headerNode;
        for (int i = 0; i < index; i++) 
        	q = q.next;
        removedElement = q.next.element;
        q.next = q.next.next;
        size--;
        return removedElement;
    }
    
    public void add(int index, Object theElement)
    {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);

        ChainNode p = headerNode; 
        for (int i = 0; i < index; i++) 
            p = p.next;
        p.next = new ChainNode(theElement, p.next);
        size++;
    }
    
    public String toString () {
        StringBuffer s = new StringBuffer("[");
        
        // put elements into the buffer
        ChainNode currentNode = headerNode.next;

        while(currentNode != headerNode)
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

}
