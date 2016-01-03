package ss.week4;

/**
 * Class Polynomial.
 * Implements Function
 * Implements Integrandable
 * Polynomial Function that can be applied and differentiated.
 * @author Saul
 *
 */
public class Polynomial implements Function, Integrandable {
	private LinearProduct[] polynomial;
	
	/**
	 * Constructor.
	 * @param constants
	 * @param powers
	 */
	public Polynomial(double[] constants, double[] powers) {
		if (constants.length == powers.length) {
			polynomial = new LinearProduct[constants.length];
			for (int i = 0; i < constants.length; i++) {
				polynomial[i] = new LinearProduct(
								new Constant(constants[i]), new Exponent((int) powers[i]));
			}
		} else { 
			polynomial = null;
		}
	}
	
	/**
	 * Method getIndex.
	 * Return the LinearProduct of a polynomial at a certain index
	 * @param index
	 * @return LinearProduct
	 */
	public LinearProduct getIndex(int index){
		return polynomial[index];
	}
	
	/**
	 * Method getPolynomial.
	 * Returns the array of LineairProducts that make up the polynomial
	 * @return polynomial
	 */
	public LinearProduct[] getPolynomial() {
		return polynomial;
	}

	/**
	 * Method apply
	 * Applies the function to a double.
	 * @param number to apply function to.
	 * @return result of applying function to number.
	 */
	public double apply(double number) {
		double res = 0;
		for (int i = 0; i < polynomial.length; i++) {
			res = res + polynomial[i].apply(number);
		}
		return res;
	}

	/**
	 * Method derivative.
	 * Returns the derivative of the function.
	 * @return the derivative of the Polynomial.
	 */
	public Polynomial derivative() {
		double[] powers = new double[polynomial.length];
		double[] constants = new double[polynomial.length];
		for (int i = 0; i < polynomial.length; i++) {
			constants[i] = polynomial[i].getConstant().apply(0) * 
						   ((Exponent) polynomial[i].getFunction()).getPower();
			if (((Exponent) polynomial[i].getFunction()).getPower() == 0.0) {
				powers[i] = 0.0;
			} else {
				powers[i] = ((Exponent) polynomial[i].getFunction()).getPower() - 1;
			}
		}
		return new Polynomial(constants, powers);
	}
	
	/**
	 * Method integrand.
	 * Returns the integrand of the function.
	 * @return integrand of the Polynomial.
	 */
	public Polynomial integrand() {
		double[] powers = new double[polynomial.length];
		double[] constants = new double[polynomial.length];
		for (int i = 0; i < polynomial.length; i++) {
			constants[i] = polynomial[i].getConstant().apply(0) / 
						   (((Exponent) polynomial[i].getFunction()).getPower() + 1);
			powers[i] = ((Exponent) polynomial[i].getFunction()).getPower() + 1;
		}
		return new Polynomial(constants, powers);
	}
	
	/**
	 * Method equals.
	 * @return boolean saying whether or not two Polynomials are equal
	 */
	public boolean equals(Object other) {
		boolean res = false;
		if (other instanceof Polynomial) {
			Polynomial that = (Polynomial) other;
			if (this.getPolynomial().length == that.getPolynomial().length) {
				for (int i = 0; i < this.getPolynomial().length; i++) {
					if (this.getPolynomial()[i].getConstant().apply(1) == that.getPolynomial()[i].getConstant().apply(1) &&
							((Exponent) this.getPolynomial()[i].getFunction()).getPower() == ((Exponent) that.getPolynomial()[i].getFunction()).getPower()) {
						res = true;
					}
				}
			}
		}
		return res;
	}
	
	/**
	 * Method toString.
	 * @return the String representation of a sum
	 */
	public String toString() {
		String res = this.getPolynomial()[0].toString();
		for (int i = 1; i < this.getPolynomial().length; i++) {
			res += " + " + this.getPolynomial()[i].toString();
		}
		return res;
	}

}
