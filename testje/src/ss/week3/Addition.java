package ss.week3;
/**
 * Class Addition
 * Implements OperatorWithIdentity
 * Adds two integers.
 * @author Noel
 *
 */
public class Addition implements OperatorWithIdentity {
	
	/**
	 * Constructor
	 */
	public Addition() {
	}
	
	/**
	 * Method operate
	 * returns the addition of two integers
	 * @param left - first integer
	 * @param right - second integer
	 * @return result of left + right
	 */
	public int operate (int left, int right){
		return left + right;
	}
	
	/**
	 * Method identity
	 * Returns the identity for the addition operator
	 * @return 0
	 */
	public int identity() {
		return 0;
	}
	
	
}
