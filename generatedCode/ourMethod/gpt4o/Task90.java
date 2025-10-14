package ourMethod.openai;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Task90 {
    private static final int PORT = 12345;
    private static final int TIMEOUT = 10000; // Timeout in milliseconds

    public static void main(String[] args) {
        ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            serverSocket.setSoTimeout(TIMEOUT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientProcessingPool.submit(() -> handleClient(clientSocket));
                } catch (SocketTimeoutException e) {
                    System.out.println("Socket timed out!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientProcessingPool.shutdown();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Echo: " + inputLine);
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