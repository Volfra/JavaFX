package Sorts;

import static Sorts.SelectionSort.selectionSort;
import static Sorts.InsertionSort.insertionSort;
import static Sorts.MergeSort.mergeSort;
import static Sorts.BubbleSort.bubbleSort;
import static Sorts.QuickSort.quickSort;
import static Sorts.HeapSort.heapSort;
import java.util.Scanner;

public class Execution {
	public static void main(String[] args) {

		Integer[] a = { -4, 5, 12, -8, 3, 6, 17, 0 };

		// Efficient moving items in array (special case heapsort)
		Integer[] a1 = new Integer[a.length + 1];
		System.arraycopy(a, 0, a1, 1, a.length);

		System.out.println("The elements are");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("\nSelect sort method");
		Scanner entradaEscaner = new Scanner(System.in);
		int op = Integer.parseInt(entradaEscaner.nextLine());

		switch (op) {
		case 1:
			System.out.println("SelectionSort");
			selectionSort(a);
			break;
		case 2:
			System.out.println("InsertionSort");
			insertionSort(a);
			break;
		case 3:
			System.out.println("BubbleSort");
			bubbleSort(a);
			break;
		case 4:
			System.out.println("MergeSort");
			mergeSort(a, 0, a.length - 1);
			break;// mergeSort(a); break;
		case 5:
			System.out.println("QuickSort");
			quickSort(a);
			break;
		case 6:
			System.out.println("HeapSort");
			heapSort(a1);
			break;
		}

		System.out.println("\nThe sorted order is");
		for (int i = 0; i < a.length; i++) {
			if (op == 6)
				System.out.print(a1[i + 1] + " ");
			else
				System.out.print(a[i] + " ");
		}
		System.out.println();

		Integer[] x = { null, new Integer('E'), new Integer('S'),
				new Integer('T'), new Integer('R'), new Integer('U'),
				new Integer('C'), new Integer('T'), new Integer('U'),
				new Integer('R'), new Integer('A'), new Integer('S'),
				new Integer('D'), new Integer('E'), new Integer('D'),
				new Integer('A'), new Integer('T'), new Integer('O'),
				new Integer('S') };

		HeapSort.heapSort(x);

		for (int i = 1; i < x.length; i++)
			System.out.print(Character.toChars(x[i]));
		System.out.println();

		entradaEscaner.close();

	}

}
