package Several;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Uva Contest programming 
 * Exercise 10798
 *
 * @author wilsonsoto
 * @since 08.09.17
 */
public class Uva10798 {
	
	public static void main(String[] args) {
				
		Scanner in = new Scanner (System.in);
				
		while (true) {
		
			int n = Integer.parseInt(in.next());
			if (n==0) break;
		
			ArrayList<String> a = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				a.add(null);
			}
			
			int k=0,z=0;
			int pos=-1;
			int acum=0;
			for (int i = 0; i < n; i++) {
				
				String card = in.next();
				int jump = in.next().length();
				//System.out.println(card+" "+jump);
										
				acum+=jump;			
				for (k=z; k<acum; k++) {
					if (a.get(k%n)==null) {
						pos=k%n;
					} else
						acum++;
				}
				
				z=k;
				a.set(pos%n, card);
			}
			
			System.out.println(a);
		}
		
		in.close();
		
	}
	
}
