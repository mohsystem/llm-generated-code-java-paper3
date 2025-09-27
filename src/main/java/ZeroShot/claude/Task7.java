package ZeroShot.claude;

import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;

class Task7 {
    public static void main(String[] args) {
        // Start server in separate thread
        new Thread(() -> {
            ChatServer server = new ChatServer();
            server.start(8000);
        }).start();

        // Test cases
        try {
            Thread.sleep(1000); // Wait for server to start
            
            ChatClient1 client = new ChatClient1();
            
            // Test 1: Valid login
            System.out.println("Test 1: " + client.login("user1", "pass1")); 
            
            // Test 2: Invalid password
            System.out.println("Test 2: " + client.login("user1", "wrongpass"));
            
            // Test 3: Invalid username 
            System.out.println("Test 3: " + client.login("invalid", "pass1"));
            
            // Test 4: Empty credentials
            System.out.println("Test 4: " + client.login("", ""));
            
            // Test 5: SQL injection attempt
            System.out.println("Test 5: " + client.login("user1'; DROP TABLE users;--", "pass1"));
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class ChatClient1 {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public String login(String username, String password) {
        try {
            socket = new Socket("localhost", 8000);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Hash password before sending
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String hashedPass = Base64.getEncoder().encodeToString(
                digest.digest(password.getBytes()));
            
            // Send login request
            out.println("LOGIN:" + username + ":" + hashedPass);
            
            String response = in.readLine();
            socket.close();
            return response;
            
        } catch(Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

class ChatServer {
    private Map<String, String> users;
    
    public ChatServer() {
        users = new HashMap<>();
        // Initialize with some test users (username -> hashed password)
        users.put("user1", hashPassword("pass1"));
        users.put("user2", hashPassword("pass2")); 
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return Base64.getEncoder().encodeToString(
                digest.digest(password.getBytes()));
        } catch(Exception e) {
            return null;
        }
    }
    
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            
            while(true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            String request = in.readLine();
            String[] parts = request.split(":");
            
            if(parts[0].equals("LOGIN")) {
                String username = parts[1];
                String password = parts[2];
                
                if(users.containsKey(username) && 
                   users.get(username).equals(password)) {
                    out.println("Login successful");
                } else {
                    out.println("Invalid credentials");
                }
            }
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
