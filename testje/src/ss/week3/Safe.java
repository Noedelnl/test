package ss.week3;

/**
 * Class Safe
 * Defines a safe that can be activated/deactivated and opened/closed
 * @author saulv
 *
 */
public class Safe {
	private Password password;
	private boolean active;
	private boolean open;
	
	/**
	 * Creates a new <code>Safe</code> with an initial password that is currently inactive and closed.
	 */
	/*@ ensures isActive() == false && isOpen() == false; @*/
	public Safe(){
		password = new Password();
		active = false;
		open = false;
	}
	
	/**
	 * returns if a safe is currently active.
	 */
	//@ pure;
	public boolean isActive(){
		return active;
	}
	
	/**
	 * returns if a safe is currently open.
	 */
	//@ pure;
	public boolean isOpen(){
		return open;
	}
	
	/**
	 * returns the current password of this <code>Safe</code>.
	 */
	//@ pure;
	public Password getPassword(){
		return password;
	}
	
	/**
	 * Activates this <code>Safe</code> if input matches the password.
	 * @param input password
	 * @return boolean that indicates if safe is active or not.
	 */
	//@ ensures getPassword().testWord(input) ==> isActive();
	//@ ensures \old(isActive()) ==> isActive();
	public boolean activate(/*@non_null@*/String input){
		assert input != null;
		boolean oldIsActive = active;
		
		if(password.testWord(input)){
			active = true;
		}
		assert !getPassword().testWord(input) || active;
		assert !oldIsActive || active;
		return active;
	}
	
	/**
	 * Deactivates this <code>Safe</code>
	 */
	//@ ensures isActive() == false;
	public void deactivate(){
		active = false;
	}
	
	/**
	 * Opens the safe if the password is correct and the safe is currently active.
	 * @param input password
	 * @return boolean that indicates if the safe is open or not.
	 */
	//@ ensures \result == isOpen();
	//@ ensures getPassword().testWord(input) && isActive() ==> isOpen() == true;
	public boolean open(String input){
		if(password.testWord(input) && active){
			open = true;
			return open;
		}
		return false;
	}
	
	/**
	 * Closes this <code>Safe</code>
	 */
	//@ ensures isOpen() == false;
	public void close(){
		open = false;
	}
}
