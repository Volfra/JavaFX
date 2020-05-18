package Stack;

import java.util.Scanner;

public class Execution {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String structure = "";

		System.out.println("(A)rrayStack - (L)inkedStack");
		char op = input.next().charAt(0);
		if (op == 'A')
			structure = "ArrayStack";
		if (op == 'L')
			structure = "LinkedStack";

		structure = "Stack." + structure;

		Stack s;

		try {
			s = (Stack) Class.forName(structure).newInstance();

			s.push(new Integer(8));
			s.push(new Integer(1));
			s.push(new Integer(2));
			s.push(new Integer(3));

			while (!s.empty())
				System.out.println(s.pop());

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

		input.close();
	}
}
