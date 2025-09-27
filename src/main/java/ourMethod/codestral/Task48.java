package ourMethod.codestral;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    private static final int PORT = 1234;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Chat Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            clientHandler.start();
        }
    }

    private static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    broadcastMessage(message, this);
                }

                clients.remove(this);
                socket.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}