package ss.week3;

/**
 * Class TimedPassword
 * Extends Password
 * Adds an implementation of a valid time
 * @author saulv
 *
 */
public class TimedPassword extends Password {
	private long validTime;
	private String factoryPassword;
	
	/**
	 * Constructor 1
	 * Initializes with a default valid time of 24 hours
	 */
	public TimedPassword(){
		super();
		validTime = System.currentTimeMillis() + 86400000;
		factoryPassword = INITIAL;
	}
	
	/**
	 * Constructor 2
	 * Initializes with a given valid time
	 * @param the given validity
	 */
	public TimedPassword(int validity){
		super();
		validTime = System.currentTimeMillis() + validity;
		factoryPassword = INITIAL;
	}
	
	/**
	 * Gives the remaining valid time, in milliseconds
	 * @return the remaining valid time
	 */
	public int validTime(){
		return (int) (validTime - System.currentTimeMillis());
	}
	
	/**
	 * Gives a boolean indicating whether or not the valid time has passes or not
	 * @return
	 */
	public boolean isExpired(){
		return !(validTime() > 0);
	}
	
	/**
	 * Method setWord
	 * Changes the current factoryPassword to a new password,
	 * provided that the new factoryPassword is acceptable and the old factoryPassword is correct
	 * @param oldpass - The old factoryPassword
	 * @param newpass - The new factoryPassword
	 * @return boolean, if the change was successful of not
	 */
	public boolean setWord(String oldpass, String newpass){
		if(testWord(oldpass) && acceptable(newpass)){
			factoryPassword = newpass;
			validTime = validTime + 86400;
			return true;
		}
		return false;
	}
}