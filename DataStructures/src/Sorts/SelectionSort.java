
package Sorts;

/**
 * Selection Sort
 * <p>
 * Let a=[0:n−1] and n=a.length. In selection sort we find the largest item and put it in a[n − 1], 
 * then determine the largest of the remaining n − 1 elements and move it to a[n − 2], and so on.
 * 
 * @author wilsonsoto
 * @since 20.09.15
 */
public class SelectionSort {
	
	/**
	 * 
	 * @param a Comparable[]
	 * 
	 */
    public static void selectionSort(Comparable[] a) {
        for (int size = a.length; size > 1; size--) {
            int j = MyMath.max(a, size - 1);
            MyMath.swap(a, j, size - 1);
        }
    }

}
