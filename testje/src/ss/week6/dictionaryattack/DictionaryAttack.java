package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) {
		passwordMap = new HashMap<String, String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				String[] content = line.split(":");
				content[0] = content[0].trim();
				content[1] = content[1].trim();
				passwordMap.put(content[0], content[1]);
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			byte[] buffer = password.getBytes();
			byte[] result = null;
			StringBuffer buf = null;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(buffer);
			result =  md5.digest();
			buf = new StringBuffer(result.length * 2) ;
			for (int i = 0; i < result.length; i++) {
				int intVal = result[i] & 0xff;
				if (intVal < 0x10) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(intVal));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Exception Caught: " + e);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        if (passwordMap.containsKey(user)) {
        	System.out.println(passwordMap.get(user));
        	System.out.println(getPasswordHash(password));
        	if (passwordMap.get(user).equals(getPasswordHash(password))) {
        		return true;
        	}
        }
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {
    		hashDictionary = new HashMap<String, String>();
    		try {
    			BufferedReader reader = new BufferedReader(new FileReader(filename));
    			String line = reader.readLine();
    			while (line != null) {
    				String pass= line.trim();
    				String md5 = getPasswordHash(pass);
    				hashDictionary.put(pass, md5);
    				line = reader.readLine();
    			}
    			reader.close();
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}  
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (Map.Entry<String, String> passEntry : passwordMap.entrySet()) {
			for (Map.Entry<String, String> hashEntry : hashDictionary.entrySet()) {
				if (passEntry.getValue().equals(hashEntry.getValue())) {
					System.out.printf("%s: %s \n", passEntry.getKey(), hashEntry.getKey());
				}
			}
		}
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		da.addToHashDictionary("/home/noel/GitHub/test/testje/src/ss/week6/test/passwords.txt");
		da.readPasswords("/home/noel/GitHub/test/testje/src/ss/week6/test/LeakedPasswords.txt");
		da.doDictionaryAttack();
	}

}
