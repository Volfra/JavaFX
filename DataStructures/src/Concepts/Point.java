package Concepts;

/**
 *
 * @author Wilson Soto
 * Reference Data Types
 */
class Point {

    private int x, y;

    public Point() {
        x = y = 0;
    }
    
    /**
     * 
     * @param dx
     * @param dy 
     */
    public Point(int dx, int dy) {
        x = dx;
        y = dy;
    }
    
    /**
     * 
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
