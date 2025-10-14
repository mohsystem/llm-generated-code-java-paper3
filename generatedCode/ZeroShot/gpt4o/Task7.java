package ZeroShot.openai;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Task7 {
    public static void main(String[] args) {
        new Thread(new Server()).start();
        new Thread(new Client("user1", "password1")).start();
        new Thread(new Client("user2", "password2")).start();
        new Thread(new Client("user1", "wrongpassword")).start();
        new Thread(new Client("user3", "password3")).start();
    }
}

class Client implements Runnable {
    private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("LOGIN:" + username + ":" + password);
            System.out.println("Server response: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server implements Runnable {
    private HashMap<String, String> userDatabase = new HashMap<>();

    public Server() {
        // Example user data
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String input = in.readLine();
                    String[] parts = input.split(":");
                    if (parts.length == 3 && parts[0].equals("LOGIN")) {
                        String username = parts[1];
                        String password = parts[2];
                        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                            out.println("Login Successful");
                        } else {
                            out.println("Invalid Credentials");
                        }
                    } else {
                        out.println("Invalid Request");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}