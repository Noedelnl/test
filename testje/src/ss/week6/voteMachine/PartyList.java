package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

import ss.week4.DoublyLinkedList.Node;

public class PartyList<Element> {
	ArrayList myList = new ArrayList();
	
	public void addParty(String party) {
		myList.add(party);
	}
	
	public boolean hasParty(String party) {
		return myList.contains(party);
	}
	
	public ArrayList getParties() {
		return myList;
	}

}