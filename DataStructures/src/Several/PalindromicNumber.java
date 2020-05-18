package Several;

import java.util.Scanner;

/**
 * Palindromic number Recursion and TailRecursion
 * 
 * @author wilsonsoto
 * @since 08.09.17
 */
public class PalindromicNumber {
	
	public static void main(String[] args) {
		
		Scanner indata = new Scanner(System.in);
		int n = indata.nextInt();
		System.out.println(calculateRecPalin(n));
		System.out.println(calculateRecTailPalin(n,true));
		indata.close();
	}
	
	public static boolean calculateRecPalin (int n) {
		if (n<10) return true; 
		else return calculateRecPalin 
			((n - n/(int)Math.pow(10,Math.floor(Math.log10(n)))*(int)Math.pow(10,Math.floor(Math.log10(n))))/10)
				&& ((n/(int)Math.pow(10,Math.floor(Math.log10(n))))
					==(n - n/(int)Math.pow(10,Math.floor(Math.log10(n)))*(int)Math.pow(10,Math.floor(Math.log10(n))))%10);
	}

	public static boolean calculateRecTailPalin (int n, boolean b) {
		if (n<10) return b; 
		else return calculateRecTailPalin 
			((n - n/(int)Math.pow(10,Math.floor(Math.log10(n)))*(int)Math.pow(10,Math.floor(Math.log10(n))))/10, 
				b && ((n/(int)Math.pow(10,Math.floor(Math.log10(n))))
					==(n - n/(int)Math.pow(10,Math.floor(Math.log10(n)))*(int)Math.pow(10,Math.floor(Math.log10(n))))%10));
	}


}
