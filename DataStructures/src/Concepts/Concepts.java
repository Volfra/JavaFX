package Concepts;

/**
 * 
 * 
 * 
 * <b>Object-Oriented Programming Concepts</b>
 * <br>
 * Object-oriented programming is a method of programming based on a 
 * hierarchy of classes, and well-defined and cooperating objects. 
 * <br>
 * <br>
 * <b>Primitive Data Types</b>
 * <br>
 * <br>
 * 
 * <table>
 *    <tbody>
 *       <tr>
*		<td>Type</td>
*		<td>Size(bits)</td>
*		<td>Range</td>
*		<td>Wrapper Type</td>
*	</tr>
*	<tr>
*		<td>byte</td>
*		<td>8</td>
*		<td>[-128,127]</td>
*		<td>Byte</td>
*	</tr>
*	<tr>
*		<td>short</td>
*		<td>16</td>
*		<td>[-32668,32767]</td>
*		<td>Short</td>
*	</tr>
*	<tr>
*		<td>int</td>
*		<td>32</td>
*		<td>[-2147483648, 2147483647]</td>
*		<td>Integer</td>
*	</tr>
*	<tr>
*		<td>long</td>
*		<td>64</td>
*		<td>±9.2e+17</td>
*		<td>Long</td>
*	</tr>
*	<tr>
*		<td>float</td>
*		<td>32</td>
*		<td>±1.4e-45 to ±3.4e+38</td>
*		<td>Float</td>
*	</tr>
*	<tr>
*		<td>double</td>
*		<td>64</td>
*		<td>±4.9e-324 to ±1.8e+308</td>
*		<td>Double</td>
*	</tr>
*	<tr>
*		<td>char</td>
*		<td>16</td>
*		<td>[\_u000, \_uFFFF]</td>
*		<td>Character</td>
*	</tr>
*	<tr>
*		<td>boolean</td>
*		<td>1</td>
*		<td>[true,false]</td>
*		<td>Boolean</td>
*	</tr>
*	<tr>
*		<td>void</td>
*		<td>--</td>
*		<td>--</td>
*		<td>Void</td>
*	</tr>
*      </tbody>
*    </table>
 *  
* 
 * <br>
 * In Java the format and size of primitive data types are not machine-dependent.
 * <br>
 * <br>
 * <b>Classes</b>
 * <br>
 * In the real world, you'll often find many individual objects all of the same kind.
 * A class is a blueprint or prototype from which objects are created.
 * A class is a structure that defines the data and the methods to work on that data.
 * <br>
 * <br>
 * <b>Objects</b>
 * <br>
 * Software objects are often used to model the real-world objects that you find in everyday life.
 * Real-world objects share two characteristics: They all have state and behavior.
 * An instance is an executable copy of a class. Another name for instance is object.
 * <br>
 * <br>
 * <b>Methods</b>
 * <br>
 * A method basically consists of:
 * <ul>
 * <li>access modifier (public, private, protected)</li>
 * <li>use modifier (static, final, abstract, native, synchronized)</li>
 * <li>return type</li>
 * <li>method name</li>
 * <li>list of parameters</li>
 * <li>body</li>
 * </ul>
 * <br>
 * <br>
 * access-modifier use-modifier return-type method-name(par1, par2, ...)
 * <br>
 * {
 * <br>
 * . . .
 * <br>
 * body-of-the-method;
 * <br>
 * . . .
 * <br>
 * }
 * <br>
 * <br>
 * <br>
 * <b>Method Overloading</b>
 * <br>
 * Simply, the same method name can be given several different definitions.
The number and types of arguments supplied to a method tell the
compiler which definition to use.
 * <br>
 * Example: 
 * <br>
 * int max( int a, int b, int c )
 * <br>
 * int max( int a, int b)
 * <br>
 * int max( float a, float b, float c)
 * <br>
 * int max( float a, float b)
 * <br>
 * 
 * The return type is NOT include in the signature. This means it is
 * illegal to have two methods whose only difference is the return type.
 * <br>
 * <br>
 * 
 * <b>Argument Promotion</b>
 * <br>
 * There is a hierarchy of types. Arguments can be promoted to “higher” types.
 * <br>
 * <table>
 *    <tbody>
 *       <tr>
*		<td>Type</td>
*		<td>Valid Promotions</td>
*	</tr>
*	<tr>
*		<td>double</td>
*		<td>None</td>
*	</tr>
*       <tr>
*		<td>float</td>
*		<td>double</td>
*	</tr>
*	<tr>
*		<td>long</td>
*		<td>float or double</td>
*	</tr>
*	<tr>
*		<td>int</td>
*		<td>long, float or double</td>
*	</tr>
*	<tr>
*		<td>char</td>
*		<td>int, long, float or double</td>
*	</tr>
*	<tr>
*		<td>short</td>
*		<td>char, int long, float or double</td>
*	</tr>
*	<tr>
*		<td>byte</td>
*		<td>short, char, int long, float or double</td>
*	</tr>
*	<tr>
*		<td>boolean</td>
*		<td>None</td>
*	</tr>
*   </tbody>
* </table>
 * 
 * <br>
 * <br>
 * 
 * <b>Casting</b>
 * <br>
 * The cast operator (type) is used to enable conversions that would normally be disallowed.
 * <br>
 * Example:
 * <br>
 * byte b;  
 * <br>
 * double d = 199.99;
 * <br>
 * b = d; // compile error
 * <br>
 * b = (byte) d; // compiles ok
 * <br>
 * <br>
 * 
 * <b>Inheritance</b>
 * <br>
 * In an object-oriented programming language, the fundamental mechanism for code reuse is inheritance.
 * Inheritance allows us to extend the functionality of an object.
 * <br>
 * <br>
 * Multiple Inheritance: In Multiple Inheritance, a class may be derived from more than one base class.
 * Java does not allow multiple inheritance!!!. However, Java provides an alternative known as the interface
 * <br>
 * <br>
 * 
 * <b>Abstract Methods & Classes</b>
 * <br>
 An abstract method has no meaningful definition and is thus always
 defined in the derived class.
 * <br>
 A class with at least one abstract method must be an abstract class
 Abstract classes are used only as superclasses in inheritance hierarchies.
 These classes can not be used to instantiate objects because they are
 incomplete.
 * <br>
 * Subclasses must declare the “missing pieces”.
 * <br>
 * Classes that can be used to instantiate objects are called concrete classes. 
 * Such classes provide implementation of every method they declare.
 * <br>
 * Constructors are not inherited, so they cannot be declared abstract
 * <br>
 * <br>
 * <b>Interfaces</b>
 * <br>
 * The interface is the ultimate abstract class. It consists of public abstract methods and 
 * public static final field, only.
 * <br>
 * A class is said to implement the interface if it provides definitions for all
 * of the abstract methods in the interface.
 * <br>
 * Implementing an interface is like signing a contract with the compiler
 * that states “I will declare all the methods specified by the interface”
 * <br>
 * <br>
 * 
 * <b>Polymorphism</b>
 * <br>
 * A polymorphic reference type can reference objects of several different
 * types. When methods are applied to the polymorphic type, the operation
 * that is appropriate to the actual referenced object is automatically selected.
 * <br>
 * <br>
 * 
 * @author Wilson Soto
 */
public class Concepts {
    
    
}

