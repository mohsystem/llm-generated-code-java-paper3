package ZeroShot.llama31;
import java.net.*;
import java.io.*;
import java.util.*;

public class Task90 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started. Listening for incoming connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            // Start a new thread for each client
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandler.start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client: " + message);
                    writer.println("Server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}