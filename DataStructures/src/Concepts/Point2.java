package Concepts;

/**
 *
 * @author Wilson Soto
 */
public class Point2 extends Object implements Shape2 {

    private int x, y;

    public Point2() {
    }
    
    /**
     * 
     * @param xValue
     * @param yValue 
     */
    public Point2 (int xValue, int yValue) {
        x = xValue;
        y = yValue;
     }
    
    public void setX(int xValue) {
        x = xValue;
    }

    public int getX() {
        return x;
    }

    public void setY(int yValue) {
        y = yValue;
    }

    public int getY() {
        return y;
    }

    public double getArea() {
        return 0.0;
    }

    public double getVolume() {
        return 0.0;
    }

    public String getName() {
        return "Point";
    }

    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }

}
