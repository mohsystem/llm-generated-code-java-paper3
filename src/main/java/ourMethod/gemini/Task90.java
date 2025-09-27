package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Task90 {

    private static final int PORT = 12345;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();


            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;
        private String username;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        }


        @Override
        public void run() {
            try {
                username = in.readLine();
                broadcastMessage(username + " joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(username + ": " + message);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                if (username != null) {
                    clients.remove(this);
                    broadcastMessage(username + " left the chat.");
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }


        private void broadcastMessage(String message) {
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    client.out.println(message);
                }
            }
        }
    }
}