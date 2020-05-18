package edu.academic.JML.model;

/**
 * Function signature
 * @author Wilson Soto
 * @since 29.03.16
 *
 */
public interface Function {
	
	/**
	 * Factorial signature
	 * 
	 * @param n int
	 * @return int
	 * @custom.pre requires n &#8805; 0;
	 * @custom.pos ensures \result == (\product int H; 1 &#8804; H &#38;&#38; H &#8804; n; H);
	 */
	public int factorial (int n);

	
	/**
	 * Prime signature
	 * 
	 * @param n int
	 * @return boolean
	 * @custom.pre requires n &#8805; 2;
	 * @custom.pos ensures \result == (\forall int K; 2 &#8804; K &#38;&#38; K &#8804; n-1; n%K!=0);
	 */
	public boolean isPrime (int n);

	
}
