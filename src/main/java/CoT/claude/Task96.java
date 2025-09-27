package CoT.claude;

import java.io.*;
import java.net.*;

public class Task96 {
    public static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        // Echo back the received message
                        out.println(inputLine);
                        if (inputLine.equals("exit")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        int port = 12345;
        startServer(port);
    }
}
