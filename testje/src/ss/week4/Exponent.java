package ss.week4;

/**
 * Class Exponent.
 * Implements Function
 * An exponential function that is able to be applied and differentiated.
 * @author Saul
 *
 */
public class Exponent implements Function, Integrandable {
	private int power;
	
	/**
	 * Constructor.
	 * @param inputPower
	 */
	public Exponent(int inputPower) {
		power = inputPower;
	}
	
	/**
	 * Method apply.
	 * Applies the function to a double.
	 */
	@Override
	public double apply(double number) {
		return Math.pow(number, (double) power);
	}
	
	/**
	 * Method getPower.
	 * @return power of the exponent
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Method derivative.
	 * @return the derivative of this Exponent.
	 */
	@Override
	public LinearProduct derivative() {
		return new LinearProduct(new Constant((double) power), new Exponent(power - 1));
	}
	
	/**
	 * Method integrand.
	 * Returns the integrand of this Exponent.
	 * @return
	 */
	public LinearProduct integrand() {
		return new LinearProduct(new Constant(1.0 / (power + 1)), new Exponent(power + 1));
	}
	
	/**
	 * Method toString.
	 * @return the String representation of an Exponent
	 */
	public String toString() {
		return "x^" + Integer.toString(power);
	}

}
