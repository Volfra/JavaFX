package Several;
import java.math.BigInteger;
import java.util.Scanner;

/** 
 * Uva Contest programming 
 * Exercise 369
 *  
 * @author wilsonsoto
 * @since 07.03.17
 * 
 */

class Uva369 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		while ( input.hasNext() ) {
			String x = input.nextLine();
			
			x = x.trim();
			int i=0;
			String s="";
			while (x.charAt(i)!=' '){
				s+=x.charAt(i);
				i++;
			}

			int n = Integer.parseInt(s);
			
			while (x.charAt(i)==' '){
				i++;
			}

			s="";
			while ((i-1)<x.length()-1){
				s+=x.charAt(i);
				i++;
			}
			
			int m = Integer.parseInt(s);

			if (n==0 && m==0) break;

			if (n-m>m) {         
				BigInteger w = facto(n-m+1,n);
				w = w.divide(facto(1,m));
				System.out.println(n+" things taken "+m+" at a time is "+ w +" exactly.");
			} else {
				BigInteger w = facto(m+1,n);
				w = w.divide(facto(1,n-m));
				System.out.println(n+" things taken "+m+" at a time is "+ w +" exactly.");
			}
		}

		input.close();
		System.exit(0);
	}

	static BigInteger facto (int i, int j) {
		BigInteger f = BigInteger.ONE;
		for (int k=i; k<=j; k++) 
			f=f.multiply(BigInteger.valueOf(k));
		return f;
	}

}
