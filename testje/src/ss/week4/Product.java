package ss.week4;

/**
 * Class Product.
 * Implements Function
 * Consists of the product of two functions.
 * Can be applied to a double and differentiated.
 * @author Saul
 *
 */
public class Product implements Function {
	Function first;
	Function second;
	
	/**
	 * Constructor.
	 * @param firstFunction 
	 * @param secondFunction
	 */
	public Product(Function firstFunction, Function secondFunction) {
		first = firstFunction;
		second = secondFunction;
	}
	
	/**
	 * Method apply.
	 * applies the Product to a double.
	 */
	public double apply(double number) {
		return first.apply(number) * second.apply(number);
	}
	
	/**
	 * Method derivative.
	 * returns the derivative of the Product.
	 */
	public Function derivative() {
		Product firstDeriv = new Product(first.derivative(), second);
		Product secondDeriv = new Product(first, second.derivative());
		return new Sum(firstDeriv, secondDeriv);
	}
	
	/**
	 * Method toString.
	 * @return the String representation of a product
	 */
	public String toString() {
		return first.toString() + " * " + second.toString();
	}
}
