package ourMethod.claude;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task90 {
    private static final int PORT = 12345;
    private static HashSet<PrintWriter> writers = new HashSet<>();
    
    public static void main(String[] args) {
        System.out.println("Chat server is running on port " + PORT);
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
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

                out.println("NAMEACCEPTED " + name);
                broadcast(name + " has joined");

                // Process messages
                String input;
                while ((input = in.readLine()) != null) {
                    if (!input.isEmpty()) {
                        broadcast(name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                if (name != null) {
                    broadcast(name + " has left");
                }
                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
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
