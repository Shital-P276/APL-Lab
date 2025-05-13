import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 6789;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // Setup input/output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read message from client
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Send a response
            String response = "Hello from Server!";
            out.println(response);
            System.out.println("Sent to client: " + response);

            // Close connection
            socket.close();
            System.out.println("Server closed connection.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
