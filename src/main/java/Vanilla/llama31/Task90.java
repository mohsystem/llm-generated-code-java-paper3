package Vanilla.llama31;
import java.net.*;
import java.io.*;
import java.util.*;

public class Task90 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started. Listening for incoming connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create a new thread for each client
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                out.println("Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}