package CoT.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Task48 {

    private static final int PORT = 8080;
    private static final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter writer;


        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                 this.writer = out;
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcastMessage(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(writer);
                }
            }
        }


    }

    private static void broadcastMessage(String message) {

        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
                writer.flush();
            }
        }
    }

}