package ss.week5;

/**
 * Class SmartStrategy.
 * Implements Strategy.
 * SmartStrategy has advanced strategies, which rely on situational awareness.
 * @author saulv
 *
 */
public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		Board board = b.deepCopy();
		if(board.isEmptyField(board.getDimension() * board.getDimension())) {
			return board.getDimension() * board.getDimension();
		}
		else if(winningMove(b, m) != -1) {
			return winningMove(b, m);
		}
		else if(winningMove(b, m.other()) != -1) {
			return winningMove(b, m.other());
		}
		else {
			return new NaiveStrategy().determineMove(b, m);
		}
	}
	
	/**
	 * Determines whether or not a move can be made that would result in a win
	 * @param b - board to use
	 * @param m - mark to use
	 * @return move to make, -1 if no available moves would result in a win
	 */
	public int winningMove(Board b, Mark m) {
		int i = 0;
		while(b.isField(i)) {
			if(b.isEmptyField(i)) {
				Board board = b.deepCopy();
				board.setField(i, m);
				if(board.isWinner(m)) {
					return i;
				}
			}
			i++;
		}
		return -1;
	}
}
