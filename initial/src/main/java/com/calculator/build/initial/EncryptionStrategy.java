package com.calculator.build.initial;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public interface EncryptionStrategy {
    String encryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException;
    String decryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException;

	void setKey(String key);
}