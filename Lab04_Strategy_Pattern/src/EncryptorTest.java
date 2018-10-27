import java.util.Scanner;

public class EncryptorTest {

	public static void main(String[] args) {
		System.out.println("Enter the message you want to encrypt: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		System.out.println("Which encryptor you want to use? AES/Blowfish/3DES: ");
		Scanner anotherin = new Scanner(System.in);
		String algo = anotherin.nextLine();
		String key = "NAlgorithmFoundException";
		
		in.close(); anotherin.close();

		Encryptor encryptor = new Encryptor(algo, key);
		String res = encryptor.encrypt(input);
		System.out.println(res);
		System.out.println(encryptor.decrypt(res));

	}

}
