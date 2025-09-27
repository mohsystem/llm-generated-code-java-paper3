package ZeroShot.claude;

import java.io.*;
import java.net.*;

public class Task96 {
    public static void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine); // Echo back
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
        // Note: Only one test case can run at a time since it's a server
        startServer(8080);
        
        // Additional test cases would be:
        // startServer(8081);
        // startServer(8082); 
        // startServer(8083);
        // startServer(8084);
    }
}
