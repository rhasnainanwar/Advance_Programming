package com.calculator.build.initial;

import static org.junit.Assert.*;
import org.junit.Test;


public class EncryptorTest {
	
	String input = "Raja Hasnain Anwar";
	String key = "NAlgorithmFoundException";
	
	@Test
	public void test1() {
		Encryptor encryptor = new Encryptor("AES", key);
		System.out.println(encryptor.encrypt(input));
		assertEquals("aB8nZxNTJalbg0Uxc7aolHlE5xltE4300RTvIyJ49Xg=",encryptor.encrypt(input));
	}
	
	@Test
	public void test2() {
		Encryptor encryptor = new Encryptor("Blowfish", key);
		System.out.println(encryptor.encrypt(input));
		assertEquals("aB8nZxNTJalbg0Uxc7aolHlE5xltE4300RTvIyJ49Xg=",encryptor.encrypt(input));
	}
	
	@Test
	public void test3() {
		Encryptor encryptor = new Encryptor("3DES", key);
		System.out.println(encryptor.encrypt(input));
		assertEquals("EYloB46dubfxNFmY6H8A4bDVDO2yrsey",encryptor.encrypt(input));
	}
	
}
