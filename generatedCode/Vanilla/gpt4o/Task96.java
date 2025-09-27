package Vanilla.gpt4o;
import java.io.*;
import java.net.*;

public class Task96 {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            for (int i = 0; i < 5; i++) {
                new EchoClientThread(serverSocket.accept()).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class EchoClientThread extends Thread {
    private Socket socket;

    public EchoClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("Received: " + text);
                writer.println("Echo: " + text);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}