package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	Game game = new Game(new HumanPlayer("Player 1", Mark.XX), new HumanPlayer("Player 2", Mark.OO));
    	game.start();
    }
}
