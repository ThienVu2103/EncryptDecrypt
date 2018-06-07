/**
 * 
 */
package main;

import java.security.MessageDigest;
import java.security.Signature;

/**
 * @author ldtvu
 *
 */
public class SHA256Example {

	/**
	 * 
	 */
	public SHA256Example() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			String input = "xuantramhalathuquendongphong";
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			// Applies sha256 to our input,
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			System.out.println(hexString.toString() + ": " + hexString.length());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
