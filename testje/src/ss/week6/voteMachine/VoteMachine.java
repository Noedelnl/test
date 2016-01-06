package ss.week6.voteMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

/**
 * Controller for the votemachine.
 * @author n
 *
 */
public class VoteMachine {
	private static PartyList<String> parties;
	private static VoteList votes;
	private static VoteMachine voteMachine;
	private static VoteView view;
	
	/**
	 * Constructor, initializes the model and view, and starts the program.
	 */
	public VoteMachine() {
		parties = new PartyList<String>();
		votes = new VoteList();
		view = new VoteGUIView(this);
		this.start();
	}
	
	/**
	 * Main method, creates a votemachine.
	 * @param args
	 */
	public static void main(String[] args) {
		voteMachine = new VoteMachine();
	}
	
	/**
	 * Adds observers to the lists and starts the voteview.
	 */
	public void start() {
		parties.addObserver(view);
		votes.addObserver(view);
		view.start();
	}
	
	/**
	 * Adds a party to the partylist.
	 * @param party
	 */
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	/**
	 * Adds a vote to the votelist.
	 * @param party
	 */
	public void vote(String party) {
		votes.addVote(party);
	}
	
	/**
	 * Returns list of parties.
	 * @return
	 */
	public List<String> getParties() {
		return parties.getParties();
	}
	
	/**
	 * returns map of votes.
	 * @return
	 */
	public Map<String, Integer> getVotes() {
		return votes.getVotes();
	}
}