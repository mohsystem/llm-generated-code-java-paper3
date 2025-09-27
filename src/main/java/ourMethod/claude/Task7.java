package ourMethod.claude;

import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import java.nio.charset.StandardCharsets;

public class Task7 {
    private static final int PORT = 8080;
    private static final String CREDENTIALS_FILE = "credentials.txt";
    
    // Server class
    static class Server {
        private ServerSocket serverSocket;
        private Map<String, String> credentials;
        
        public Server() {
            credentials = new HashMap<>();
            loadCredentials();
        }
        
        private void loadCredentials() {
            try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        credentials.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error loading credentials: " + e.getMessage());
            }
        }
        
        public void start() {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server started on port " + PORT);
                
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    handleClient(clientSocket);
                }
            } catch (IOException e) {
                System.err.println("Server error: " + e.getMessage());
            }
        }
        
        private void handleClient(Socket clientSocket) {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String request = in.readLine();
                if (request != null) {
                    String[] parts = request.split(":");
                    if (parts.length == 2) {
                        String username = parts[0];
                        String password = parts[1];
                        
                        boolean authenticated = authenticate(username, password);
                        out.println(authenticated ? "SUCCESS" : "FAILURE");
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
        
        private boolean authenticate(String username, String password) {
            String storedPassword = credentials.get(username);
            return storedPassword != null && storedPassword.equals(password);
        }
    }
    
    // Client class
    static class Client {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        
        public boolean connect(String host) {
            try {
                socket = new Socket(host, PORT);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                return true;
            } catch (IOException e) {
                System.err.println("Connection error: " + e.getMessage());
                return false;
            }
        }
        
        public boolean login(String username, String password) {
            try {
                out.println(username + ":" + password);
                String response = in.readLine();
                return "SUCCESS".equals(response);
            } catch (IOException e) {
                System.err.println("Login error: " + e.getMessage());
                return false;
            }
        }
        
        public void disconnect() {
            try {
                if (socket != null) socket.close();
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (IOException e) {
                System.err.println("Disconnect error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.start();
        });
        serverThread.start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Test cases
        Client client = new Client();
        if (client.connect("localhost")) {
            // Test case 1: Valid credentials
            System.out.println("Test 1: " + client.login("user1", "pass1"));
            
            // Test case 2: Invalid password
            System.out.println("Test 2: " + client.login("user1", "wrongpass"));
            
            // Test case 3: Invalid username
            System.out.println("Test 3: " + client.login("invaliduser", "pass1"));
            
            // Test case 4: Empty credentials
            System.out.println("Test 4: " + client.login("", ""));
            
            // Test case 5: Special characters
            System.out.println("Test 5: " + client.login("user@1", "pass#1"));
            
            client.disconnect();
        }
    }
}
