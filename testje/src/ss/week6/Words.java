package ss.week6;

import java.util.Scanner;

public class Words {

	public static void main(String[] args) {
		System.out.println("please enter a sentence, consisting of words seperated by spaces");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String input = in.nextLine();
			Scanner read = new Scanner(input);
			int i = 1;
			if (read.hasNext()) {
				String firstWord = read.next();
				if (firstWord.equals("end") || firstWord.equals("End")) { 
					System.out.println("end");
					break;
				} else {
					System.out.printf("Word %d: %s", i, firstWord);
					System.out.println();	
					i++;
				while(read.hasNext()) {
					System.out.printf("Word %d: %s", i, read.next());
					System.out.println();
					i++;
				}
				}
			}
			read.close();
		}
		in.close();
		System.out.println("End of programme");
	}

}
