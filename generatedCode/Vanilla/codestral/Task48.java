package Vanilla.codestral;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    // Server code
    public static void main(String[] args) throws IOException {
        // ... set up server socket and accept connections
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private ArrayList<ClientHandler> clients;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket, ArrayList<ClientHandler> clients) {
            // ... initialize the client handler
        }

        @Override
        public void run() {
            // ... read messages from client and broadcast to all clients
        }

        public void sendMessage(String message) {
            // ... send message to client
        }
    }
}