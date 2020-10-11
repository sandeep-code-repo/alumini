package com.skeleton.alumini.util;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecurityKeyUtil {

	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = 
    		new byte[] { 'J', 'A', 'Y', 'A', 'S', 'H', 'R', 'E', 'E', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
    // Consider in mind before changing the Key-Value as it's used 17 bit length 
    // To Generate Key for encryption as well as decryption
    
    
   
    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());        
        return Base64.getUrlEncoder().encodeToString(encValue);
    }
 
    
    
    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getUrlDecoder().decode(encryptedValue);
		byte[] decValue = c.doFinal(decordedValue);
		return new String(decValue);
    }
 
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
    
    
	/*
	 * public static void main(String args[]) throws Exception { String
	 * encryptPassword = encrypt("jayashree#");
	 * System.out.println("encryptPassword : " + encryptPassword);
	 * 
	 * String decryptPassword = decrypt(encryptPassword);
	 * System.out.println("decryptPassword : " + decryptPassword);
	 * 
	 * if (decryptPassword.equals("jayashree#1")) { System.out.println("matched"); }
	 * else { System.out.println("invalid"); } }
	 */


}

