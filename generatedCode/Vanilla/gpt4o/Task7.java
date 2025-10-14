package Vanilla.openai;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Task7 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Load users from file (for simplicity, just using a hardcoded map here)
        users.put("user1", "pass1");
        users.put("user2", "pass2");

        // Test cases
        new Thread(() -> startServer()).start();

        try {
            Thread.sleep(1000); // Give server a moment to start

            System.out.println(login("user1", "pass1")); // true
            System.out.println(login("user2", "wrong")); // false
            System.out.println(login("user3", "pass3")); // false
            System.out.println(login("user1", "pass2")); // false
            System.out.println(login("user2", "pass2")); // true
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                    String request = reader.readLine();
                    String[] parts = request.split(" ");
                    String username = parts[0];
                    String password = parts[1];

                    if (users.containsKey(username) && users.get(username).equals(password)) {
                        writer.println("success");
                    } else {
                        writer.println("failure");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean login(String username, String password) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println(username + " " + password);
            String response = reader.readLine();
            return "success".equals(response);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}