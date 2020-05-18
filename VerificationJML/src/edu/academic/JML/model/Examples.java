package edu.academic.JML.model;
/**
 * Examples
 * @author Wilson Soto
 * @since 29.03.16
 *
 */
public class Examples {
	
	/*
	 * @ 
	 * requires true; 
	 * ensures (\result == 1 && x>0) || (\result == -1 && x<0) || (\result == 0 && x==0);
	 * @
	 */
	public static int f1(int x) {

		if (x > 0)
			return 1;
		else if (x != 0)
			return -1;
		else
			return 0;

	}
	
	
	public static void f2(int i) {

		// @ assert i>(1/8) && i>=1;
		int z, j;
		// @ assert 4*(i*2)>1 && (i*2)*3>=6;
		j = 0;
		// @ assert 4*(i*2)>1 && (i*2)*3>=6;
		z = 0;
		// @ assert 4*(i*2)>1 && (i*2)*3>=6;
		i = i * 2;
		// @ assert i+(i*3)>1 && i*3>=6;
		j = j + 1;
		// @ assert i+(i*3)>1 && i*3>=6;
		z = i * 3;
		// @ assert i+z>1 && z>=6;
		j = i + z;
		// @ assert j>1 && z>=6;

	}

	
	/*
	 * @ 
	 * requires x>-2 && y>-20; 
	 * ensures y>-2;
	 * @
	 */
	public static int f3(int x, int y) {

		if (x == -2 * y) {
			// @ assert x>-2 && x==-2*y;
			y = x;
		} else {
			// @ assert -1>-2 && x!=-2*y;
			y = -1;
		}
		return y;

	}

	
	/*
	 * @ 
	 * requires V.length>=1; 
	 * ensures \result == (\sum int i; 0 <= i && i < V.length; V[i]);
	 * @
	 */
	public static int f4(int[] V) {

		int s = 0;
		for (int i = 0; i < V.length; i++) {
			s += V[i];
		}
		return s;
	}

	
	/*
	 * @ 
	 * requires f.length>0 && (\exists int Y; 0<=Y && Y<f.length; f[Y]==-1);
	 * ensures \result == (\sum int H; 0<=H && H<f.length; f[H]); 
	 * @
	 */
	public static int f5(int[] A, int n) {

		if (A[n] == -1)
			return 0;
		else
			return f5(A, n + 1) + A[n];

	}


}
