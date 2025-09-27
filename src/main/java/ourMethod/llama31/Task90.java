package ourMethod.llama31;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task90 {
    private ServerSocket serverSocket;
    private int port = 8000;

    public Task90(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error creating server socket: " + e.getMessage());
            System.exit(1);
        }
    }

    public void startServer() {
        System.out.println("Chat server started on port " + port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                System.out.println("Error initializing client handler: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    // Broadcast the message to all connected clients
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                System.out.println("Error handling client message: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        private void broadcastMessage(String message) throws IOException {
            // Simulate broadcasting by sending the message back to the client
            writer.write(message + "\n");
            writer.flush();
        }
    }

    public static void main(String[] args) {
        Task90 server = new Task90(8000);
        server.startServer();
    }
}