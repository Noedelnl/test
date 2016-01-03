package ss.week3;

/**
 * Class factoryPassword
 * A factoryPassword can be changes, provided that the old/initial factoryPassword is given
 * and the new factoryPassword is acceptable
 * @author saulv
 */
public class Password {
	public final static String INITIAL = "topkek";
	private String factoryPassword;
	private PwChecker checker;
	
	/**
	 * Constructor for class factoryPassword using a given checker
	 * By default, the factoryPassword is "topkek"
	 */
	public Password(PwChecker newChecker){
		checker = newChecker;
		factoryPassword = INITIAL;
	}

	/**
	 * Constructor for class factoryPassword using a StrongChecker
	 * By default, the factoryPassword is "topkek"
	 */
	public Password(){
		this(new BasicChecker());
	}
	
	/**
	 * Method acceptable
	 * Checks whether or not a word is acceptable as a factoryPassword
	 * @param suggestion - The to be tested word
	 * @return boolean, if the suggestion is acceptable or not
	 */
	public boolean acceptable(String suggestion){
		return checker.acceptable(suggestion);
	}
	
	/**
	 * Method testWord
	 * Checks whether or not the given word matches the current factoryPassword
	 * @param test - The word to be tested
	 * @return boolean, if the word matches the current factoryPassword or not
	 */
	//@ pure;
	public boolean testWord(String test){
		if(factoryPassword.equals(test)){
			return true;
		}
		return false;
	}
	
	/**
	 * Method setWord
	 * Changes the current factoryPassword to a new pasword,
	 * provided that the new factoryPassword is acceptable and the old factoryPassword is correct
	 * @param oldpass - The old factoryPassword
	 * @param newpass - The new factoryPassword
	 * @return boolean, if the change was successful of not
	 */
	public boolean setWord(String oldpass, String newpass){
		if(testWord(oldpass) && acceptable(newpass)){
			factoryPassword = newpass;
			return true;
		}
		return false;
	}
	
}
