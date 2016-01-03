package ss.week3;

/**
 * Class Format
 * Sets a certain format, used for formatting items
 * @author saulv
 *
 */
public class Format {
	
	/**
	 * Constructor
	 */
	public Format(){
		
	}
	
	/**
	 * Returns a properly formatted String
	 * @param text (name of the item)
	 * @param amount (price of the item)
	 * @return the resulting String
	 */
	public static String printLine(String text, double amount){
		String printer = String.format("%-15s %8.2f", text, amount);
		return printer;
	}

}
