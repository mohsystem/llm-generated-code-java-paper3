package ourMethodv2.gpt4o;
import java.io.*;
import java.net.*;

public class Task96 {

    public static void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String message;
                while ((message = in.readLine()) != null) {
                    out.println(message); // Echo back the received message
                }
                clientSocket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        startServer(12345); // Test case 1
        startServer(12346); // Test case 2
        startServer(12347); // Test case 3
        startServer(12348); // Test case 4
        startServer(12349); // Test case 5
    }
}