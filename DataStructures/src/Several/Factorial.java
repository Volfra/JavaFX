package Several;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * Factorial Big NUmbers Tail Recursion
 * 
 * @author wilsonsoto
 * @since 08.09.17
 */
class Factorial {
	
	
	public static void main(String[] args) {
	
		Scanner entrada = new Scanner(System.in);
		String s = entrada.next();
		BigInteger x = new BigInteger(s);
		String out = facto(x,BigInteger.valueOf(1)).toString();
		System.out.println(out);
		entrada.close();
	}	

	public static BigInteger facto(BigInteger n, BigInteger f) {
		if (n.equals(BigInteger.valueOf(0)))
			return f; 
		else
			return facto(n.subtract(BigInteger.valueOf(1)), n.multiply(f));
			
	}
	
}
