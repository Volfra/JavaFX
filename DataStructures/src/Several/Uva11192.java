package Several;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

class Uva11192 {

	public static void main (String[] args) {

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] data1;
			List<String> l = new LinkedList<>();
		
			do {
			
				data1 = br.readLine().split("");
				
				if (data1[1].equals("0")) break;
			
				int ngroups = Integer.parseInt(data1[1]);
				if ((data1.length-3)%ngroups!=0) {
					System.out.println("Data error");
					System.exit(0);
				}
				
				int sizegroups = (data1.length-3)/ngroups;
				for (int i=3; i<data1.length; i+=sizegroups) {
					for (int j=i, k=1; j<(i+(sizegroups/2)); j++, k++) {
						String tmp = data1[j];
						data1[j] = data1[i+sizegroups-k];
						data1[i+sizegroups-k] = tmp;
					}
				}
				
				String str="";
				for (int i=3; i<data1.length; i++)
					str+=data1[i];
				l.add(str);					
				
			} while(data1.length>1);
		
			PrintStream ps = new PrintStream(System.out);
			for (String i : l)
				ps.println(i);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}
}
