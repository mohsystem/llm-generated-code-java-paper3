package CoT.claude;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    private static final int PORT = 12345;
    private static HashSet<PrintWriter> writers = new HashSet<>();
    
    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                // Get client name
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name != null && !name.isEmpty()) {
                        synchronized (writers) {
                            writers.add(out);
                        }
                        break;
                    }
                }

                // Broadcast user joined
                broadcast("User " + name + " joined the chat");

                // Handle messages
                String message;
                while ((message = in.readLine()) != null) {
                    if (!message.isEmpty()) {
                        broadcast(name + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                if (name != null) {
                    broadcast("User " + name + " left the chat");
                }
                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        private void broadcast(String message) {
            synchronized (writers) {
                for (PrintWriter writer : writers) {
                    writer.println(message);
                }
            }
        }
    }
}
