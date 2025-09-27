package CoT.llama31;
import java.net.*;
import java.io.*;

public class Task96 {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client: " + message);
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}