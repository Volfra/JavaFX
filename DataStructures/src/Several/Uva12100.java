package Several;

import java.io.*;
import java.util.*;

class Uva12100 {	

	public static void main (String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			List<Integer> l = new LinkedList<>();
			
			int tests = Integer.parseInt(br.readLine());
			int k=0;
			
			while (tests>k) {
			
				String[] data1 = br.readLine().split(" ");
				String[] data2 = br.readLine().split(" ");
				
				l.add(Uva12100.algorithm(data1, data2));
				
				k++;
			
			}
			
			PrintStream ps = new PrintStream(System.out);
			for (Integer i : l)
				ps.println(i);

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
		
	}
	
	static int algorithm (String[] data1, String[] data2) throws Exception {
		
		Exception e1 = new Exception ("Numero de trabajos fuera del rango");
		Exception e2 = new Exception ("Numero de su trabajo fuera del rango");
		Exception e3 = new Exception ("Cantidad de prioridades no es igual al numero trabajos");
		Exception e4 = new Exception ("Numero de prioridad fuera del rango");
		
		int njobs=0, myjob=0, print=0;
		
		if (Integer.parseInt(data1[0])>0 && Integer.parseInt(data1[0])<101)
			njobs = Integer.parseInt(data1[0]);
		else
			throw e1;
			
		if (Integer.parseInt(data1[1])>=0 && Integer.parseInt(data1[1])<=njobs-1)
			myjob = Integer.parseInt(data1[1]);
		else
			throw e2;

		if (data2.length!=njobs) throw e3;

		PriorityQueue <Integer> q1 = new PriorityQueue<>(njobs,Collections.reverseOrder());
		Queue <Integer> q2 = new LinkedList<>();
				
		for (int i=0; i<data2.length; i++)
			if (Integer.parseInt(data2[i])>=0 && Integer.parseInt(data2[i])<=9) {
				q1.add(Integer.parseInt(data2[i]));
				q2.add(Integer.parseInt(data2[i]));
			}
			else
				throw e4;

		while (myjob>-1) {
		
			while (q1.peek()>q2.peek()) {
	
				q2.add(q2.poll());
				if (myjob==0) 
					myjob=q2.size()-1;
				else 
					myjob--;
				
			}
			
			q1.poll();
			q2.poll();
			print++;
			myjob--;
			if (q1.isEmpty()||myjob==-1) break;
		
		}

		return print;
		
	}

}