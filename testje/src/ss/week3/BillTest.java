package ss.week3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	private Bill bill;

	@Before
	public void setUp() throws Exception {
		bill = new Bill(System.out);
	}

	@Test
	public void test(){
		assertTrue(bill.getSum() == 0.00);
		bill.newItem(new Item("Coffee", 5.34));
		assertTrue(bill.getSum() == 5.34);
		bill.newItem(new Item("Car", 50000.00));
		bill.newItem(new Item("Hat", 9.99));
		bill.close();
		
		System.out.println("");
		bill.printLine("testPrint");
	}
}
