package ss.week3;

/**
 * Class Multiplication
 * Implements OperatorWithIdentity
 * Multiplies 2 given integers
 * @author saulv
 *
 */
public class Multiplication implements OperatorWithIdentity{
	
	/**
	 * Constructor
	 */
	public Multiplication() {
	}
	
	/**
	 * Method operate
	 * returns the multiplication of two integers
	 * @param left - first integer
	 * @param right - second integer
	 * @return result of left * right
	 */
	public int operate (int left, int right){
		return left * right;
	}
	
	/**
	 * Method identity
	 * Returns the identity for the multiplication operator
	 * @return 1
	 */
	public int identity() {
		return 1;
	}
	
	
}
