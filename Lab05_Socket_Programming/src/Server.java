import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

	public static void main(String args[]) throws IOException
	{
		int number, temp;
		ServerSocket s1 = new ServerSocket(1342);
		Socket socket = s1.accept();
		
		Scanner scannerSocket = new Scanner(socket.getInputStream());
		PrintStream stream = new PrintStream(socket.getOutputStream());
		
		String algo = scannerSocket.nextLine();
		String key = scannerSocket.nextLine();
		
		String encrypted = scannerSocket.nextLine();
		
		int hash = scannerSocket.nextInt();
		
		if(hash == encrypted.hashCode()) {
			stream.println("OK");
		}
		else {
			stream.print("BAD");
		}
		
	}
	
}
