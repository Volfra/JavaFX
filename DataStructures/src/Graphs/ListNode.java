package Graphs;

public class ListNode {

	int id;
    Object element;
    ListNode next;
    
    ListNode (){}
    
    ListNode (int id, Object element) {
        this.id = id;
    	this.element = element;
    }
    
    ListNode (int id, Object element, ListNode next) {
        this.id = id;
    	this.element = element;
        this.next = next;
    }
	
}
