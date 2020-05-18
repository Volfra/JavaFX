package Recursion;

import static org.junit.Assert.*;

import org.junit.Test;

import Array_Chain_Stack.ArrayLinearList;
import Array_Chain_Stack.LinearList;

public class Test_Functions {

	Functions functions_Tail_Recursion = new Tail_Recursion();
	Functions functions_Simple_Recursion = new Simple_Recursion();
	
	
	@Test
	public void test1() {

		assertEquals(120, functions_Simple_Recursion.factorial(5));
		assertEquals(64.0, functions_Simple_Recursion.power(4, 3), 1.0);
		assertEquals(0.4794, functions_Simple_Recursion.sin_x(0.5), 0.001);
		assertEquals(0.8414, functions_Simple_Recursion.sin_x(1.0), 0.001);
		assertEquals(-0.9974, functions_Simple_Recursion.sin_x(-1.5), 0.001);
		
		LinearList x = new ArrayLinearList();
        x.add(0, new Integer(2));
        x.add(1, new Integer(6));
        x.add(0, new Integer(1));
        x.add(2, new Integer(4));
		assertEquals(13, functions_Simple_Recursion.suma(x,x.size()-1));
	}
	
	
	@Test
	public void test2() {

		assertEquals(120, functions_Tail_Recursion.factorial(5));
		assertEquals(64.0, functions_Tail_Recursion.power(4, 3), 0.0);
		assertEquals(0.4794, functions_Tail_Recursion.sin_x(0.5), 0.001);
		assertEquals(0.8414, functions_Tail_Recursion.sin_x(1.0), 0.001);
		assertEquals(-0.9974, functions_Tail_Recursion.sin_x(-1.5), 0.001);
		
		LinearList x = new ArrayLinearList();
        x.add(0, new Integer(2));
        x.add(1, new Integer(6));
        x.add(0, new Integer(1));
        x.add(2, new Integer(4));
		assertEquals(13, functions_Tail_Recursion.suma(x,x.size()-1));
		
	}

}
