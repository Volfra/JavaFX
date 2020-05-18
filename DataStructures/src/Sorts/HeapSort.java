package Sorts;

import PriorityQueue.MaxHeap;

public class HeapSort {

    public static void heapSort(Comparable[] a) {
        MaxHeap h = new MaxHeap();
        h.initialize(a, a.length - 1);
        //System.out.println(h);
        for (int i = a.length - 2; i >= 1; i--) {
            a[i + 1] = h.removeMax();
        }
    }
    
}
