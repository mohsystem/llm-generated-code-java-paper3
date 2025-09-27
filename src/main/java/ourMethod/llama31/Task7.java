package ourMethod.llama31;
// Server.java - Chat server implementation
import java.net.*;
import java.io.*;

// Client.java - Chat client implementation
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Base64;
// Task7.java - Main class for the chat system
class Task7 {
    public static void main(String[] args) {
        // Run the server
        Server server = new Server(2000);
        server.start();

        // Run the client
        Client2 client = new Client2("localhost", 2000);
        client.start();
    }
}

 class Server extends Thread {
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // Handle client authentication and communication
                handleClient(socket);
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private void handleClient(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Read and validate login credentials
        String credentials = in.readLine();
        String[] parts = credentials.split(":");

        if (parts.length != 2) {
            out.println("Invalid credentials format");
            socket.close();
            return;
        }

        String username = parts[0];
        String password = parts[1];

        // Simple authentication against stored credentials (in a real scenario, use a secure storage)
        if (authenticate(username, password)) {
            out.println("Authenticated");
            // Handle chat messages
            handleChat(in, out);
        } else {
            out.println("Authentication failed");
        }

        socket.close();
    }

    private boolean authenticate(String username, String password) {
        // Replace with secure authentication logic
        // Here, we assume credentials are stored in a file or database
        return username.equals("user") && password.equals("pass");
    }

    private void handleChat(BufferedReader in, PrintWriter out) throws IOException {
        while (true) {
            String message = in.readLine();
            if (message == null || message.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Client: " + message);
            out.println("Server: " + message);
        }
    }
}


class Client2 extends Thread {
    private String serverName;
    private int port;

    public Client2(String serverName, int port) {
        this.serverName = serverName;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(serverName, port);
            System.out.println("Connected to server");

            // Prompt user for credentials
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Send credentials to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(username + ":" + password);

            // Read server response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            if (response.equalsIgnoreCase("authenticated")) {
                // Handle chat messages
                handleChat(in, out, scanner);
            } else {
                System.out.println("Authentication failed");
            }

            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }

    private void handleChat(BufferedReader in, PrintWriter out, Scanner scanner) throws IOException {
        while (true) {
            System.out.print("Client: ");
            String message = scanner.nextLine();
            out.println(message);
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            String serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);
        }
    }
}