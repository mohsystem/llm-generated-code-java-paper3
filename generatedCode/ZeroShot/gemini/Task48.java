package ZeroShot.gemini;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {

    static class Server {
        private ServerSocket serverSocket;
        private List<PrintWriter> clientWriters;

        public Server(int port) throws IOException {
            serverSocket = new ServerSocket(port);
            clientWriters = new ArrayList<>();
            System.out.println("Server started on port " + port);
        }

        public void start() {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected: " + clientSocket.getInetAddress());
                    new ClientHandler(clientSocket).start();
                } catch (IOException e) {
                    System.err.println("Error accepting client: " + e.getMessage());
                }
            }
        }

        private synchronized void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
                writer.flush(); // Ensure immediate sending
            }
        }

        private synchronized void addClientWriter(PrintWriter writer) {
            clientWriters.add(writer);
        }

        private synchronized void removeClientWriter(PrintWriter writer) {
            clientWriters.remove(writer);
        }



        class ClientHandler extends Thread {
            private Socket clientSocket;
            private PrintWriter writer;
            private BufferedReader reader;

            public ClientHandler(Socket socket) {
                this.clientSocket = socket;
            }

            @Override
            public void run() {
                try {
                    writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    addClientWriter(writer);


                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Received: " + message);
                        broadcast(message);
                    }

                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                } finally {
                    try {
                        if (reader != null) reader.close();
                        if (writer != null) writer.close();
                        if (clientSocket != null) clientSocket.close();
                        removeClientWriter(writer);

                    } catch (IOException e) {
                        System.err.println("Error closing resources: " + e.getMessage());
                    }
                }
            }
        }



        public static void main(String[] args) throws IOException {
            Server server = new Server(8080);
            server.start();
        }
    }
}