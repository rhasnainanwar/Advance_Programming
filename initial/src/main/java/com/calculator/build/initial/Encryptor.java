package com.calculator.build.initial;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class Encryptor {
	private EncryptionStrategy algorithm = null;
	private String message = "";
	private String key = "";
	
	public Encryptor(String message, String key, String algo) {
		this.message = message;
		this.key = key;
		if(algo.equals("AES"))
			algorithm = new AesEncryptionStrategy();
		else if(algo.equals("Blowfish"))
			algorithm = new AesEncryptionStrategy();
		else if(algo.equals("3DES"))
			algorithm = new TripleDESEncryptionStrategy();
	}
	
	public String encrypt() {
		if(algorithm == null)
			return "INVALID ALGORITHM";
		
		algorithm.setKey(key);
		
		try {
			algorithm.encryptData(message);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return algorithm.getResult();
	}
	
}