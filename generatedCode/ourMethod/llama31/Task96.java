package ourMethod.llama31;
import java.net.*;
import java.io.*;

public class Task96 {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getInetAddress());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println(inputLine); // Echo back the message
                }
            }
        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
            System.err.println(e.getMessage());
        }
    }
}