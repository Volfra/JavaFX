package Tree;

public class BinaryTreeNode
{ 
    // package visible data members
    Object element;
    BinaryTreeNode leftChild; // left subtree
    BinaryTreeNode rightChild; // right subtree
    
    // constructors
    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Object theElement) {
        element = theElement;
    }

    public BinaryTreeNode(Object theElement, BinaryTreeNode theleftChild, BinaryTreeNode therightChild) {
        element = theElement;
        leftChild = theleftChild;
        rightChild = therightChild;
    }
    
    // output method
    public String toString() {
        return element.toString();
    }
}