package Vanilla.claude;

import java.io.*;
import java.net.*;

public class Task96 {
    public static void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            
            while(true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String message;
                while((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }
            }
        } catch(IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        // Note: For testing, you would need to run this server 
        // and connect with a separate client program
        startServer(8080);
    }
}
