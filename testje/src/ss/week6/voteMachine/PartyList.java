package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ss.week4.DoublyLinkedList.Node;

/**
 * A list containing all parties
 * @author n
 *
 * @param <Element>
 */
public class PartyList<Element> extends Observable {
	List<String> myList = new ArrayList<>();
	
	/**
	 * Add a party to the partylist
	 * @param party
	 */
	public void addParty(String party) {
		myList.add(party);
		setChanged();
		notifyObservers("party");
	}
	
	/**
	 * Check if party exists in partylist
	 * @param party
	 * @return boolean
	 */
	public boolean hasParty(String party) {
		return myList.contains(party);
	}
	
	/**
	 * Returns list of parties
	 * @return
	 */
	public List<String> getParties() {
		return myList;
	}

}