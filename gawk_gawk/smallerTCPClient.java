import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 6789;

        try (Socket socket = new Socket(serverAddress, port)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = "Hello from Client!";
            out.writeUTF(message);
            System.out.println("Sent: " + message);

            String response = in.readUTF();
            System.out.println("Received: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}