package Recursion;

import Array_Chain_Stack.LinearList;

public class Tail_Recursion implements Functions {

	public double power(double x, int n) {
		return power_tail(x,n,1.0);
	}

	private double power_tail(double x, int n, double p) {
		if (n==0) return p;
		else return power_tail (x, n-1, p*x);
	}

	public int factorial(int n) {
		return factorial_tail (n,1);
	}

	private int factorial_tail(int n, int f) {
		if (n==1) return f; 
		else return factorial_tail(n-1,f*n);
	}

	public double sin_x(double x) {
		return sin_x_tail (x, 10, 0.0);
	}

	private double sin_x_tail(double x, int n, double r) {
		if (n==0) return r+x;
		else return sin_x_tail (x, n-1, r + (power(-1,n)/factorial(2*n+1))*(power(x,2*n+1)));
	}	
	
    public int suma (LinearList y, int n) {
    	return  suma(y, y.size()-1, 0);
    }
	
    private int suma (LinearList y, int n, int acc) {
        if (n==-1) return acc;
        else return suma (y, n-1, acc + (Integer)y.get(n));
    } 
}
