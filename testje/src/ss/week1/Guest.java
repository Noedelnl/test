package ss.week1;

/**
 * Class Guest
 * A guest had a name and can occupy a name
 * @author saulv
 */
public class Guest {
	String name;
	Room room;
	boolean checkedin;
	
	/**
	 * Constructor for class Guest
	 * By default, a guest has no room and is not yet checked in
	 * @param newName - The name of the guest
	 */
	public Guest(String newName){
		name = newName;
		room = null;
		checkedin = false;
	}
	
	/**
	 * Method getName
	 * Returns the name of the guest 
	 * @return name - The name of the guest
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Method getRoom
	 * Returns the room the guest occupies 
	 * @return room - The room of the guest
	 */
	public Room getRoom(){
		return room;		
	}
	
	/**
	 * Method checkin
	 * Checks if a guest is not yet checked in, if the given room is valid 
	 * and if the given name does not yet have an occupant.
	 * @param newRoom - The given room
	 * @return boolean, whether or not the checkin was successful
	 */
	public boolean checkin(Room newRoom){
		if(!checkedin && newRoom != null && newRoom.getGuest() == null){
			room = newRoom;
			checkedin = true;
			room.setGuest(this);
			return checkedin;
		}
		return false;		
	}
	
	/**
	 * Method checkout
	 * Checks a guest out of a room and makes the room available again,
	 * given that the guest was checked in in the first place. 
	 * @return boolean, whether or not the checkout was successful
	 */
	public boolean checkout(){
		if(checkedin){
			room.setGuest(null);
			room = null;
			checkedin = false;
			return true;
		}
		return false;
	}
	
	/**
	 * Method toString
	 * Provides a visual representation of a guest and his room
	 * @return String, the resulting String
	 */
	public String toString(){
		return "Guest: " + name + "\nRoom: " + room.getNumber() + "\n";
	}
}
