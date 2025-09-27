package Vanilla.llama31;
import java.net.*;
import java.io.*;

public class Task96 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening for incoming connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received from client: " + message);
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the socket
            socket.close();
        }
    }
}