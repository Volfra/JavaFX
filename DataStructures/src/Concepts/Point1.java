package Concepts;

/**
 *
 * @author Wilson Soto
 */
public class Point1 extends Shape1 {

    private int x;
    private int y;

    public Point1() {
    }
    
    /**
     * 
     * @param xValue
     * @param yValue 
     */
    public Point1(int xValue, int yValue) {
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

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }
}