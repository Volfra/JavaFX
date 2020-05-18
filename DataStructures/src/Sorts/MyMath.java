package Sorts;

public class MyMath {
    
	/**
	 * 
	 * @param a Comparable[]
	 * @param i int
	 * @return int
	 */
    public static int max (Comparable []a, int i) {
        Comparable val=a[0];
        int pos=0;
        for (int x=1; x<=i; x++)
            if (a[x].compareTo(val)>0) { 
                val=a[x];
                pos=x;
            }
        
        return pos;
    }
    
    /**
     * 
     * @param a Comparable[]
     * @param pos int
     * @param k int
     * 
     */
    public static void swap (Comparable[] a, int pos, int k) {
        Comparable t = a[pos];
        a[pos] = a[k];
        a[k] = t;
    }
    
}
