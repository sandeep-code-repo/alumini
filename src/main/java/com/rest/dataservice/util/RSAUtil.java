package com.rest.dataservice.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.dataservice.repository.UserRepository;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    //private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCB5efFlssoMNXxlWmmwPL75tVE56pIA8Q5yUGjV2F+Ntv2BkoxcnHIOQZdurG9UdVWtzGJOiLUjw84k7EFK0DT6WrKI1lP2bBW5vjfKo0VAE/OUwqq0PQhv7DBklkXuTqGKv5k1GPMR89cE1WpRS6cqNZKobjKj5+/+O2GKTLpYQIDAQAB";
    //private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIHl58WWyygw1fGVaabA8vvm1UTnqkgDxDnJQaNXYX422/YGSjFyccg5Bl26sb1R1Va3MYk6ItSPDziTsQUrQNPpasojWU/ZsFbm+N8qjRUAT85TCqrQ9CG/sMGSWRe5OoYq/mTUY8xHz1wTValFLpyo1kqhuMqPn7/47YYpMulhAgMBAAECgYBMRQFhMrj2UDZOMrxl/MSuw0pVuvBweEWu6Exx68yCnxNn0Sme/uNv/IuQXR4fWv04fTfIqynoRFdbkNxPfKYC8MtDhN+l5ujSkbhqijhcqj3emjMP114dB9eJCqMBJC4K2PdTtCQt9mi6twKCV7QcOij/GTKz6VJXovgxUk0cAQJBALnwgAaMSeO2+qkpS3ab6pbfvm5LmgAVxyI9STlZuBRAiagsmBcsGc2zxmoTo9Y2I3TbmXeeNbBqQShX8yMquekCQQCy17gs9Z0RqIFtUZIx9BmuxQ1/gZSGeij421q908JgpPGAJNlUbF+Xp6icLwMGFFX7NZnWo5hpOfWtq+YxlBC5AkEAubLDaca6FL4t4LvpLe/RfhS+7xB6IROe6Ucj1i8QdMlvsZG344ybyKB+zHoI6mrvRkn7H0fWfvXfVRdhMAH/4QJAdPUEWkqp1IF5Wu+MhySWoyf1AtzQL/21y8FQH3Jb3O4hjWcLxd01yqz3ZGSOOqyT6jwMhkToiHBCDbisSuIE6QJAIVc3bzQ1U5oD4g4Ushq7I3rXCmnqxGxt4PhV5lSEeG5H/ZwedLYQ4c+AHM6LixV4ms/9q33aGJponrP/8wn1sw==";

    @Autowired
    private static UserRepository userRepository;
    
    public static PublicKey getPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }
    
    
	
	/*
	 * public static void main(String[] args) throws IllegalBlockSizeException,
	 * InvalidKeyException, NoSuchPaddingException, BadPaddingException { try {
	 * String encryptedString =
	 * Base64.getEncoder().encodeToString(encrypt("hindalco@123", publicKey));
	 * System.out.println(encryptedString); String decryptedString =
	 * RSAUtil.decrypt(encryptedString, privateKey);
	 * System.out.println(decryptedString); } catch (NoSuchAlgorithmException e) {
	 * System.err.println(e.getMessage()); }
	 * 
	 * }
	 */
	 
}
