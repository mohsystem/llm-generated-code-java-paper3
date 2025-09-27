package ourMethod.gpt4o;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.HashMap;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Task7 {

    public static void main(String[] args) {
        // Sample test cases
        client("user1", "password1");
        client("user2", "password2");
        client("user3", "password3");
        client("user4", "password4");
        client("user5", "password5");
    }

    public static void client(String username, String password) {
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Securely hash the password before sending
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());

            out.println(username + ":" + new String(hashedPassword));
            String response = in.readLine();
            System.out.println("Response: " + response);

            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Server {
        private static HashMap<String, String> userDatabase = new HashMap<>();

        static {
            try {
                userDatabase.put("user1", hashPassword("password1"));
                userDatabase.put("user2", hashPassword("password2"));
                userDatabase.put("user3", hashPassword("password3"));
                userDatabase.put("user4", hashPassword("password4"));
                userDatabase.put("user5", hashPassword("password5"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void start() {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> processClient(clientSocket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void processClient(Socket clientSocket) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message = in.readLine();
                String[] parts = message.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String passwordHash = parts[1];
                    if (userDatabase.containsKey(username) && userDatabase.get(username).equals(passwordHash)) {
                        out.println("Login successful");
                    } else {
                        out.println("Login failed");
                    }
                } else {
                    out.println("Invalid message format");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String hashPassword(String password) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            return new String(hashedPassword);
        }
    }
}