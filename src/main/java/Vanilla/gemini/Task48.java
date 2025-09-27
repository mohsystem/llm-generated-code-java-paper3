package Vanilla.gemini;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {

    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private static Set<PrintWriter> writers = new HashSet<>();

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            writers.add(out);
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    for (PrintWriter writer : writers) {
                        writer.println(message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e);
            } finally {
                try {
                    socket.close();
                    writers.remove(out);
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e);
                }
            }
        }
    }

    static class ChatServer {
        private ServerSocket serverSocket;

        public ChatServer(int port) throws IOException {
            serverSocket = new ServerSocket(port);
        }

        public void start() throws IOException {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        }

        public static void main(String[] args) throws IOException {
            // Test Cases (demonstrative, requires separate client implementation)
            ChatServer server = new ChatServer(8080);
            server.start();
        }
    }

}