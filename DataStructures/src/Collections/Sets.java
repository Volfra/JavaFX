package Collections;

import java.util.*;

public class Sets {
    
    public static void main (String[] args) {
        
        Set<String> conjunto1 = new HashSet<String>();
        conjunto1.add("Orange");
        conjunto1.add("Grape");
        conjunto1.add("Apple");
        Set<String> conjunto2 = new HashSet<String>();
        conjunto2.add("Orange");
        conjunto2.add("Strawberry");
        conjunto2.add("Pear");
        conjunto2.add("Pear");
        
        System.out.println(conjunto2.contains("Orange"));
        
        System.out.println(conjunto1);
        System.out.println(conjunto2);
        
        conjunto1.addAll(conjunto2);
        System.out.println(conjunto1);
        System.out.println(conjunto2);
        
        conjunto1.retainAll(conjunto2);
        System.out.println(conjunto1);
        System.out.println(conjunto2);
        
        conjunto1.removeAll(conjunto2);
        System.out.println(conjunto1);
        System.out.println(conjunto2);
        
    }
    
}
