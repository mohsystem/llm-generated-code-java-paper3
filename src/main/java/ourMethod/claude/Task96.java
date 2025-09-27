package ourMethod.claude;

import java.io.*;
import java.net.*;

public class Task96 {
    private static final int BUFFER_SIZE = 1024;
    
    public static String startServer(int port) {
        if (port < 0 || port > 65535) {
            return "Invalid port number";
        }
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(30000); // 30 second timeout
            Socket clientSocket = serverSocket.accept();
            
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                
                String inputLine = in.readLine();
                if (inputLine != null && inputLine.length() <= BUFFER_SIZE) {
                    out.println(inputLine); // Echo back
                    return "Message echoed: " + inputLine;
                }
                return "Invalid message received";
            }
        } catch (IOException e) {
            return "Server error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + startServer(8080)); // Valid port
        System.out.println("Test 2: " + startServer(-1)); // Invalid port
        System.out.println("Test 3: " + startServer(65536)); // Invalid port
        System.out.println("Test 4: " + startServer(0)); // System assigned port
        System.out.println("Test 5: " + startServer(9090)); // Valid port
    }
}
