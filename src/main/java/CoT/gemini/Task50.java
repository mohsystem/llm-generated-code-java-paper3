package CoT.gemini;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

class Task50 {

    private static final int PORT = 8080;
    private static final String UPLOAD_DIRECTORY = "uploads";

    public static void main(String[] args) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectory(uploadPath);
            }

            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        try (
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
        ) {
            long fileSize = input.readLong();
            String fileName = input.readUTF();
            String sanitizedFileName = generateSafeFileName(fileName);
            String filePath = UPLOAD_DIRECTORY + File.separator + sanitizedFileName;


            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalBytesRead = 0;
                while (totalBytesRead < fileSize && (bytesRead = input.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                }
            }
            output.writeUTF("File uploaded successfully: " + sanitizedFileName);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            clientSocket.close();
        }

    }

    private static String generateSafeFileName(String fileName) {
        String extension = "";
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            extension = fileName.substring(lastDotIndex);
        }
        return UUID.randomUUID().toString() + extension;
    }
}