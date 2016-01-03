package ss.week5;

public interface Strategy {
	
	/**
	 * Returns the name of a strategy.
	 * @return
	 */
	public String getName();
	
	/**
	 * Returns the move a strategy provides.
	 * @param b - board to use
	 * @param m - mark to use
	 * @return move to make
	 */
	public int determineMove(Board b, Mark m);
	
}
