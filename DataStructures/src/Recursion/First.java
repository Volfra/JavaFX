	/*
	 * 
	 * Classname First
	 * Version 1.0
	 * Purpose : Diagnose concepts oriented object programming 
	 * 			 
	 */
	
	package Recursion;
	
	/**
	 * 
	 * @author Wilson Soto
	 * @since 28.01.16
	 *
	 */
	class First {
	
		/** Euler Constant */
		protected static final double EULER_CONSTANT = 2.7178;
		
		/**
		 * The method determines the conditions of the change of the values in the array
		 * 
		 * @param myArrayTest int[]
		 * @return int[]
		 */
		public int[] testValues(int[] myArrayTest) {
			
			if (uniqueValues(myArrayTest)) {
				for (int idx=0; idx<myArrayTest.length; idx++) {
					myArrayTest[idx]=changeValues(myArrayTest[idx]);
				} 
			} else {
				System.out.println("There is not changes");
			}
			
			return myArrayTest;
			 
		}
			
		/**
		 * 
		 * The method determines if the values are unique in the array
		 * 
		 * @param myArrayTest int[]
		 * @return boolean
		 */
		private boolean uniqueValues (int[] myArrayTest) {
		
			for (int idx=0; idx<myArrayTest.length; idx++) {
				for (int jdx=idx+1; jdx<myArrayTest.length; jdx++) {
					if (myArrayTest[idx]==myArrayTest[jdx]) {
						return false;
					}
				}
			}
						
			return true;			
		}
		
		/**
		 * 
		 * The method calculates the sum of the digits of a natural number 
		 * 
		 * @param value_i_Array int
		 */
		private int changeValues (int value_i_Array) {
			int sum_Digits = 0;
			int quantity_Digits = (int) Math.floor(Math.log10(value_i_Array))+1;
			for (int idx=1; idx<=quantity_Digits; idx++) {
				sum_Digits+=value_i_Array%10;
				value_i_Array/=10;
			}
			return sum_Digits;
		}
			
	}