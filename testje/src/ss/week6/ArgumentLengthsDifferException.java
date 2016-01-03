package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	String message = "error: length of command line arguments ";
	
	public String getMessage() {
		return message;
	}

}
