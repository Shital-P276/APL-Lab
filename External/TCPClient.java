// TCPClient.java
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter message: ");
            String msg = userInput.readLine(); // read from user
            out.println(msg); // send to server

            String response = in.readLine(); // read from server
            System.out.println("Response: " + response);
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
