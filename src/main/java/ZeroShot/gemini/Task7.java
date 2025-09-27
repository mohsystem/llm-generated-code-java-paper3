package ZeroShot.gemini;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class Task7 {

    static class Client {
        private String username;
        private String password;

        public Client(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String createLoginRequest() {
            return "LOGIN " + username + " " + password;
        }
    }

    static class Server {
        private Map<String, String> userDatabase;

        public Server() {
            userDatabase = new HashMap<>();
            // Load user database from file or other secure storage
            // In this example, hardcoding for simplicity
            userDatabase.put("user1", "password123");
            userDatabase.put("user2", "securepass");

        }

        public String processRequest(String request) {
            String[] parts = request.split(" ");
            if (parts.length == 3 && parts[0].equals("LOGIN")) {
                String username = parts[1];
                String password = parts[2];
                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    return "LOGIN_SUCCESS";
                } else {
                    return "LOGIN_FAILED";
                }
            }
            return "INVALID_REQUEST";
        }
    }

    public static void main(String[] args) {

        Server server = new Server();

        // Test Cases
        Client client1 = new Client("user1", "password123");
        System.out.println(server.processRequest(client1.createLoginRequest())); // Expected: LOGIN_SUCCESS

        Client client2 = new Client("user2", "wrongpassword");
        System.out.println(server.processRequest(client2.createLoginRequest())); // Expected: LOGIN_FAILED

        Client client3 = new Client("user3", "password123");
        System.out.println(server.processRequest(client3.createLoginRequest())); // Expected: LOGIN_FAILED

        Client client4 = new Client("user1", "");
        System.out.println(server.processRequest(client4.createLoginRequest())); // Expected: LOGIN_FAILED

        System.out.println(server.processRequest("INVALID_REQUEST")); // Expected: INVALID_REQUEST


    }
}