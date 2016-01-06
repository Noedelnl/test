package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Provides textual user interface for the votemachine.
 * @author n
 *
 */
public class VoteTUIView implements Observer, VoteView {
	VoteMachine voteMachine;
	
	/**
	 * Constructor.
	 * @param voteMachine
	 */
	public VoteTUIView(VoteMachine voteMachine) {
		this.voteMachine = voteMachine;
	}

	/**
	 * Method to start the textual user interface, accepts textual commands and verifies execution of certain commands.
	 */
	public void start() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Please input commands.");
			String input = in.nextLine();
			Scanner read = new Scanner(input);
			if (read.hasNext()) {
				String firstword = read.next();
				if (firstword.equals("VOTE")) {
					String party = read.next();
					voteMachine.vote(party);
				}
				else if (firstword.equals("VOTES")) {
					this.showVotes(voteMachine.getVotes());
				}
				else if (firstword.equals("PARTIES")) {
					this.showParties(voteMachine.getParties());
				}
				else if (firstword.equals("EXIT")) {
					System.exit(0);
				}
				else if (firstword.equals("HELP")) {
					System.out.println("Commands: VOTE [party], VOTES, PARTIES, EXIT, ADD PARTY [party]");
				}
				else if (firstword.equals("ADD")) {
					if (read.next().equals("PARTY")) {
						String party = read.next();
						voteMachine.addParty(party);
					}
					else {
						System.out.println("incorrect command");
					}
				}
				else {
					System.out.println("Please input correct command.");
				}
			}
			
		}
	}
	
	/**
	 * Prints all current parties and the amount of votes they have.
	 */
	public void showVotes(Map<String, Integer> map) {
		System.out.println(map.toString());
	}
	
	/**
	 * Prints all current parties in the votemachine.
	 */
	public void showParties(List<String> list) {
		System.out.println(list.toString());
	}
	
	/**
	 * Prints error thrown by the votemachine.
	 */
	public void showError(String string) {
		System.out.println(string);
	}

	/**
	 * Prints output of the observable.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("party")) {
			System.out.println("party added");
		}
		else if (arg1.equals("vote")) {
			System.out.println("vote added");
		}
		
	}

}
