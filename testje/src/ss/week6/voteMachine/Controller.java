package ss.week6.voteMachine;

public class Controller {
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
