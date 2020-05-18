	/*
	 * 
	 * Classname First_Test
	 * Version 1.0
	 * Purpose : Use of JUnit for testing 
	 * 			 
	 */
	
	package Recursion;
	
	/**
	 * 
	 * @author Wilson Soto
	 * @since 28.01.16
	 * 
	 */
	import static org.junit.Assert.*;
	import org.junit.Test;
	
	public class First_Test {
	
		/**
		 * Test method class First 
		 * Compare two arrays 
		 */
		@Test
		public void test() {
			
			/* Instance class First */
			First object_First = new First ();
			
			/* Input data*/
			int[] myArray_Input_Test = {41,23,56454,108,567,32,546,8761};
			
			/* Output data*/
			int[] myArray_Output_Test = {5,5,24,9,18,5,15,22};
			
			assertArrayEquals(object_First.testValues(myArray_Input_Test), myArray_Output_Test);
	
		}
	
	}
