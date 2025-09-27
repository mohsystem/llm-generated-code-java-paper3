package Vanilla.gpt4o;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Task48 {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) throws IOException {
        System.out.println("Chat server started...");
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    for (PrintWriter writer : clientWriters) {
                        writer.println(message);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    clientWriters.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}