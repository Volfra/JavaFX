package Queue;

public class ChainNode {

    Object element;
    ChainNode next;
    
    ChainNode (){}
    
    ChainNode (Object element) {
        this.element = element;
    }
    
    ChainNode (Object element, ChainNode next) {
        this.element = element;
        this.next = next;
    }
    
}
