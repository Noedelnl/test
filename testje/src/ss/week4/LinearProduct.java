package ss.week4;

/**
 * Class LinearProduct.
 * Extends Product
 * @author Saul
 *
 */
public class LinearProduct extends Product {
	private Constant first;
	private Function second;
	
	/**
	 * Constructor.
	 * @param firstFunction Constant Function.
	 * @param secondFunction Any type of Function.
	 */
	public LinearProduct(Constant firstFunction, Function secondFunction) {
		super(firstFunction, secondFunction);
		first = firstFunction;
		second = secondFunction;
	}
	
	/**
	 * Method apply.
	 * Applies the function on a number.
	 * @param number
	 */
	public double apply(double number) {
		return first.apply(number) * second.apply(number);
	}
	
	/**
	 * Method derivative.
	 * @return the derivative of the LinearProduct.
	 */
	public LinearProduct derivative() {
		return new LinearProduct(first, second.derivative());
	}
	
	/**
	 * Method getConstant.
	 * @return Constant 
	 */
	public Constant getConstant() {
		return first;
	}
	
	/**
	 * Method getFunction.
	 * @return Function
	 */
	public Function getFunction() {
		return second;
	}
	
	/**
	 * Method toString.
	 * @return the String representation of a LinearProduct
	 */
	public String toString() {
		return first.toString() + "*" + second.toString();
	}
}
