
package Sorts;

/**
 * Insertion Sort
 * <p>
In insertion sort we traverse the list of items. For each item, we insert it into its correct position 
amongst the items that we have already sorted.
We start with an array that contains just the first element, then we insert the second element into the 
one-element array, we get a sorted array of size 2. The insertion of the third element yields a sorted 
array of size 3, and so on.
 * 
 * @author wilsonsoto
 * @since 20.09.15
 * 
 */
public class InsertionSort {
	
	/**
	 * 
	 * @param a Comparable[]
	 * 
	 */
    public static void insertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) { 
        	// insert a[i] into a[0:i-1]
            Comparable t = a[i];
            // find proper place for t
            int j;
            for (j = i - 1; j >= 0 && (t.compareTo(a[j]) < 0); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = t; // insert t = original a[i]
        }
    }

}
