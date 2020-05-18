package Queue;

import java.util.Scanner;

public class Execution {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String structure = "";

		System.out.println("(A)rrayQueue - (L)inkedQueue");
		char op = input.next().charAt(0);
		if (op == 'A')
			structure = "ArrayQueue";
		if (op == 'L')
			structure = "LinkedQueue";

		structure = "Queue." + structure;

		Queue q;

		try {
			q = (Queue) Class.forName(structure).newInstance();

			q.put(new Integer(1));
			q.put(new Integer(2));
			q.put(new Integer(3));
			q.put(new Integer(4));

			while (!q.isEmpty()) {
				System.out.println("Rear element is " + q.getRearElement());
				System.out.println("Front element is " + q.getFrontElement());
				System.out.println("Removed the element " + q.remove());
			}

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

		input.close();

	}
}
