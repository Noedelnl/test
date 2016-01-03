package ss.week3;

/**
 * Interface PwChecker
 * Gives requirements for password checkers
 * @author saulv
 *
 */
public interface PwChecker {
	
	/**
	 * Method acceptable
	 * Tests if string test is an acceptable password.
	 */
	public boolean acceptable(String test);
	
	/**
	 * Method generatePassword
	 * Generates and acceptable password.
	 */
	public String generatePassword();
}
