package ss.week4;

/** 
 * Interface function.
 * Interface for applying a function, getting the derivative or printing the function
 * @author Saul
 *
 */
public interface Function {
	
	/**
	 * Method apply.
	 * Applies the function to a given number.
	 * @param value, value to apply function to
	 * @return returns the result of applying a function to a value
	 */
	public double apply(double number);
	
	/**
	 * Method derivative.
	 * Returns the derivative of the given Function.
	 * @param function, function to differentiate
	 * @return returns the derivative of given function
	 */
	public Function derivative();
	
	/**
	 * method toString.
	 * Returns a string representation of the function.
	 * @return String
	 */
	public String toString();

}
