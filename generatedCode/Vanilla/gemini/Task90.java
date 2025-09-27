package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Task90 {

    private static final int PORT = 8080;
    private static final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                clientWriters.add(writer);

                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader reader;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + clientSocket.getInetAddress());
                clientWriters.removeIf(writer -> {
                    try {
                        return writer.checkError(); // Check if the writer is still connected
                    } catch (Exception ex) {
                        return true; // Assume disconnected if an exception occurs
                    }
                });

            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static synchronized void broadcastMessage(String message) {
         List<PrintWriter> toRemove = new ArrayList<>();
        for (PrintWriter writer : clientWriters) {
            try {
                writer.println(message);
            } catch (Exception e) {
                toRemove.add(writer);
            }
        }
        clientWriters.removeAll(toRemove);
    }


}