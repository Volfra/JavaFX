package Concepts;

/**
 * 
 * @author Wilson Soto Argument Passing
 */
public class TestSwap3 {

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public static void swap(Wraper x, Wraper y) {
		Object temp = x.obj;
		x.obj = y.obj;
		y.obj = temp;
	}

	public static void main(String[] args) {
		Wraper a = new Wraper();
		a.obj = new Integer(4);
		Wraper b = new Wraper();
		b.obj = new Integer(5);
		swap(a, b);
		System.out.println("a=" + a.obj); // 5
		System.out.println("b=" + b.obj); // 4
	}
}
