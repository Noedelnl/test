package ss.week1;

public class Lamp {
	private int setting;
	
	/**
	 * Constructor for class Lamp
	 * setting is initialized at 0
	 */
	public Lamp(){
		setting = 0;
	}
	
	/**
	 * Method getSetting
	 * returns the current setting
	 * @return setting
	 */
	public int getSetting(){
		return setting;
	}
	
	/**
	 * Method setSetting
	 * sets the setting at a certain setting
	 * @param newSetting
	 */
	public void setSetting(int newSetting){
		setting = newSetting%4;
	}
	
	/**
	 * Method incSetting
	 * increases the setting
	 */
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
	public void decSetting(){
		setting--;
		if(setting < 0){
			setting = 0;
		}
	}
}
