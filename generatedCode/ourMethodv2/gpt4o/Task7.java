package ourMethodv2.gpt4o;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task7 {
    private static final String FILE_PATH = "users.txt";

    public static void main(String[] args) {
        // Start server in a separate thread
        new Thread(() -> {
            try {
                startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Test clients
        client("user1", "password1");
        client("user2", "password2");
        client("user3", "password3");
        client("user4", "password4");
        client("user5", "password5");
    }

    public static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String[] credentials = in.readLine().split(",");
        String username = credentials[0];
        String password = credentials[1];

        if (authenticateUser(username, password)) {
            out.println("Login successful");
        } else {
            out.println("Invalid credentials");
        }

        clientSocket.close();
    }

    public static boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userPass = line.split(",");
                if (userPass[0].equals(username) && userPass[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void client(String username, String password) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println(username + "," + password);
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}