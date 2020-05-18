package Concepts;

/**
 *
 * @author Wilson Soto
 * Argument Passing
 */
public class TestSwap {
    
    /**
     * 
     * @param x
     * @param y 
     */
    public static void swap(int x, int y) {
        int temp;
        temp = x;
        x = y;
        y = temp;
    }
    
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        swap(a, b);
        System.out.println("a=" + a); // 4
        System.out.println("b=" + b); // 5
    }

}
