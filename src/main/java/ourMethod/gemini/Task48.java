package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Task48 {

    private static final int PORT = 8080;
    private static final Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Chat server started on port " + PORT);

        // Test cases (commented out as they require manual client interaction)
        /*
        for (int i = 0; i < 5; i++) {
            new ClientHandler(serverSocket.accept()).start();
        }
        */

        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private String clientName;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Get client name
                out.println("Enter your name:");
                clientName = in.readLine();

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                // Broadcast join message
                broadcast(clientName + " has joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast(clientName + ": " + message);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                if (clientName != null) {
                    // Broadcast leave message
                    broadcast(clientName + " has left the chat.");

                    synchronized (clientWriters) {
                        clientWriters.remove(out);
                    }
                }
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing resources: " + e.getMessage());
                }
            }
        }
    }


    private static void broadcast(String message) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}