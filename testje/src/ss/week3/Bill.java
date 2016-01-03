package ss.week3;

import java.io.*;

/**
 * Class Bill
 * Defines a bill to which items can be added
 * @author saulv
 *
 */
public class Bill {
	private double sum;
	PrintStream printstream;
	
	/**
	 * Constructor
	 * The default sum is 0, uses a given PrintStream
	 * @param theOutStream
	 */
	public Bill(PrintStream theOutStream) {
		sum = 0;
		printstream = theOutStream;
	}
	
	/**
	 * Prints a String with the used PrintStream
	 * @param The String
	 */
	public void printLine(String text) {
		printstream.println(text);
	}
	
	/**
	 * Interface Item
	 * Sets the requirements for Items
	 * @author saulv
	 *
	 */
	public static interface Item {
		public double getAmount();
		public String getName();
	}
	
	/**
	 * Adds an item to the bill, with the item name and price, using a particular formatting
	 * @param item
	 */
	public void newItem(Bill.Item item){
	    printstream.println(Format.printLine(item.getName(), item.getAmount()));
	    sum = sum + item.getAmount();
	}
	
	/**
	 * Closes the bill by adding a total with the sum of all items
	 */
	public void close() {
		printstream.println(Format.printLine("total: ", sum));
	}
	
	/**
	 * Returns the current sum
	 * @return the current sum
	 */
	public double getSum(){
		return sum;
	}

}
