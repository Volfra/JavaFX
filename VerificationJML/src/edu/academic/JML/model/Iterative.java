package edu.academic.JML.model;

/**
 * Iterative implementation
 * 
 * @author Wilson Soto
 * @since 29.03.16
 *
 */
public class Iterative implements Function {

	@Override
	/**
	 * @throws ArithmeticException("Integer overflow");
	 */
	/*
	 * @ 
	 * requires n>=0; 
	 * ensures \result == (\product int H; 1<=H && H<=n; H);
	 * @
	 */
	public int factorial(int n) {
		int f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
			if (f < 1)
				throw new ArithmeticException("Integer overflow");
		}
		return f;
	}

	@Override
	/*
	 * @ 
	 * requires n>=2; 
	 * ensures \result == (\forall int K; 2<=K && K<=n-1; n%K!=0);
	 * @
	 */
	public boolean isPrime(int n) {
		boolean r = true;
		if (n==2) 
			return true;
		else
			for (int i = 2; i <= n-1; i++)
				r = r && (n%i!=0);
		return r;
	}
}
