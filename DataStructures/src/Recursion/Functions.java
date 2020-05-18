package Recursion;

import Array_Chain_Stack.LinearList;

/**
 * 
 * @author wilson.soto
 * @since 28.01.16
 *
 */
public interface Functions {
	
	/**
	 * Power x and y
	 * 
	 * @param x double number
	 * @param n int number
	 * 
	 */
	public double power (double x, int n);

	/**
	 * Factorial
	 * 
	 * @param n natural number
	 * 
	 */
	public int factorial (int n);
	
	/**
	 * Sin x
	 * 
	 * @param x double number
	 * 
	 */
	public double sin_x (double x);
	
	/**
	 * 
	 * Sum elements in the array
	 * 
	 * @param y LinearList
	 * @param n size
	 * @return sum elements in the array
	 */
	public int suma (LinearList y, int n);
}
