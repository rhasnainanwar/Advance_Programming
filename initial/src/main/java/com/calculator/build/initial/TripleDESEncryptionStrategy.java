package com.calculator.build.initial;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESEncryptionStrategy implements EncryptionStrategy {
	private byte[] key;
	private byte[] res;
	
	public void setKey(String key) {
		this.key = key.getBytes();
	}
	
	@Override
	public String encryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
		SecretKeySpec secretKey = new SecretKeySpec(key, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		try {
			res = cipher.doFinal(plainText.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] encoded = Base64.getEncoder().encode(res);
		return new String(encoded);
	}
	
	@Override
	public String decryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
		SecretKeySpec secretKey = new SecretKeySpec(key, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		try {
			res = cipher.doFinal(plainText.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] encoded = Base64.getDecoder().decode(res);
		return new String(encoded);
	}
	
}
