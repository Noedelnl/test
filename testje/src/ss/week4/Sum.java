package ss.week4;

/**
 * Class sum.
 * Implements Function
 * Implements Integrandable
 * Consists of the sum of two functions,
 * can be applied to a double, differentiated, and returned as a string.
 * @author Saul
 *
 */
public class Sum implements Function, Integrandable {
	Function first;
	Function second;
	
	/**
	 * Constructor.
	 * @param firstFunction 
	 * @param secondFunction
	 */
	public Sum(Function firstFunction, Function secondFunction) {
		first = firstFunction;
		second = secondFunction;
	}
	
	/**
	 * Method apply.
	 * applies the Sum to a double.
	 */
	public double apply(double numbers) {
		return first.apply(numbers) + second.apply(numbers);
	}
	
	/**
	 * Method derivative.
	 * returns the derivative of the sum.
	 */
	public Sum derivative() {
		return new Sum(first.derivative(), second.derivative());
	}
	
	/**
	 * Method integrand.
	 * Returns the integrand of a sum
	 * @return the integrand
	 */
	public Sum integrand() {
		if (first instanceof Integrandable && second instanceof Integrandable) {
			return new Sum(((Integrandable) first).integrand(), ((Integrandable) second).integrand());
		}
		return null;
	}
	
	/**
	 * Method toString.
	 * @return the String representation of a sum
	 */
	public String toString() {
		return first.toString() + " + " + second.toString();
	}
}
