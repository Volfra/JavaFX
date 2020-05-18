
package Sorts;

/**
 * 
 * Quick Sort
 * <p>
In quick sort you first choose an element in the array as a pivot element. 
The pivot is used to separate the array into three partitions:
<p>
1) A left partition containing elements < pivot. 
<p>
2) A middle partition containing the pivot.
<p>
3) A right partition containing elements ≥ pivot.
<p>
As a result, the elements in left, right and middle can be sorted independently, and no merge 
is required following the sorting of left and right.
 * 
 * @author wilsonsoto
 * @since 20.09.15
 *
 */

public class QuickSort {

    // data member
    static Comparable[] a; // array of elements to sort

    /**
     * sort a[0 : a.length - 1] using the quick sort method
     * 
     * @param a Comparable[]
     * 
     */
    public static void quickSort(Comparable[] a) {
        QuickSort.a = a;
        if (a.length <= 1) {
            return;
        }
        // move largest element to right end
        MyMath.swap(a, a.length - 1, MyMath.max(a, a.length - 1));
        quickSort(0, a.length - 2);
    }

    /**
     * sort a[leftEnd:rightEnd], a[rightEnd+1] >= a[leftEnd:rightEnd]
     * 
     * @param leftEnd int
     * @param rightEnd int
     * 
     */
    private static void quickSort(int leftEnd, int rightEnd) {
        if (leftEnd >= rightEnd) {
            return;
        }
        int leftCursor = leftEnd,   // left-to-right cursor
        rightCursor = rightEnd + 1; // right-to-left cursor
        Comparable pivot = a[leftEnd];
        // swap elements >= pivot on left side
        // with elements <= pivot on right side
        while (true) {
            do { // find >= element on left side
                leftCursor++;
            } while (a[leftCursor].compareTo(pivot) < 0);
            do { // find <= element on right side
                rightCursor--;
            } while (a[rightCursor].compareTo(pivot) > 0);
            if (leftCursor >= rightCursor) {
                break;
            }
            MyMath.swap(a, leftCursor, rightCursor);
        }

        a[leftEnd] = a[rightCursor];
        a[rightCursor] = pivot;
        quickSort(leftEnd, rightCursor - 1);
        quickSort(rightCursor + 1, rightEnd);
    }

}
