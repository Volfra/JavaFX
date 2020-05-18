package Concepts;

/**
 *
 * @author Wilson Soto
 */
public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
        day = 1;
        month = 1;
        year = 1900;
    }

    /**
     * 
     * @param theDay
     * @param theMonth
     * @param theYear 
     */
    public Date(int theDay, int theMonth, int theYear) {
        day = theDay;
        month = theMonth;
        year = theYear;
    } 
    
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(27, 1, 2003);
        System.out.println("date1=" + date1); // 1/1/1900
        System.out.println("date2=" + date2); // 27/1/2003
    }
    
}