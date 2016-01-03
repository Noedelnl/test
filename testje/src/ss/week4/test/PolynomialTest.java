package ss.week4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week4.Constant;
import ss.week4.Exponent;
import ss.week4.LinearProduct;
import ss.week4.Polynomial;

public class PolynomialTest {
	Polynomial polynomial;
	double[] constants = {2.0, 4.0, 6.0};
	double[] powers = {3.0, 1.0, 0.0};
	
	@Before
	public void setUp() throws Exception {
		polynomial = new Polynomial(constants, powers);
	}

	@Test
	public void testConstructor() {
		assertTrue(polynomial.getIndex(1) instanceof LinearProduct);
		assertTrue(polynomial.getIndex(1).getConstant() instanceof Constant);
		assertTrue(polynomial.getIndex(1).getConstant().apply(0) == 4.0);
		assertTrue(polynomial.getIndex(1).getFunction() instanceof Exponent);
		assertTrue(((Exponent) polynomial.getIndex(1).getFunction()).getPower() == 1.0);
	}
	
	@Test
	public void testApply() {
		assertTrue(polynomial.apply(2.0) == 30.0);
	}
	
	@Test
	public void testDerivative() {
		double[] derivConst = { 6.0, 4.0, 0.0 };
		double[] derivPwrs = { 2.0, 0.0, 0.0 };
		assertTrue(new Polynomial(derivConst, derivPwrs).equals(polynomial.derivative()));
	}
	
	@Test
	public void testIntegrand() {
		double[] intConst = { 0.5, 2.0, 6.0 };
		double[] intPwrs = { 4.0, 2.0, 1.0 };
		assertTrue(new Polynomial(intConst, intPwrs).equals(polynomial.integrand()));
	}
}
