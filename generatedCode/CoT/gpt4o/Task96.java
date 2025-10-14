package CoT.openai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Task96 {
    public static void startJavaServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Java server listening on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Received: " + line);
                        writer.println(line);
                    }
                } catch (Exception e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Thread(() -> startJavaServer(5001)).start();
    }
}