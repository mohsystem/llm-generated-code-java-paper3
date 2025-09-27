package CoT.claude;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Task7 {
    static class Server {
        private static final int PORT = 5000;
        private static Map<String, String> userCredentials = new HashMap<>();
        
        public static void start() {
            loadCredentials();
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server started on port " + PORT);
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                System.err.println("Server error: " + e.getMessage());
            }
        }

        private static void loadCredentials() {
            // In real implementation, load from secure file/database
            userCredentials.put("user1", hashPassword("pass1"));
            userCredentials.put("user2", hashPassword("pass2"));
        }

        private static void handleClient(Socket clientSocket) {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String request = in.readLine();
                String[] credentials = request.split(":");
                if (credentials.length == 2) {
                    boolean isAuthenticated = authenticateUser(credentials[0], credentials[1]);
                    out.println(isAuthenticated ? "SUCCESS" : "FAILURE");
                }
            } catch (IOException e) {
                System.err.println("Client handling error: " + e.getMessage());
            }
        }

        private static boolean authenticateUser(String username, String password) {
            String storedHash = userCredentials.get(username);
            return storedHash != null && storedHash.equals(hashPassword(password));
        }

        private static String hashPassword(String password) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(hash);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class Client {
        private static final String SERVER_ADDRESS = "localhost";
        private static final int SERVER_PORT = 5000;

        public static boolean login(String username, String password) {
            try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                String request = username + ":" + password;
                out.println(request);
                String response = in.readLine();
                return "SUCCESS".equals(response);
            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // Start server in separate thread
        new Thread(() -> Server.start()).start();
        
        try {
            Thread.sleep(1000); // Wait for server to start
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Test cases
        System.out.println("Test 1: " + Client.login("user1", "pass1")); // Should return true
        System.out.println("Test 2: " + Client.login("user1", "wrongpass")); // Should return false
        System.out.println("Test 3: " + Client.login("user2", "pass2")); // Should return true
        System.out.println("Test 4: " + Client.login("nonexistent", "pass")); // Should return false
        System.out.println("Test 5: " + Client.login("user2", "pass1")); // Should return false
    }
}
