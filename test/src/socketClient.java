
import java.io.*;
import java.net.*;

public class socketClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;

	public socketClient() {
		try {
			socket = new Socket("10.3.34.88", 10000);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader line = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println(line.readLine());
			line.close();
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new socketClient();
	}
}