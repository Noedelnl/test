package ss.week4;

/**
 * Class Constant.
 * Implements Function
 * Implements Integrandable
 * A constant type function that can be differentiated, applied, and displayed as string.
 * @author Saul
 *
 */
public class Constant implements Function, Integrandable {
	private double value;
	
	/**
	 * Constructor.
	 * @param constant
	 */
	public Constant(double constant) {
		value = constant;
	}
	
	/**
	 * Method apply.
	 * Applies the function to a number, returns result.
	 * @return value.
	 */
	public double apply(double number) {
		return value;	
	}
	
	/**
	 * Method derivative.
	 * Returns the derivative of the current object.
	 */
	public Constant derivative() {
		return new Constant(0);
	}
	
	/**
	 * Method integrand.
	 * Returns the integral of the function.
	 */
	public Product integrand() {
		return new LinearProduct(this, new Exponent(1));  
	}
	
	/**
	 * Method toString.
	 * @return the String representation of a sum
	 */
	public String toString() {
		return Double.toString(value);
	}

}
