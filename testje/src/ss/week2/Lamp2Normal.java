package ss.week2;

public class Lamp2Normal {
	private /*@spec_public@*/ int setting;
	
	/**
	 * Constructor for class Lamp
	 * setting is initialized at 0
	 */
	/*@ ensures setting == 0; @*/
	public Lamp2Normal(){
		setting = 0;
	}
	
	/**
	 * Method getSetting
	 * returns the current setting
	 * @return setting
	 */
	/*@ ensures \result == setting; @*/
	public int getSetting(){
		return setting;
	}
	
	/**
	 * Method setSetting
	 * sets the setting at a certain setting
	 * @param newSetting
	 */
	/*@ requires newSetting >= 0;
	ensures setting == newSetting%4; @*/
	public void setSetting(int newSetting){
		setting = newSetting%4;
	}
	
	/**
	 * Method incSetting
	 * increases the setting
	 */
	/*@ requires setting >= 0 && setting <= 3;
	ensures setting == setting + 1 || setting == 3; @*/
	public void incSetting(){
		setting++;
		if(setting > 3){
			setting = 3;
		}
	}
	
	/**
	 * Method decSetting
	 * decreases the setting
	 */
	/*@ requires setting >= 0 && setting <= 3;
	ensures setting == setting - 1 || setting == 0; @*/
	public void decSetting(){
		setting--;
		if(setting < 0){
			setting = 0;
		}
	}
}
