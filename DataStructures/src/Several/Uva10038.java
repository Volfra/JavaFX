package Several;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Uva10038 {

	public static void main(String[] args){

		BufferedReader numero = new BufferedReader(new InputStreamReader(System.in));
		String numbers = null;
		List<String> l = new LinkedList<>();
		PrintStream ps = new PrintStream(System.out);
		
		try {

			while ((numbers = numero.readLine()) != null) {

				StringTokenizer tokenizer = new StringTokenizer(numbers.trim());

				if (!numbers.equals("")) {
					
					List<Integer> x = new LinkedList<Integer>(); 

					int idx = 0;
					while (tokenizer.hasMoreTokens()) {
						int val = Integer.parseInt(tokenizer.nextToken());
						x.add(idx, val);
						idx++;
					}

					int n = (int) x.remove(0);

					boolean jolly = true;

					for (int i = 0; i < x.size() - 1; i++) {
						if (n - 1 - i != Math.abs(((int) x.get(i) - ((int) x.get(i + 1))))) {
							jolly = false;
						}
					}

					if (jolly)
						l.add("Jolly");
					else
						l.add("Not Jolly");

				} else
					break;
			}

			for (String i : l)
				ps.println(i);

			numero.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.exit(0);
		
	}

}
