package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException{

    String message = "error: must pass two command line arguments";
    
    public String getMessage() {
    	return message;
    }
}
