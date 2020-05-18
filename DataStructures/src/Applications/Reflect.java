package Applications;

import java.lang.reflect.Method;

public class Reflect {

    static int a;
    
    static Method x;
    
    static Method y;
    
    static Class<?>[] paramType = {int.class, double.class};
    
    static { 
        try {
            a=10;
            Class<Reflect> c = Reflect.class;
            //c = Class.forName("edu.sergioarboleda.sistemas3.actividad5.model.Reflect");
            x = c.getMethod("method1", paramType);
            y = c.getMethod("method2");
        } catch (Exception ex) {
        }
    }

    public static void method1 (int i, double y) {
        System.out.println("La respuesta es: "+(i*y));
    }
    
    public Integer method2 () {
    	return 69;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(a);
            
            System.out.println(x.toString());
            x.invoke(null, 3, 2.0);
            
            Reflect d = new Reflect();
            System.out.println(y.invoke(d));
            
            System.out.println(a>0?"positivo":"negativo");
            
        } catch (Exception ex) {
        	System.out.println("Error reflection");
        }
        
    }
    
}
