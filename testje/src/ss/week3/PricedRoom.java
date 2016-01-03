package ss.week3;

/**
 * Class PricedRoom
 * Extends Room, Implements Bill.Item
 * Adds a price to a room and introduces a priced safe instead of a normal one
 * @author saulv
 *
 */
public class PricedRoom extends Room implements Bill.Item{
	private double roomPrice;
	private PricedSafe pricedSafe;
	
	/**
	 * Constructor
	 * @param roomnumber
	 * @param newRoomPrice
	 * @param safePrice
	 */
	public PricedRoom(int roomnumber, double newRoomPrice, double safePrice){
		super(roomnumber);
		roomPrice = newRoomPrice;
		pricedSafe = new PricedSafe(safePrice);
		
	}
	
	/**
	 * Returns the price of the room
	 */
	@Override
	public double getAmount(){
		return roomPrice;
	}
	
	/**
	 * Gives a String-representation of a String
	 */
	public String toString(){
		return "Priced room, cost per night: " + roomPrice;
	}
	
	/**
	 * Returns null, a room doesn't have a name
	 */
	@Override
	public String getName(){
		return null;
	}
}
