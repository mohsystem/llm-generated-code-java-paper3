package ourMethod.claude;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Task48 {
    private static final int PORT = 8080;
    private static final int MAX_CLIENTS = 50;
    private static final ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTS);
    private static final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server started on port " + PORT);
            
            // Test cases
            startTestClients();
            
            while (true) {
                if (clients.size() < MAX_CLIENTS) {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clients.add(clientHandler);
                    pool.execute(clientHandler);
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            pool.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(), "UTF-8"), true);
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), "UTF-8"));

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.length() <= 1000) {  // Prevent excessive messages
                        broadcast(sanitizeMessage(message));
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                cleanup();
            }
        }

        private String sanitizeMessage(String message) {
            return message.replaceAll("[<>\"&']", "");
        }

        private void broadcast(String message) {
            synchronized(clients) {
                for (ClientHandler client : clients) {
                    try {
                        client.out.println(message);
                    } catch (Exception e) {
                        client.cleanup();
                    }
                }
            }
        }

        private void cleanup() {
            try {
                clients.remove(this);
                if (out != null) out.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.err.println("Error cleaning up: " + e.getMessage());
            }
        }
    }

    // Test cases
    private static void startTestClients() {
        for (int i = 0; i < 5; i++) {
            final int clientId = i;
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", PORT);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Test message from client " + clientId);
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Test client error: " + e.getMessage());
                }
            }).start();
        }
    }
}
