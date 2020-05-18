package Concepts;

/**
 *
 * @author Wilson Soto
 * Argument Passing
 */
public class TestSwap2 {

    /**
     * 
     * @param x
     * @param y 
     */
    public static void swap(Object x, Object y) {
        Object temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        Integer a = new Integer(4);
        Integer b = new Integer(5);
        swap(a, b);
        System.out.println("a=" + a); // 4
        System.out.println("b=" + b); // 5
    }
}
