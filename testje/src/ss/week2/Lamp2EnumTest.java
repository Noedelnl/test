package ss.week2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Lamp2Enum.Setting;

public class Lamp2EnumTest {
	private Lamp2Enum lamp;
	
	@Before
	public void setUp() throws Exception {
		 lamp = new Lamp2Enum();
	}
	
	@Test
	public void testincSetting(){
		assertEquals(Setting.OFF, lamp.getSetting());
		lamp.incSetting();
		assertEquals(Setting.LOW, lamp.getSetting());
		lamp.incSetting();
		assertEquals(Setting.MEDIUM, lamp.getSetting());
		lamp.incSetting();
		assertEquals(Setting.HIGH, lamp.getSetting());
		lamp.incSetting();
		assertEquals(Setting.HIGH, lamp.getSetting());
	}
	
	@Test
	public void testdecSetting(){
		for(int i = 0; i < 3; i++){
			lamp.incSetting();
		}
		assertEquals(Setting.HIGH, lamp.getSetting());
		lamp.decSetting();
		assertEquals(Setting.MEDIUM, lamp.getSetting());
		lamp.decSetting();
		assertEquals(Setting.LOW, lamp.getSetting());
		lamp.decSetting();
		assertEquals(Setting.OFF, lamp.getSetting());
		lamp.decSetting();
		assertEquals(Setting.OFF, lamp.getSetting());
	}
}
