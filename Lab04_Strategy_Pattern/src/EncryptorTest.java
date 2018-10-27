import java.util.Scanner;

public class EncryptorTest {

	public static void main(String[] args) {
		System.out.println("Enter the message you want to encrypt: ");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		System.out.println("Which encryptor you want to use? AES/Blowfish/3DES: ");
		Scanner anotherin = new Scanner(System.in);
		String algo = anotherin.next();
		String key = "NAlgorithmFoundException";

		Encryptor encryptor = new Encryptor(input, key, algo);
		System.out.println(encryptor.encrypt());

	}

}
