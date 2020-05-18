package edu.academic.JML.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.academic.JML.model.*;

public class Test_Implementations {

	@Test
	public void testFactoIte1() {
		assertEquals("Test1Ite", 12, new Iterative().factorial(5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testExceptionIte(){
		new Iterative().factorial(520);
	}

	@Test
	public void testFactoIte2() {
		assertEquals("Test2Ite", 120, new Iterative().factorial(-5));
	}

	@Test
	public void testFactoIte3() {
		assertEquals("Test3Ite", 120, new Iterative().factorial(5));
	}
	
	@Test
	public void testFactoRec1() {
		assertEquals("Test1Rec", 12, new Recursion().factorial(5));
	}

	@Test
	public void testFactoRec2() {
		assertEquals("Test2Rec", 120, new Recursion().factorial(-5));
	}

	@Test
	public void testFactoRec3() {
		assertEquals("Test3Rec", 120, new Recursion().factorial(5));
	}

	@Test
	public void testFactoTail1() {
		assertEquals("Test1Tail", 12, new TailRecursion().factorial(5));
	}

	@Test
	public void testFactoTail2() {
		assertEquals("Test2Tail", 120, new TailRecursion().factorial(-5));
	}

	@Test
	public void testFactoTail3() {
		assertEquals("Test3Tail", 120, new TailRecursion().factorial(5));
	}
}
