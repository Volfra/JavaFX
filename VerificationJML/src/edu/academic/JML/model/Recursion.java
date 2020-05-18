package edu.academic.JML.model;

/**
 * Recursive implementation
 * @author Wilson Soto
 * @since 29.03.16
 *
 */
public class Recursion implements Function {

	@Override
	/*
	 * @ 
	 * requires n>=0; 
	 * ensures \result == (\product int H; 1<=H && H<=n; H);
	 * @
	 */
	public int factorial (int n) {
		if (n == 0)
			return 1;
		else
			return factorial (n - 1) * n;
	}

	@Override
	public boolean isPrime(int n) {
		if (n==2) 
			return true;
		else
			return isPrime(n, n-1);
	}
	
	/*
	 * @ 
	 * requires n>=3; 
	 * ensures \result == (\forall int K; 2<=K && K<=n-1; n%K!=0);
	 * @
	 */
	private boolean isPrime(int n, int i) {
		if (i==2) 
			return (n%i!=0); 
		else 
			return isPrime(n,i-1) && (n%i!=0);
	}
	
	
}
