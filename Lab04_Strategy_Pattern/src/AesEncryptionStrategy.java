import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AesEncryptionStrategy implements EncryptionStrategy {
	private byte[] key;
	private byte[] res;
	
	public void setKey(String key) {
		this.key = key.getBytes();
	}
	
	@Override
	public void encryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
		SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		try {
			res = cipher.doFinal(plainText.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String encode() {
		byte[] encoded = Base64.getEncoder().encode(res);
		return new String(encoded); 
	}
}
