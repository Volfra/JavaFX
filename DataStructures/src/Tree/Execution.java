package Tree;

import java.util.Scanner;

public class Execution {

	public static void main(String[] args) {

		LinkedBinaryTree a = new LinkedBinaryTree(), 
							x = new LinkedBinaryTree(), 
								y = new LinkedBinaryTree(),
									z = new LinkedBinaryTree(), 
										w = new LinkedBinaryTree(), 
											v = new LinkedBinaryTree();

		// Build from leaves to root
		y.makeTree(new Integer(1), a, a);
		z.makeTree(new Integer(2), a, a);
		x.makeTree(new Integer(3), y, z);

		z.makeTree(new Integer(4), a, a);
		y.makeTree(new Integer(5), a, a);
		w.makeTree(new Integer(6), z, y);

		w.removeRightSubtree();

		y.makeTree(new Integer(7), x, w);

		z.makeTree(new Integer(8), a, a);
		x.makeTree(new Integer(9), a, a);
		w.makeTree(new Integer(10), z, x);

		z.makeTree(new Integer(11), a, a);
		x.makeTree(new Integer(12), a, a);
		v.makeTree(new Integer(13), z, x);

		x.makeTree(new Integer(14), w, v);

		z.makeTree(new Integer(15), y, x);
		
		Scanner entrada = new Scanner(System.in);

		// Build dynamic tree
		try {
			z = null;
			z = new LinkedBinaryTree();

			// Root element
			int s = Integer.parseInt(entrada.nextLine());

			z.makeTree(s, a, a);

			while (true) {
				// Search father. End data with a not number.
				s = Integer.parseInt(entrada.nextLine());
				BinaryTreeNode xs = z.Search(s);
				// Found the element?
				if (xs != null) {
					BinaryTreeNode add = new BinaryTreeNode();
					// New element
					s = Integer.parseInt(entrada.nextLine());
					add.element = s;
					add.leftChild = null;
					add.rightChild = null;
					// Rigth(r) or Left(l)
					String pos = entrada.nextLine();
					if (pos.equals("r")) {
						if (xs.rightChild == null) {
							xs.rightChild = add;
						} else {
							xs.rightChild.element = s;
						}
					} else {
						if (pos.equals("l")) {
							if (xs.leftChild == null) {
								xs.leftChild = add;
							} else {
								xs.leftChild.element = s;
							}
						} else {
							System.out.println("Position wrong!!!");
						}
					}
				} else {
					// No matter the new element and its position (the second
					// and third line)
					entrada.nextLine();
					entrada.nextLine();
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Exit");
		}

		entrada.close();

		System.out.println("Preorder sequence is ");
		z.preOrderOutput();

		System.out.println("\nInorder sequence is ");
		z.inOrderOutput();

		System.out.println("\nPostorder sequence is ");
		z.postOrderOutput();

		System.out.println("\nLevel order sequence is ");
		z.levelOrderOutput();

		System.out.println("\nNumber of nodes = " + z.size());
		System.out.println("Height = " + z.height());

	}

}
