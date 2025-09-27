package Vanilla.claude;

// File upload operations typically require external libraries and server-side code
// Below is a simplified example using sockets
import java.io.*;
import java.net.*;

public class Task50 {
    public static String uploadFile(String filePath, String serverAddress, int port) {
        try {
            File file = new File(filePath);
            Socket socket = new Socket(serverAddress, port);
            
            // Send file name
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(file.getName());
            
            // Send file content
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, read);
            }
            
            // Get confirmation
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String confirmation = dis.readUTF();
            
            fis.close();
            dos.close();
            socket.close();
            
            return confirmation;
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(uploadFile("test1.txt", "localhost", 8080));
        System.out.println(uploadFile("test2.jpg", "localhost", 8080));
        System.out.println(uploadFile("test3.pdf", "localhost", 8080));
        System.out.println(uploadFile("test4.doc", "localhost", 8080));
        System.out.println(uploadFile("test5.zip", "localhost", 8080));
    }
}
