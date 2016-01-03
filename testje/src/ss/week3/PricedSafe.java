package ss.week3;

/**
 * Class PricedSafe
 * Extends Safe, Implements Bill.Item
 * Gives a safe a price
 * @author saulv
 *
 */
public class PricedSafe extends Safe implements Bill.Item {
	private double price;
	
	/**
	 * Constructor
	 * @param newPrice	(price of the safe)
	 */
	public PricedSafe(double newPrice){
		super();
		price = newPrice;
	}
	
	/**
	 * Returns the price of a safe
	 */
	@Override
	public double getAmount(){
		return price;
	}
	
	/**
	 * Returns null, a safe doesn't have a name
	 */
	@Override
	public String getName(){
		return null;
	}
	
	/**
	 * Gives a String-representation of a priced safe
	 */
	public String toString(){
		return "PricedSafe, cost: " + price;
	}
}
