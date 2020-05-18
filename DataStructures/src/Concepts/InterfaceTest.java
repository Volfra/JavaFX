package Concepts;

/**
 *
 * @author Wilson Soto
 */
import java.text.DecimalFormat;

public class InterfaceTest {

    public static void main(String args[]) {
        
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        Shape2 a[] = {new Point2(7, 11),new Circle2(22, 8, 3.5),new Cylinder2(20, 30, 3.3, 10.75)};

        for ( int i = 0; i< a.length ; i++ ) {
            System.out.println(a[i].getName() + ": " + a[i].toString() + 
                    "\nArea=" + twoDigits.format(a[i].getArea()) + 
                    "\nVolume = " + twoDigits.format(a[i].getVolume()));
        
        System.out.println();
        }
    }
}
