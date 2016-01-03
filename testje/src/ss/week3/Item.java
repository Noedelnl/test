package ss.week3;

/**
 * Class Item
 * Implements the interface given in class Bill
 * @author saulv
 *
 */
public class Item implements Bill.Item {
	private double amount;
	private String name;
	
	/**
	 * Constructor
	 * @param newName	Name of the item
	 * @param newAmount	Price of the item
	 */
	public Item(String newName, double newAmount){
		name = newName;
		amount = newAmount;
	}
	
	/**
	 * Gives the price of the item
	 */
	public double getAmount() { 
		return amount;
	}
	
	/**
	 * Gives the name of an item
	 */
	public String getName() {
		return name;
	}
}
