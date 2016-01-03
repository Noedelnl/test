package ss.week3;

import java.io.PrintStream;

/**
 * Class Hotel
 * A Hotel can have a name and multiple rooms.
 * Rooms can either be available or unavailable.
 * @author Noel
 *
 */
public class Hotel {
	private /*@non_null@*/ String name;
	private /*@non_null@*/ int available;
	private Room room1;
	private Room room2;
	
	/**
	 * Creates a <code>Hotel</code> with the given name and two new rooms.
	 * @param newName is the name of the <code>Hotel</code>.
	 */
	//@ requires newName != null;
	//@ ensures getName().equals(newName);
	public Hotel(String newName){
		assert newName != null;
		name = newName;
		available = 2;
		room1 = new Room(0);
		room2 = new Room(1);
	}
	
	/**
	 * Creates a Guest instance for the person checking in, then checks them into a room and returns the assigned room number.
	 * @param passw is the password for checking in
	 * @param newGuest is the name assigned to the new <code>Guest</code> instance that is created
	 * @return returns the guests room number.
	 */
	//@ requires newGuest != null && passw != null;
	//@ ensures getRoom(newGuest) == null ==> \result != null;
	//@ ensures getFreeRoom() != null && getRoom(newGuest) == null && getPassword().testWord(passw) ==> \result != null;
	//@ ensures !getPassword().testWord(passw) ==> \result == null;
	public Room checkIn(String passw, String newGuest){
		assert passw != null;
		assert newGuest != null;
		if(available == 0 || getRoom(newGuest) != null || !getPassword().testWord(passw)){
			return null;
		}
		else {
			Guest guest = new Guest(newGuest);
			getFreeRoom().setGuest(guest);
			available--;
			return getRoom(newGuest);
		}
	}
	/**
	 * The Guest is checked out and the safe in the room is deactivated.
	 * @param guest Guest instance to check out
	 * @return boolean that indicates if the checkout succeeded
	 */
	//@ensures getRoom(guest) == null;
	//@ensures !getRoom(guest).getSafe().isActive();
	public  boolean checkOut(/*@non_null@*/String guest){
		if(getRoom(guest) != null){
			getRoom(guest).getSafe().deactivate();
			getRoom(guest).setGuest(null);
			available++;
			return true;
		}
		return false;
	}
	/**
	 * Function to get a free room.
	 * @return Free Room if available, else returns null.
	 */
	//@pure;
	public Room getFreeRoom(){
		if(available == 0){
			return null;
		}
		else if(room1.getGuest() == null){
			return room1;
		}
		else {
			return room2;
		}
	}
	
	/**
	 * Returns the room of a certain guest.
	 * @param guest name assigned to a room.
	 * @return Room instance if guest is assigned to a room, else returns null.
	 */
	//@pure;
	public Room getRoom(String guest){
		if(room1.getGuest() != null && room1.getGuest().getName().equals(guest)){
			return room1;
		}
		else if (room2.getGuest() != null && room2.getGuest().getName().equals(guest)){
			return room2;
		}
		return null;
	}
	
	/**
	 * returns the password of a room
	 * @return password
	 */
	//@ pure;
	public Password getPassword(){
		return room1.getSafe().getPassword();
	}
	
	/**
	 * Produces a bill for a guest
	 * Sums up all their expenses in a bill
	 * @param guestName		Name of the Guest
	 * @param nightsAmount	Amount of nights the Guest has spent
	 * @param printstream	PrintStream to use
	 * @return	The Bill
	 */
	public Bill getBill(String guestName, int nightsAmount, PrintStream printstream){
		if(getRoom(guestName) != null || !(getRoom(guestName) instanceof PricedRoom)){
			Bill res = new Bill(printstream);
			res.newItem(new Item("Nights stayed: ", (nightsAmount * ((PricedRoom) getRoom(guestName)).getAmount())));
			if(getRoom(guestName).getSafe().isActive()){
				res.newItem(new Item("Activated Safe: ", ((PricedSafe) getRoom(guestName).getSafe()).getAmount()));
			}
			return res;
		}
		return null;
	}
	
	/**
	 * Returns a String with the hotel name and information about room occupation & safe usage.
	 * @return resulting string
	 */
	//@ pure;
	public String toString(){
		String res = "Hotel: " + name;
		if(room1.getGuest() == null){
			res += "\nRoom 1: FREE";
		}
		else {
			res += "\nRoom 1 Guest: " + room1.getGuest().getName() + "\n     Safe Activated: " + room1.getSafe().isActive() + ", Safe Open: " + room1.getSafe().isOpen();
		}
		if(room2.getGuest() == null){
			res += "\nRoom 2: FREE";
		}
		else {
			res += "\nRoom 2 Guest: " + room2.getGuest().getName() + "\n     Safe Activated: " + room2.getSafe().isActive() + ", Safe Open: " + room2.getSafe().isOpen();
		}
		return res + "\n";
	}
}
