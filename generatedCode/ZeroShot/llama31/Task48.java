package ZeroShot.llama31;
// Task48.java

import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    public static void main(String[] args) throws Exception {
        // Server test case
        Server server = new Server(8000);
        server.start();

        // Client test cases
        Client client1 = new Client("localhost", 8000);
        Client client2 = new Client("localhost", 8000);
        Client client3 = new Client("localhost", 8000);

        client1.start();
        client2.start();
        client3.start();
    }
}

class Server extends Thread {
    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList<>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Start a new thread to handle the client
                ClientHandler handler = new ClientHandler(clientSocket, clients);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private List<Socket> clients;

    public ClientHandler(Socket clientSocket, List<Socket> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received from client: " + message);
                broadcast(message, clients, clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message, List<Socket> clients, Socket exclude) throws IOException {
        for (Socket client : clients) {
            if (client != exclude) {
                try (PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                    writer.println(message);
                }
            }
        }
    }
}

class Client extends Thread {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        try (Socket clientSocket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            // Send a welcome message
            writer.println("Hello from client");

            // Listen for messages from the server
            Thread listener = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            listener.start();

            // Send user input to the server
            String input;
            while ((input = userInput.readLine()) != null) {
                writer.println(input);
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + host);
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}