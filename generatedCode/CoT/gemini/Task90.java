package CoT.gemini;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.concurrent.*;

class Task90 {

    private static final int PORT = 8080; // Define the port number
    private static final List<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            // Test cases (simulated clients connecting) - Replace with actual client connections
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 5; i++) {
                Socket clientSocket = new Socket("localhost", PORT); // Simulate client connection
                executor.submit(new ClientHandler(clientSocket));
                Thread.sleep(1000); // Introduce a delay between client connections
            }

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    if (socket != null) socket.close();
                    clients.remove(this);
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }


        private void broadcast(String message) {
            for (ClientHandler client : clients) {
                if (client != this) { // Don't send the message back to the sender
                    client.writer.println(message);
                }
            }
        }
    }
}