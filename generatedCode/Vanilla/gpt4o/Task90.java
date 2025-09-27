package Vanilla.gpt4o;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Task90 {

    private static final int PORT = 12345;
    private static ConcurrentHashMap<Socket, PrintWriter> clientWriters = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.put(socket, out);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    for (PrintWriter writer : clientWriters.values()) {
                        writer.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientWriters.remove(socket);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}