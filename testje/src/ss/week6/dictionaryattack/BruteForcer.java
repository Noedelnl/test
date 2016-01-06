package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
/**
 * Class to bruteforce a password given a password file consisting of usernames and md5 hashes.
 * @author n
 *
 */
public class BruteForcer {
	private Map<String, String> passwordMap;
	private String choices = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Method to readPasswords to a Hashmap from a given file.
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
	 * Method to convert a password to its md5 Hash.
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
	 * Method to crack md5 hashed passwords if certain length.
	 * @param user
	 * @param pos
	 * @param length of password
	 * @param temp
	 */
	public void crackRecursive(String user, int pos, int length, String temp) {
		if (pos < length) {
			for (int i = 0; i < choices.length(); i++) {
				crackRecursive(user, pos + 1, length, temp + choices.charAt(i));
			}
		}
		else {
			if (passwordMap.get(user).equals(getPasswordHash(temp))) {
				System.out.printf("Password for %s is: %s %n", user, temp);
			}
		}
	}
	
	/**
	 * Method to crack password of length 4.
	 * @param user
	 * @return
	 */
	public String crackPassword(String user) {
		if (passwordMap.get(user) == null) {
			return "No such user";
		}
		int options = choices.length() - 1;
		System.out.printf("Bruteforcing for: %s %n", user);
		for (int i = 0; i < options; i++) {
			for (int j = 0; j < options; j++) {
				for (int k = 0; k < options; k++) {
					for (int l = 0; l < options; l++) {
						String pass = "";
						pass = pass + choices.charAt(i) + choices.charAt(j) + choices.charAt(k) + choices.charAt(l);
						if (passwordMap.get(user).equals(getPasswordHash(pass))) {
							return "password for: " + user + " is: " + pass;
						}
					}
				}
			}
		}
		return "password not found";
	}
	
	/**
	 * Main method to bruteforce Alice's password using crackRecursive.
	 * @param args
	 */
	public static void main(String[] args) {
		BruteForcer brute = new BruteForcer();
		brute.readPasswords("/home/n/GitHub/test/testje/src/ss/week6/test/LeakedPasswords.txt");
		brute.crackRecursive("alice", 0, 4, "");
	}
}
