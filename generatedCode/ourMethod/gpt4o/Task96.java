package ourMethod.openai;
import java.io.*;
import java.net.*;

public class Task96 {

    public static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"))) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println("Received: " + message);
                        output.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Server exception: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServer(12345); // Test case 1
        // Additional test cases can be defined as needed.
    }
}