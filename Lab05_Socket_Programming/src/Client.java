import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.security.MessageDigest;

public class Client {

	public static void main(String args[]) throws UnknownHostException, IOException
	{
		System.out.println("Enter the message you want to encrypt: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		System.out.println("Which encryptor you want to use? AES/Blowfish/3DES: ");
		Scanner anotherin = new Scanner(System.in);
		String algo = anotherin.nextLine();
		
		System.out.println("Which key you want to use? (Length should be 16 or 24): ");
		Scanner another = new Scanner(System.in);
		String key = another.nextLine();
		
		in.close(); anotherin.close(); another.close();
		
		Encryptor encryptor = new Encryptor(algo, key);
		String encrypted = encryptor.encrypt(input);
		int hashcode = encrypted.hashCode();
		System.out.println("Hash Code: " + hashcode);
		
		@SuppressWarnings("resource")
		Socket socket = new Socket("192.168.43.89", 1346);
		@SuppressWarnings("resource")
		Scanner scannerSocket = new Scanner(socket.getInputStream());
		
		PrintStream stream = new PrintStream(socket.getOutputStream());
		stream.println(algo);
		stream.println(key);
		
		String acknoledgement = scannerSocket.nextLine();
		System.out.println(acknoledgement);
		
		stream.println(encrypted);
		stream.println(hashcode);


		
	}	
}
