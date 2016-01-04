package ss.week6.voteMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private static PartyList<String> parties;
	private static VoteList votes;
	
	public static void main(String[] args) {
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
		parties = new PartyList<String>();
		votes = new VoteList();
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	public void addVote(String party) {
		votes.addVote(party);
	}

}
