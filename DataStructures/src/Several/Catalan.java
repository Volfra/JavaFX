package Several;

import java.util.Scanner;

/**
 * Catalan Recursion and TailRecursion
 * 
 * @author wilsonsoto
 * @since 08.09.17
 */
public class Catalan {
	
	public static void main(String[] args) {
		
		Scanner indata = new Scanner(System.in);
		int n = indata.nextInt();
		System.out.println(calculateRecCatalan(n));
		System.out.println(calculateRecTailCatalan(n,1,1));
		indata.close();
		
	}
		
	public static int calculateRecCatalan (int n) {
		if (n==0) return 1;
		else return calculateRecCatalan(n-1)*(4*n-2)/(n+1);
	}
	
	public static int calculateRecTailCatalan (int n, int t, int c) {
		if (n==0) return c;
		else return calculateRecTailCatalan(n-1, t+1, c*(4*t-2)/(t+1)); 		
	}

}
