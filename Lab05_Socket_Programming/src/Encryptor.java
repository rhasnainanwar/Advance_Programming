import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class Encryptor {
	private EncryptionStrategy algorithm = null;
	
	public Encryptor(String algo, String key) {
		
		setAlgorithm(algo);
		
		algorithm.setKey(key);
	}
	
	public void setKey(String key) {
		algorithm.setKey(key);
	}
	
	public void setAlgorithm(String algo) {
		if(algo.equals("AES"))
			algorithm = new AesEncryptionStrategy();
		else if(algo.equals("Blowfish"))
			algorithm = new BlowfishEncryptionStrategy();
		else if(algo.equals("3DES"))
			algorithm = new TripleDESEncryptionStrategy();
		else
			System.out.println("Invalid alogrith. Choosing AES by default...");
			algorithm = new AesEncryptionStrategy();
	}
	
	public String encrypt(String message) {
		String out = "";
		try {
			out = algorithm.encryptData(message);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public String decrypt(String message) {
		String out = "";
		try {
			out = algorithm.decryptData(message);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
	}
}
