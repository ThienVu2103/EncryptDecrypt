package main;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESExample {

	private static final String ALGO = "AES";
	private static byte[] keyValue;

	
	
	public AESExample(String key) {
		keyValue = key.getBytes();
	}

	private static Key generateKey() {
		Key key = new SecretKeySpec(keyValue, "AES");
		return key;
	}

	public static String encrypt(String data) {
		Key key = generateKey();
		try {
			Cipher c = Cipher.getInstance(ALGO); // choose type of encrypt
			c.init(Cipher.ENCRYPT_MODE, key); //initial cipher with type of mode
			byte[] encVal = c.doFinal(data.getBytes()); // last, encrypt value. result is type of byte[]
			Base64.Encoder encoder = Base64.getEncoder(); 
			String encryptedValue = encoder.encodeToString(encVal); // final, encode byte[] to string. In order serve the user.
			return encryptedValue;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String encryptedData) {
		Key key = generateKey();
		try {
			Cipher c = Cipher.getInstance(ALGO); // choose type of cipher. aes chosen
			c.init(Cipher.DECRYPT_MODE, key); // initial cipher
			byte[] decordedValue = Base64.getDecoder().decode(encryptedData); 
			// decode is just simply transfer data as string to byte[] 
			// decode a string with return byte[] all of decoder or encoder is belong to java.util.Base64; 
			byte[] decValue = c.doFinal(decordedValue); // last, let cipher doFinal(); 
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		AESExample aes = new AESExample("lv39eptlvuhqqsro");
		String encData = aes.encrypt("xuantramhalathuquendongphong");
		
		System.out.println(encData);
		String decData = aes.decrypt(encData);
		System.out.println(decData);
	}

}
