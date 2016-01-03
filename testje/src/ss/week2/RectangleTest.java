package ss.week2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void test() {
		Rectangle rectangle = new Rectangle(10, 20);
		assertEquals(10, rectangle.length());
		assertEquals(20, rectangle.width());
		assertEquals(10*20, rectangle.area());
		assertEquals(60, rectangle.perimeter());
	}

}
