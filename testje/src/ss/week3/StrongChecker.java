package ss.week3;

/**
 * Class StrongChecker
 * Extends BasicChecker, Implements PwChecker
 * Checks if a string is an acceptable strong password
 * @author Noel
 */
public class StrongChecker extends BasicChecker implements PwChecker {
	
	/**
	 * Constructor
	 */
	public StrongChecker(){
		super();
	}
	
	/**
	 * Checks if the String is a strong password
	 */
	public boolean acceptable(String test){
		return super.acceptable(test) && Character.isLetter(test.charAt(0)) && Character.isDigit(test.charAt((test.length() - 1)));
	}
	
	/**
	 * Returns a random strong password
	 * @return password
	 */
	public String generatePassword(){
		String pw = "";
			pw = super.generatePassword();
		return pw;
	}
}
