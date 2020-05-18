package Several;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Uva10107 {
	
	public static void main (String[] args) {

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int tests;
			List<Integer> A = new LinkedList<>();
			List<Integer> l = new LinkedList<>();
			
			do {
				tests = Integer.parseInt(br.readLine());
				
				A.add(tests);
				Collections.sort(A);
				
				if (A.size()%2==1) {
					l.add(A.get(A.size()/2));
				} else {
					l.add((A.get((A.size()/2)-1)+A.get(A.size()/2))/2);
				}
				
			} while(A.size()!=0);

			PrintStream ps = new PrintStream(System.out);
			for (Integer i : l)
				ps.println(i);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
		
	}

}
