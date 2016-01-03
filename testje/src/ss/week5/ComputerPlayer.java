package ss.week5;

/**
 * Class ComputerPlayer.
 * Extends Player.
 * Defines a basic AI which uses strategy to play TicTacToe.
 * @author saulv
 *
 */
public class ComputerPlayer extends Player {
	Strategy strat;
	Mark mark;
	
	/**
	 * Constructor 1.
	 * @param newMark - mark of the player
	 * @param newStrategy - strategy to use
	 */
	public ComputerPlayer(Mark newMark, Strategy newStrategy) {
		super(newStrategy.getName() + "-" + newMark, newMark);
		strat = newStrategy;
		mark = newMark;
	}
	
	/**
	 * Constructor 2.
	 * Uses the NaiveStrategy as default.
	 * @param newMark - mark to use
	 */
	public ComputerPlayer(Mark newMark) {
		super("Naive-" + newMark, newMark);
		strat = new NaiveStrategy();
		mark = newMark;
	}

	@Override
	public int determineMove(Board board) {
		return strat.determineMove(board, mark);
	}
}
