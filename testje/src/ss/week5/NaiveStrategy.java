package ss.week5;

import java.util.*;

/**
 * Class NaiveStrategy.
 * Implements Strategy.
 * Relies on random numbers to determine a move.
 * @author saulv
 *
 */
public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while(b.isField(i)) {
			if(b.getField(i) == Mark.EMPTY) {
				list.add(i);
			}
			i++;
		}
		return list.get(Math.abs((int) System.nanoTime() % (list.size() - 1)));
	}
	
}
