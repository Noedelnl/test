package ss.week4;

/**
 * Class Homework.
 * Makes some formulas, derives and integrades them
 * @author saulv
 *
 */
public class Homework {
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		double[] constants = {2.0, 4.0, 6.0};
		double[] powers = {3.0, 1.0, 0.0};
		Exponent exponent1 = new Exponent(4);
		Exponent exponent2 = new Exponent(8);
		Sum sum = new Sum(exponent1, exponent2);
		Polynomial polynomial = new Polynomial(constants, powers);
		Product product = new Product(exponent1, exponent2);
		System.out.println("polynomial: " + polynomial.toString());
		System.out.println("derivative: " + polynomial.derivative().toString());
		System.out.println("integrand: " + polynomial.integrand().toString() + "\n");
		System.out.println("product: " + product.toString());
		System.out.println("derivative: " + product.derivative().toString() + "\n");
		System.out.println("sum: " + sum.toString());
		System.out.println("derivative: " + sum.derivative().toString());
		System.out.println("integrand: " + sum.integrand().toString());
	}

}
