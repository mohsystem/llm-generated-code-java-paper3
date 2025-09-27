package ourMethod.llama31;
// Task48.java - Server
import java.net.*;
import java.io.*;
import java.util.*;
// Client.java
import java.net.*;
import java.io.*;
import java.util.Scanner;
class Task48 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started. Listening for incoming connections...");

        List<Socket> clients = new ArrayList<>();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);
            System.out.println("New client connected");

            // Handle client in a separate thread
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Received message from client: " + message);
                        broadcastMessage(clients, message, clientSocket);
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                } finally {
                    clients.remove(clientSocket);
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        System.out.println("Error closing client socket: " + e.getMessage());
                    }
                }
            }).start();
        }
    }

    private static void broadcastMessage(List<Socket> clients, String message, Socket excludeClient) throws IOException {
        for (Socket client : clients) {
            if (client != excludeClient) {
                try (PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                    writer.println(message);
                }
            }
        }
    }
}



class Client1 {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8000);
        System.out.println("Connected to the server");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Handle incoming messages in a separate thread
            new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Error receiving message from server: " + e.getMessage());
                }
            }).start();

            while (true) {
                System.out.print("Client: ");
                String input = scanner.nextLine();
                writer.println(input);
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } finally {
            clientSocket.close();
        }
    }
}