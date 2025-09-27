package Vanilla.gemini;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class Task50 {

    public static String uploadFile(String filePath, String serverAddress, int serverPort) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return "File not found.";
        }

        try (Socket socket = new Socket(serverAddress, serverPort);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream(file)) {

            dos.writeUTF(file.getName());
            dos.writeLong(file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return reader.readLine();

        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }

    }


    public static void main(String[] args) {
        try {
            String serverAddress = "localhost";
            int serverPort = 5000; // Replace with your server port

            System.out.println(uploadFile("test1.txt", serverAddress, serverPort));
            System.out.println(uploadFile("test2.pdf", serverAddress, serverPort));
            System.out.println(uploadFile("nonexistent.txt", serverAddress, serverPort));
            System.out.println(uploadFile("test3.jpg", serverAddress, serverPort));
            System.out.println(uploadFile("test4.zip", serverAddress, serverPort));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}