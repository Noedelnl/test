package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VoteTUIView {
	
	public VoteTUIView() {
		
	}

	private Boolean exit = false;
	public void start() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please input commands.");
		while (exit = false) {
			while(in.hasNextLine()) {
				String input = in.nextLine();
				Scanner read = new Scanner(input);
				if (read.hasNext()) {
					String firstword = read.next();
					if (firstword.equals("VOTE")) {
						String party = read.next();
					}
					else if (firstword.equals("VOTES")) {
						
					}
					else if (firstword.equals("PARTIES")) {
						
					}
					else if (firstword.equals("EXIT")) {
						
					}
					else if (firstword.equals("HELP")) {
						
					}
					else if (firstword.equals("ADD")) {
						if (read.next().equals("PARTY")) {
						}
						else {
							
						}
					}
					else {
						System.out.println("Please input correct command.");
					}
				}
			}
			
		}
	}
	
	public void showVotes(Map<String, Integer> map) {
		System.out.println(map.toString());
	}
	
	public void showParties(List<String> list) {
		System.out.println(list.toString());
	}
	
	public void showError(String string) {
		System.out.println(string);
	}

}
