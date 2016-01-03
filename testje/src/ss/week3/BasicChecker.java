package ss.week3;

import java.security.SecureRandom;
import java.math.*;

/**
 * Class BasicChecker
 * Implements PwChecker
 * Checks basic criteria for a password
 * @author Noel
 *
 */
public class BasicChecker implements PwChecker {
	public final static String INITPASS = "topkek";
	
	/**
	 * Constructor
	 */
	public BasicChecker(){
	}
	
	/**
	 * Method acceptable
	 * Checks if the password is at least 6 characters long and does not contain any spaces
	 */
	public boolean acceptable(String test){
		return test.length() > 5 && !test.contains(" ");
	}
	
	/**
	 * Method generatePassword
	 * returns a random acceptable password
	 * @return password
	 */
	public String generatePassword(){
		SecureRandom random = new SecureRandom();
		String pw = "";
		while(!acceptable(pw)){
			BigInteger bi = new BigInteger(130, random);
			pw = bi.toString(32);
		}
		return pw;
	}
}
