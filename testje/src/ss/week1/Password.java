package ss.week1;

/**
 * Class Password
 * A password can be changes, provided that the old/initial password is given
 * and the new password is acceptable
 * @author saulv
 */
public class Password {
	public final static String INITIAL = "topkek";
	private String password;
	
	/**
	 * Constructor for class Password
	 * By default, the password is the initial password.
	 */
	public Password(){
		password = INITIAL;
	}
	
	/**
	 * Method acceptable
	 * Checks whether or not a word is acceptable as a password
	 * @param suggestion - The to be tested word
	 * @return boolean, if the suggestion is acceptable or not
	 */
	public boolean acceptable(String suggestion){
		if(suggestion.length() < 6 || suggestion.contains(" ")){
			return false;
		}
		return true;
	}
	
	/**
	 * Method testWord
	 * Checks whether or not the given word matches the current password
	 * @param test - The word to be tested
	 * @return boolean, if the word matches the current password or not
	 */
	public boolean testWord(String test){
		if(password.equals(test)){
			return true;
		}
		return false;
	}
	
	/**
	 * Method setWord
	 * Changes the current password to a new pasword,
	 * provided that the new password is acceptable and the old password is correct
	 * @param oldpass - The old password
	 * @param newpass - The new password
	 * @return boolean, if the change was successful of not
	 */
	public boolean setWord(String oldpass, String newpass){
		if(testWord(oldpass) && acceptable(newpass)){
			password = newpass;
			return true;
		}
		return false;
	}
}
