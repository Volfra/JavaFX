
package Sorts;

/**
 * 
 * Merge Sort
 * <p>
 * The basic idea for merge sorting a list, such as (5,3,8,6,7,2,4,1), is a three-step process:
 * <p>
 * 1) divide the list in two halves, L = (5,3,8,6) and R = (7,2,4,1);
 * <p>
 * 2) sort the two half-lists, getting L = (3,5,6,8) and R = (1,2,4,7); and
 * <p>
 * 3) merge the two half-lists into the final sorted list Merge(L,R)=(1,2,3,4,5,6,7,8).
 * 
 * @author wilsonsoto
 * @since 20.09.15
 *
 */

public class MergeSort {
    
    /**
     * 
     * @param a Comparable[]
     * @param left int
     * @param right int
     * 
     */
    public static void mergeSort(Comparable[] a, int left, int right) {
        if (left < right) {
            Comparable[] b = new Comparable[a.length];
            int middle = (left + right) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            merge(a, b, left, middle, right); // merge a to b
            copy(b, a, left, right); // copy result back to a
        }
    }
    
    /**
     * 
     * @param b Comparable[]
     * @param a Comparable[]
     * @param i int
     * @param j int
     * 
     */
    public static void copy (Comparable[] b, Comparable[] a, int i, int j) {
        for (int idx=i; idx<=j; idx++)
            a[idx] = b[idx];
    }
    
    /**
     * 
     * @param a Comparable[]
     * 
     */
    public static void mergeSort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        int segmentSize = 1;
        while (segmentSize < a.length) {
            mergePass(a, b, segmentSize); // merge from a to b
            segmentSize += segmentSize;
            
            //System.out.print(segmentSize+":");
            //for (int i=0;i<b.length;i++ )
            //System.out.print(b[i]+" ");
            //System.out.println();
            
            mergePass(b, a, segmentSize); // merge from b to a
            segmentSize += segmentSize;
            
            //System.out.print(segmentSize+":");
            //for (int i=0;i<a.length;i++ )
            //System.out.print(a[i]+" ");
            //System.out.println();

        }
    }
    
    /**
     * 
     * @param x Comparable[]
     * @param y Comparable[]
     * @param segmentSize int
     * 
     */
    public static void mergePass(Comparable[] x, Comparable[] y, int segmentSize) {
        int i = 0; // start of the next segment
        while (i <= x.length - 2 * segmentSize) { // merge two adjacent segments from x to y
            merge(x, y, i, i + segmentSize - 1,i + 2 * segmentSize - 1);
            i = i + 2 * segmentSize;
        }
        // fewer than 2 full segments remain
        if (i + segmentSize < x.length) // 2 segments remain
        {
            merge(x, y, i, i + segmentSize - 1, x.length - 1);
        } else // 1 segment remains, copy to y
        {
            for (int j = i; j < x.length; j++) {
                y[j] = x[j];
            }
        }
    }
    
    /**
     * 
     * @param c Comparable[]
     * @param d Comparable[]
     * @param startOfFirst int
     * @param endOfFirst int
     * @param endOfSecond int
     * 
     */
    public static void merge(Comparable[] c, Comparable[] d, int startOfFirst, int endOfFirst, int endOfSecond) {
        int first = startOfFirst, // cursor for first segment
            second = endOfFirst + 1, // cursor for second
            result = startOfFirst; // cursor for result
        // merge until one segment is done
        while ((first <= endOfFirst) && (second <= endOfSecond)) {
            if (c[first].compareTo(c[second]) <= 0) {
                d[result++] = c[first++];
            } else {
                d[result++] = c[second++];
            }
        }
        // take care of leftovers
        if (first > endOfFirst) {
            for (int q = second; q <= endOfSecond; q++) {
                d[result++] = c[q];
            }
        } else {
            for (int q = first; q <= endOfFirst; q++) {
                d[result++] = c[q];
            }
        }
    }  
    
}
