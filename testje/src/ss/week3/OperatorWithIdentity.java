package ss.week3;

/**
 * Interface OperatorWithIdentity
 * Sets requirements for Multiplication and Addition
 * @author saulv
 *
 */
public interface OperatorWithIdentity {
	
	/**
	 * Perform this operation with the specified operands.
	 */
	public int operate(int left, int right);
	
	/**
	 * The identity for this operator. For any int i,
	 * this.operate(this.identity, i) == i
	 * this.operate(i, this.identity) == i
	 */
	public int identity();

}
