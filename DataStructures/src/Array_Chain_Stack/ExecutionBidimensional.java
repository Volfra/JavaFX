package Array_Chain_Stack;

import java.util.Scanner;

/**
 * Example class about bidimensional LinearList
 * 
 * @author wilsonsoto
 * @since 18.09.17
 */
public class ExecutionBidimensional {
	
	public static void main(String[] args) {
		
		LinearList rows = new Chain();
		LinearList cols;
		
		Scanner in = new Scanner (System.in);
		
		int i = 0;
		String r="";
		while (!(r=in.nextLine()).equals("-1")) {

			String[] s = r.split(" ");
			cols = new Chain();
			for (int j = 0; j < s.length; j++) 
				cols.add(j, Integer.parseInt(s[j]));
			
			rows.add(i, cols);
			i++;
		}
		
		for (int idx = 0; idx < rows.size(); idx++) {
			cols = (LinearList) rows.get(idx);
			System.out.println(cols.toString());
		}

		int x = Integer.parseInt(in.next());
		int y = Integer.parseInt(in.next());
		cols = (LinearList) rows.get(x);
		System.out.println("pos ("+x+","+y+") : "+(int) cols.get(y));
		cols.set(y, -1);
		
		for (int idx = 0; idx < rows.size(); idx++) {
			cols = (LinearList) rows.get(idx);
			System.out.println(cols.toString());
		}
		
		in.close();
			
	}	

}
