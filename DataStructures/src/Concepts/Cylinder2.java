package Concepts;

/**
 *
 * @author Wilson Soto
 */
public class Cylinder2 extends Circle2 {

    private double height;

    public Cylinder2() {
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param radius
     * @param heightValue 
     */
    public Cylinder2(int x, int y, double radius, double heightValue) {
        super(x, y, radius);
        setHeight(heightValue);
    }

    public void setHeight(double heightValue) {
        height = (heightValue < 0.0 ? 0.0 : heightValue);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 2 * super.getArea() + getCircumference() * getHeight();
    }

    public double getVolume() {
        return super.getArea() * getHeight();
    }

    @Override
    public String getName() {
        return "Cylinder";
    }

    @Override
    public String toString() {
        return super.toString() + "; Height = " + getHeight();
    }

}
