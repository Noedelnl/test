package ss.week3;

import org.junit.Test;

public class FormatTest {

	@Test
	public void test() {
		Format.printLine("helloooo", 10.03);
		Format.printLine("lloooo", 100.03);
		Format.printLine("oo", 1000.03);
		Format.printLine("ooo", 1.03);
		Format.printLine("helloooo", -1.03);
		Format.printLine("helloooo", 0.03);
	}

}
