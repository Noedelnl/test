package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	
    public static void main(String[] args) {
    	if(args.length >= 2) {
    		if(args[0].equals("-N") && args[1].equals("-S")) {
    			Game game = new Game(new ComputerPlayer(Mark.XX), new ComputerPlayer(Mark.OO, new SmartStrategy()));
	        	game.start();
    		}
    		else if(args[0].equals("-S") && args[1].equals("-N")) {
    			Game game = new Game(new ComputerPlayer(Mark.XX, new SmartStrategy()), new ComputerPlayer(Mark.OO));
	        	game.start();
    		}
    		else if(args[0].equals("-N")) {
    			Game game = new Game(new ComputerPlayer(Mark.XX), new HumanPlayer(args[1], Mark.OO));
	        	game.start();
    		}
    		else if(args[1].equals("-N")) {
    			Game game = new Game(new HumanPlayer(args[0], Mark.XX), new ComputerPlayer(Mark.OO));
	        	game.start();
    		}
    		else if(args[0].equals("-S")) {
    			Game game = new Game(new ComputerPlayer(Mark.XX, new SmartStrategy()), new HumanPlayer(args[1], Mark.OO));
	        	game.start();
    		}
    		else if(args[1].equals("-S")) {
    			Game game = new Game(new HumanPlayer(args[0], Mark.XX), new ComputerPlayer(Mark.OO, new SmartStrategy()));
	        	game.start();
    		}
    		else {
	    		Game game = new Game(new HumanPlayer(args[0], Mark.XX), new HumanPlayer(args[1], Mark.OO));
	        	game.start();
    		}
    	}
    	else {
    		Game game = new Game(new HumanPlayer("Player 1", Mark.XX), new HumanPlayer("Player 2", Mark.OO));
    		game.start();
    	}
    }
}
