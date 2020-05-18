/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.*;

/**
 * 
 * @author wilsonsoto
 *
 */
public class BankQueue {

    public static void main(String[] args) throws InterruptedException {

        Random rnd = new Random();

        int val = 5;

        Queue<Object> x = new LinkedList<Object>();

        for (int i = 0; i < val; i++) {
            x.add(i);
        }
        int total = 0;
        int time = 0;
        for (Iterator<Object> s = x.iterator(); s.hasNext();) {
            {
                time = rnd.nextInt(1000);
                Thread.sleep(time);
                total = total + time;

                System.out.println("The client " + x.remove() + " waste " + total + " Miliseconds");
            }

            System.out.println(" " + x.peek());
        }
    }
}
