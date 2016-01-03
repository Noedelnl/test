package ss.week1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LampTest {

	@Test
	public void test() {
		Lamp lamp = new Lamp();
		assertEquals(0, lamp.getSetting());
		lamp.incSetting();
		assertEquals(1, lamp.getSetting());
		lamp.decSetting();
		assertEquals(0, lamp.getSetting());
		lamp.decSetting();
		assertEquals(0, lamp.getSetting());
		lamp.setSetting(3);
		assertEquals(3, lamp.getSetting());
		lamp.incSetting();
		assertEquals(3, lamp.getSetting());
		lamp.setSetting(5);
		assertEquals(1, lamp.getSetting());
	}

}
