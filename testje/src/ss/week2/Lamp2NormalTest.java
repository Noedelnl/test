package ss.week2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lamp2NormalTest {
	private Lamp2Normal lamp;
	
	@Before
	public void setUp() throws Exception {
		 lamp = new Lamp2Normal();
	}
	
	@Test
	public void testsetSetting(){
		assertEquals(0, lamp.getSetting());
		lamp.setSetting(2);
		assertEquals(2, lamp.getSetting());
		lamp.setSetting(5);
		assertEquals(1, lamp.getSetting());
		lamp.setSetting(0);
		assertEquals(0, lamp.getSetting());
		lamp.setSetting(400);
		assertEquals(0, lamp.getSetting());
	}
	
	@Test
	public void testincSetting(){
		lamp.setSetting(0);
		assertEquals(0, lamp.getSetting());
		lamp.incSetting();
		assertEquals(1, lamp.getSetting());
		lamp.incSetting();
		assertEquals(2, lamp.getSetting());
		lamp.incSetting();
		assertEquals(3, lamp.getSetting());
		lamp.incSetting();
		assertEquals(3, lamp.getSetting());
	}
	
	@Test
	public void testdecSetting(){
		lamp.setSetting(3);
		assertEquals(3, lamp.getSetting());
		lamp.decSetting();
		assertEquals(2, lamp.getSetting());
		lamp.decSetting();
		assertEquals(1, lamp.getSetting());
		lamp.decSetting();
		assertEquals(0, lamp.getSetting());
		lamp.decSetting();
		assertEquals(0, lamp.getSetting());
	}
}