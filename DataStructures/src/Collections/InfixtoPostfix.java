package Collections;

import java.util.Stack;

/**
 *
 * Convertir una expresion de notacion infija a posfija
 *
 * @author wilsonsoto
 *
 */
public class InfixtoPostfix {

    /**
     * Metodo de creacion de pilas
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        Stack<Character> a = new Stack<Character>();
        Stack<Character> p = new Stack<Character>();
        Stack<Character> s = new Stack<Character>();
      
        a.push(')');
        a.push(')');
        a.push(')');
        a.push('6');
        a.push('*');
        a.push('5');
        a.push('(');
        a.push('*');
        a.push(')');
        a.push('4');
        a.push('+');
        a.push('3');
        a.push('(');
        a.push('(');
        a.push('+');
        a.push('2');
        a.push('(');

        while (!a.empty()) {

            if (a.peek().equals('(')) {
                p.push(a.pop());
            } else {

                if (precedencia((Character) a.peek()) != -1) {

                    while (precedencia((Character) p.peek()) >= precedencia((Character) a.peek())) {
                        s.push(p.pop());
                    }

                    p.push(a.pop());

                } else {

                    if (a.peek().equals(')')) {

                        while (!p.peek().equals('(')) {
                            s.push(p.pop());
                        }

                        p.pop();
                        a.pop();

                    } else {
                        s.push(a.pop());
                    }

                }

            }

        }

        while (!s.empty()) {
            p.push(s.pop());
        }

        while (!p.empty()) {
            System.out.print(p.pop());
        }

    }

    /**
     * Determina la jerarquia del operador
     *
     * @param a Character
     * @return int
     */
    public static int precedencia(Character a) {

        switch (a.charValue()) {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            default:
                return -1;
        }

    }

}
