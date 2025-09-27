package CoT.llama31;
import java.io.*;
import java.net.*;

public class Task50Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        System.out.println("Connected to server");

        File file = new File("path_to_your_file");
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        fileInputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("File uploaded successfully");
    }
}