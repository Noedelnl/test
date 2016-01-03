package ss.week2;

public class Lamp2Enum {
	public enum Setting {OFF, LOW, MEDIUM, HIGH};
	private Setting setting;
	
	/**
	 * Constructor for class Lamp
	 * setting is initialized at OFF
	 */
	public Lamp2Enum(){
		setting = Setting.OFF;
	}
	
	/**
	 * Method getSetting
	 * returns the current setting
	 * @return setting
	 */
	public Setting getSetting(){
		return setting;
	}
	
	/**
	 * Method incSetting
	 * increases the setting
	 */
	public void incSetting(){
		switch(setting) {
		case OFF: setting = Setting.LOW; break;
		case LOW: setting = Setting.MEDIUM; break;
		case MEDIUM: setting = Setting.HIGH; break;
		case HIGH: break;
		}
	}
	
	/**
	 * Method decSetting
	 * decreases the setting
	 */
	public void decSetting(){
		switch(setting.toString()) {
		case "OFF": break;
		case "LOW": setting = Setting.OFF; break;
		case "MEDIUM": setting = Setting.LOW; break;
		case "HIGH": setting = Setting.MEDIUM; break;
	}
	}
}
