package ss.week6;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Please enter your name.");
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String name = in.nextLine();
			if(name.equals("")){
				break;
			}
			System.out.printf("Hello %s", name);
			System.out.println();
		}
		in.close();

	}

}
