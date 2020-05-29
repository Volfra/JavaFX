/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.*;

/**
 * 
 * @author wilsonsoto
 * @since 29.05.20
 */
public class BankPriorityQueue {

    public static void main(String[] args) {

    	System.out.println("***Data Structure Priority Queue***");
    	 
        PriorityQueue<Client> pq1 = new PriorityQueue<> ();
        pq1.add(new Client(4,"Vladimir","Putin",54,1.83));
        pq1.add(new Client(1,"Bart","Simpson",12,1.43));
        pq1.add(new Client(3,"Lionel","Messi",33,1.67));
        pq1.add(new Client(5,"Jeff","Bezos",51,1.89));
        pq1.add(new Client(2,"Angela","Merkel",52,1.56));
        System.out.println("\nAssist by age");
        while (!pq1.isEmpty()) {
        	System.out.println(pq1.remove());
        }
        
        SurnameClientCompare surnameclientCompare = new SurnameClientCompare();
        PriorityQueue<Client> pq2 = new PriorityQueue<> (surnameclientCompare);
        pq2.add(new Client(4,"Vladimir","Putin",54,1.83));
        pq2.add(new Client(1,"Bart","Simpson",12,1.43));
        pq2.add(new Client(3,"Lionel","Messi",33,1.67));
        pq2.add(new Client(5,"Jeff","Bezos",51,1.89));
        pq2.add(new Client(2,"Angela","Merkel",52,1.56));
        System.out.println("\nAssist by surname A-Z");
        while (!pq2.isEmpty()) {
        	System.out.println(pq2.remove());
        }

        TallClientCompare tallclientCompare = new TallClientCompare();
        PriorityQueue<Client> pq3 = new PriorityQueue<> (tallclientCompare);
        pq3.add(new Client(4,"Vladimir","Putin",54,1.83));
        pq3.add(new Client(1,"Bart","Simpson",12,1.43));
        pq3.add(new Client(3,"Lionel","Messi",33,1.67));
        pq3.add(new Client(5,"Jeff","Bezos",51,1.89));
        pq3.add(new Client(2,"Angela","Merkel",52,1.56));
        System.out.println("\nAssist by tall");
        while (!pq3.isEmpty()) {
        	System.out.println(pq3.remove());
        }
        
        NameClientCompare nameclientCompare = new NameClientCompare();
        PriorityQueue<Client> pq4 = new PriorityQueue<> (Collections.reverseOrder(nameclientCompare));
        pq4.add(new Client(4,"Vladimir","Putin",54,1.83));
        pq4.add(new Client(1,"Bart","Simpson",12,1.43));
        pq4.add(new Client(3,"Lionel","Messi",33,1.67));
        pq4.add(new Client(5,"Jeff","Bezos",51,1.89));
        pq4.add(new Client(2,"Angela","Merkel",52,1.56));
        System.out.println("\nAssist by name Z-A");
        while (!pq4.isEmpty()) {
        	System.out.println(pq4.remove());
        }
        
    }
}
