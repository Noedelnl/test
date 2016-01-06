package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * List containing all votes made.
 * @author n
 *
 */
public class VoteList extends Observable {
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	/**
	 * Adds vote for specific party.
	 * @param party
	 */
	public void addVote(String party) {
		if (map.get(party) == null) {
			map.put(party, 1);
		}
		else {
			map.put(party, (map.get(party) + 1));
		}
		setChanged();
		notifyObservers("vote");
	}
	
	/**
	 * Returns map containing all votes.
	 * @return
	 */
	public Map<String, Integer> getVotes() {
		return map;
	}

}
