package Concepts;

/**
 *
 * @author Wilson Soto
 */
public class PolymorphismTest {

    /**
     * 
     * @param arr
     * @return double
     */
    public static double totalArea(Shape2[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++)          
            if (arr[ i] != null)
                total += arr[ i].getArea();
        return total;
     }
    
    /**
     * 
     * @param arr 
     */
    public static void printAll(Shape2[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != null)
                System.out.println(arr[i].getName() + ": " + arr[i].toString() + 
                                        "\nArea=" + arr[i].getArea() + 
                                        "\nVolume = " + arr[i].getVolume() + "\n");
    }
   
    public static void main(String args[]) {
        Shape2[] a = {new Point2(7, 11), new Circle2(22, 8, 3.5), null, new Cylinder2(20, 30, 3.3, 10.75)};
        printAll(a);
        System.out.println ("Total area="+totalArea( a ));
    }

}
