// TCPServer.java
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");

            Socket client = server.accept(); // accept connection
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String msg = in.readLine(); // read message
            System.out.println("Received: " + msg);

            out.println("Server received: " + msg); // send response

            client.close(); // close connection
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
