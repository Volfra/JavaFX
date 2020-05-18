package edu.academic.JML.model;

/**
 * Recursive Tail implementation
 * @author Wilson Soto
 * @since 29.03.16
 *
 */
public class TailRecursion implements Function {
	
	@Override
	public int factorial (int n) {
		return factorial (n,1);
	}
	
	/*
	 * @ 
	 * requires n>=1 && f==1; 
	 * ensures \result == (\product int H; 1<=H && H<=n; H);
	 * @
	 */
	private static int factorial (int n, int f) {
		if (n == 1)
			return f;
		else
			return factorial (n - 1, f * n);
	}

	@Override
	public boolean isPrime(int n) {
		if (n==2) 
			return true;
		else
			return isPrime(n, n-1, true);
	}
	
	/*
	 * @ 
	 * requires n>=3; 
	 * ensures \result == (\forall int K; 2<=K && K<=n-1; n%K!=0);
	 * @
	 */
	private boolean isPrime(int n, int i, boolean b) {
		if (i==2) 
			return b; 
		else 
			return isPrime(n, i-1, b && (n%i!=0));
	}

}
