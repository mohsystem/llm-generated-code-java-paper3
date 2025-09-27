package ZeroShot.codestral;
import java.io.*;
import java.net.*;

public class Task96 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String text;

                while ((text = reader.readLine()) != null) {
                    System.out.println("Message received from client: " + text);
                    writer.println(text);
                }

                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}