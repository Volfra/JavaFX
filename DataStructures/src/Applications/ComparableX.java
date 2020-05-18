package Applications;

/**
 * 
 * CONCEPTS
 * <p
 * Java provides a comparison method that is imparted to a class by implementing
 * the java.lang.Comparable interface.
 * <p>
 * The Comparable interface is quite simple, it only has a single method called
 * compareTo( ).
 * <p>
 * The compareTo() method takes another Object as an argument, and produces a
 * negative value, zero, or a positive value if the current object is less than,
 * equal to, or greater than the argument, respectively.
 * <p>
 * Each algorithm describe here is passed an array containing the elements, and
 * only objects that implement the Comparable interface can be sorted.
 * <p>
 * 
 * @author wilsonsoto
 * @since 20.09.15
 * 
 */

public abstract class ComparableX implements Comparable {
	public abstract double area();

	public abstract double perimeter();

	public int compareTo(Object rhs) {

		ComparableX other = (ComparableX) rhs;
		double diff = area() - other.area();
		if (diff == 0)
			return 0;
		else if (diff < 0)
			return -1;
		else
			return 1;
	}

	public double semiperimeter() {
		return perimeter() / 2;
	}

}
