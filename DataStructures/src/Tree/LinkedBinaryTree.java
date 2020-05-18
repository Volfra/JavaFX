package Tree;

import Queue.*;
import java.lang.reflect.Method;

public class LinkedBinaryTree implements BinaryTree {

	// root node
	BinaryTreeNode root;
	// class data members
	static Method visit;
	// visit method for traversal
	static Object[] visitArgs = new Object[1];
	// parameters of visit method
	static int count;
	// counter
	static Class<?>[] paramType = { BinaryTreeNode.class };
	// type of parameter for visit
	static Method theAdd1;
	// method to increment count by 1
	static Method theOutput;
	// method to output a node

	// Static initialization block: 
	// Runs once (when the class is initialized)
	static {
		try {
			Class<?> lbt = LinkedBinaryTree.class;
			theAdd1 = lbt.getMethod("add1", paramType);
			theOutput = lbt.getMethod("output", paramType);
		} catch (Exception e) {
			System.out.println("No exists the name of the method");
		}
	}

	public static void output(BinaryTreeNode t) {
		System.out.print(t.element + " ");
	}

	/** visit method to count nodes */
	public static void add1(BinaryTreeNode t) {
		count++;
	}

	/**
	 * @return true iff tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * @return root element if tree is not empty
	 * @return null if tree is empty
	 */
	public Object root() {
		return (root == null) ? null : root.element;
	}

	/**
	 * set this to the tree with the given root and subtrees CAUTION: does not
	 * clone left and right
	 */
	public void makeTree(Object root, Object left, Object right) {
		this.root = new BinaryTreeNode(root, ((LinkedBinaryTree) left).root, ((LinkedBinaryTree) right).root);
	}

	/**
	 * remove the left subtree
	 *
	 * @throws IllegalArgumentException
	 *             when tree is empty
	 * @return removed subtree
	 */
	public BinaryTree removeLeftSubtree() {
		if (root == null) {
			throw new IllegalArgumentException("tree is empty");
		}
		// detach left subtree and save in leftSubtree
		LinkedBinaryTree leftSubtree = new LinkedBinaryTree();
		leftSubtree.root = root.leftChild;
		root.leftChild = null;
		return (BinaryTree) leftSubtree;
	}

	/**
	 * remove the right subtree
	 *
	 * @throws IllegalArgumentException
	 *             when tree is empty
	 * @return removed subtree
	 */
	public BinaryTree removeRightSubtree() {
		if (root == null) {
			throw new IllegalArgumentException("tree is empty");
		}
		// detach right subtree and save in rightSubtree
		LinkedBinaryTree rightSubtree = new LinkedBinaryTree();
		rightSubtree.root = root.rightChild;
		root.rightChild = null;
		return (BinaryTree) rightSubtree;
	}

	/**
	 * count number of nodes in tree
	 */
	public int size() {
		count = 0;
		preOrder(theAdd1);
		return count;
	}

	/**
	 * preorder traversal
	 */
	public void preOrder(Method visit) {
		this.visit = visit;
		thePreOrder(root);
	}

	/**
	 * actual preorder traversal method
	 */
	static void thePreOrder(BinaryTreeNode t) {
		if (t != null) {
			visitArgs[0] = t;
			// visit tree root
			try {
				visit.invoke(null, visitArgs);
			} catch (Exception e) {
				System.out.println(e);
			}
			thePreOrder(t.leftChild); // do left subtree
			thePreOrder(t.rightChild); // do right subtree
		}
	}

	/**
	 * output elements in preorder
	 */
	public void preOrderOutput() {
		preOrder(theOutput);
	}

	/**
	 * inorder traversal
	 */
	public void inOrder(Method visit) {
		this.visit = visit;
		theInOrder(root);
	}

	/**
	 * actual inorder traversal method
	 */
	static void theInOrder(BinaryTreeNode t) {
		if (t != null) {
			theInOrder(t.leftChild); // do left subtree
			visitArgs[0] = t;
			// visit tree root
			try {
				visit.invoke(null, visitArgs);
			} catch (Exception e) {
				System.out.println(e);
			}
			theInOrder(t.rightChild); // do right subtree
		}
	}

	/**
	 * output elements in inorder
	 */
	public void inOrderOutput() {
		inOrder(theOutput);
	}

	/**
	 * postorder traversal
	 */
	public void postOrder(Method visit) {
		this.visit = visit;
		thePostOrder(root);
	}

	/**
	 * actual postorder traversal method
	 */
	static void thePostOrder(BinaryTreeNode t) {
		if (t != null) {
			thePostOrder(t.leftChild); // do left subtree
			thePostOrder(t.rightChild); // do right subtree
			visitArgs[0] = t;
			// visit tree root
			try {
				visit.invoke(null, visitArgs);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * output elements in postorder
	 */
	public void postOrderOutput() {
		postOrder(theOutput);
	}

	/**
	 * level order traversal
	 */
	public void levelOrder(Method visit) {
		ArrayQueue q = new ArrayQueue();
		BinaryTreeNode t = root;
		while (t != null) {
			visitArgs[0] = t;
			// visit tree root
			try {
				visit.invoke(null, visitArgs);
			} catch (Exception e) {
				System.out.println(e);
			}
			// put t’s children on queue
			if (t.leftChild != null) {
				q.put(t.leftChild);
			}
			if (t.rightChild != null) {
				q.put(t.rightChild);
			}
			// get next node to visit
			t = (BinaryTreeNode) q.remove();
		}
	}

	/**
	 * output elements in level order
	 */
	public void levelOrderOutput() {
		levelOrder(theOutput);
	}

	/**
	 * @return tree height
	 */
	public int height() {
		return theHeight(root);
	}

	/**
	 * @return height of subtree rooted at t
	 */
	static int theHeight(BinaryTreeNode t) {
		if (t == null) {
			return 0;
		}
		// height of left subtree
		int hl = theHeight(t.leftChild);
		// height of right subtree
		int hr = theHeight(t.rightChild);
		if (hl > hr) {
			return ++hl;
		} else {
			return ++hr;
		}
	}

	/**
	 * WS 27.10.16 Search a object in the tree
	 * 
	 * @param o Element to searching in tree
	 * @return Node with element or null
	 */
	public BinaryTreeNode Search(Object o) {
		ArrayQueue q = new ArrayQueue();
		BinaryTreeNode t = root;
		BinaryTreeNode b = null;
		while (t != null) {
			if (t.element.equals(o)) {
				b = t;
				break;
			}
			if (t.leftChild != null) {
				q.put(t.leftChild);
			}
			if (t.rightChild != null) {
				q.put(t.rightChild);
			}
			// get next node to visit
			t = (BinaryTreeNode) q.remove();
		}

		return b;
	}

}
