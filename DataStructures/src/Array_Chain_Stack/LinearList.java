package Array_Chain_Stack;

public interface LinearList
{
    
    /**
     * Return true if the list is empty. false otherwise 
     */
    public boolean isEmpty();
    
    /**
     * Return the number of elements in the list 
     */
    public int size();
    
    /**
     * Return the index-th element of the list
     */
    public Object get(int index);
    
    /**
     * Update the index-th element of the list
     */
    public void set (int index, Object theElement);
    
    /**
     * Return the position of the first occurrence of x
     * in the list, return -1 if x is not in the list
     */
    public int indexOf(Object theElement);
    
    /**
     * Remove and return the index-th element, elements
     * with higher index have their index reduced by 1 
     */
    public Object remove(int index);
    
    /**
     * Insert x as the index-th element, elements with
     * index >= index have their index increased by 1 
     */
    public void add(int index, Object theElement);
    
    /**
     * Output the list elements from left to right
     */
    public String toString();

}