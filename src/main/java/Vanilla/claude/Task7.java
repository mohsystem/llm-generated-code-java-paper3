package Vanilla.claude;

import java.io.*;
import java.net.*;
import java.util.*;

// Server Class
class ChatServer {
    private static Map<String, String> users = new HashMap<>();
    private ServerSocket serverSocket;
    
    public ChatServer(int port) {
        try {
            // Initialize with some test users
            users.put("user1", "pass1");
            users.put("user2", "pass2");
            users.put("user3", "pass3");
            
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }
        
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                String loginRequest = in.readLine();
                String[] credentials = loginRequest.split(":");
                
                if (credentials.length == 2) {
                    String username = credentials[0];
                    String password = credentials[1];
                    
                    if (authenticateUser(username, password)) {
                        out.println("LOGIN_SUCCESS");
                    } else {
                        out.println("LOGIN_FAILED");
                    }
                }
                
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private boolean authenticateUser(String username, String password) {
            return users.containsKey(username) && users.get(username).equals(password);
        }
    }
}

// Client Class
class ChatClient1 {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public ChatClient1(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean login(String username, String password) {
        try {
            out.println(username + ":" + password);
            String response = in.readLine();
            socket.close();
            return response.equals("LOGIN_SUCCESS");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

public class Task7 {
    public static void main(String[] args) {
        // Start server in a separate thread
        new Thread(() -> {
            new ChatServer(5000);
        }).start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Test cases
        ChatClient1 client = new ChatClient1("localhost", 5000);
        System.out.println("Test Case 1: " + client.login("user1", "pass1")); // Should return true
        
        client = new ChatClient1("localhost", 5000);
        System.out.println("Test Case 2: " + client.login("user2", "pass2")); // Should return true
        
        client = new ChatClient1("localhost", 5000);
        System.out.println("Test Case 3: " + client.login("user1", "wrongpass")); // Should return false
        
        client = new ChatClient1("localhost", 5000);
        System.out.println("Test Case 4: " + client.login("nonexistent", "pass")); // Should return false
        
        client = new ChatClient1("localhost", 5000);
        System.out.println("Test Case 5: " + client.login("user3", "pass3")); // Should return true
    }
}
