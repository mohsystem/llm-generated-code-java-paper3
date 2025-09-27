package ourMethod.codestral;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task90 {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println(inputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 8080 or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}