package Queue;

/**
 *
 * @author wilson soto
 * 
 */

public interface Queue
{
    /**
     * 
     * @return Object
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return Object
     */
    public Object getFrontElement();
    
    /**
     * 
     * @return Object
     */
    public Object getRearElement();
    
    /**
     * 
     * @param theObject Object 
     */
    public void put(Object theObject);
    
    /**
     * 
     * @return Object
     */
    public Object remove();
}