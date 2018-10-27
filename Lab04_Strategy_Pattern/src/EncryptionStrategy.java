import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public interface EncryptionStrategy {
    void encryptData(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException;

	String encode();

	void setKey(String key);
}