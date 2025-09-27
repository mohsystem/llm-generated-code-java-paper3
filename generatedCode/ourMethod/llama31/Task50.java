package ourMethod.llama31;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Task50 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening for incoming connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Incoming connection from " + socket.getInetAddress());

            // Handle file upload in a separate thread to avoid blocking
            Thread thread = new Thread(() -> handleFileUpload(socket));
            thread.start();
        }
    }

    private static void handleFileUpload(Socket socket) {
        try (InputStream inputStream = socket.getInputStream()) {
            // Read file name and size
            byte[] fileNameBytes = new byte[1024];
            inputStream.read(fileNameBytes);
            String fileName = new String(fileNameBytes).trim();

            // Validate file name to prevent path traversal attacks
            if (fileName.contains("..") || fileName.contains("/")) {
                System.out.println("Invalid file name: " + fileName);
                return;
            }

            // Read file content
            File file = new File("uploads/" + fileName);
            file.getParentFile().mkdirs(); // Create directory if it does not exist

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("File uploaded successfully: " + fileName);
            // Send confirmation message back to the client
            socket.getOutputStream().write("File uploaded successfully".getBytes());
        } catch (IOException e) {
            System.out.println("Error handling file upload: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}