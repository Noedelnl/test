package ss.week2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SafeTest {
	private Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe();
	}

	@Test
	public void testActivate() {
		assertFalse(safe.isActive());
		assertFalse(safe.activate("test"));
		assertFalse(safe.isActive());
		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.isActive());
	}
	
	@Test
	public void testDeactivate() {
		assertFalse(safe.isActive());
		safe.getPassword();
		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.isActive());
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	
	@Test
	public void testOpen() {
		assertFalse(safe.isOpen());
		assertFalse(safe.open("test"));
		assertFalse(safe.isOpen());
		safe.getPassword();
		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.open(Password.INITIAL));
		assertTrue(safe.isOpen());
	}
	
	@Test
	public void testClose() {
		assertFalse(safe.isOpen());
		safe.getPassword();
		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.open(Password.INITIAL));
		assertTrue(safe.isOpen());
		safe.close();
		assertFalse(safe.isOpen());
	}

}
