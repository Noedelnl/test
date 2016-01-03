package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void addVote(String party) {
		if (map.get(party) == null) {
			map.put(party, 1);
		}
		else {
			map.put(party, (map.get(party) + 1));
		}
	}
	
	public Map<String, Integer> getVotes() {
		return map;
	}

}
