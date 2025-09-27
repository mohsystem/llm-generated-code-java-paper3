package ourMethod.codestral;
import java.io.*;
import java.net.*;

public class Task50 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int files = in.readInt();
            for (int i = 0; i < files; i++) {
                long size = in.readLong();
                String fileName = in.readUTF();
                FileOutputStream fos = new FileOutputStream(fileName);
                byte[] buffer = new byte[1024];
                while (size > 0 && in.read(buffer, 0, (int) Math.min(buffer.length, size)) != -1) {
                    fos.write(buffer);
                    size -= buffer.length;
                }
                fos.close();
            }
            out.writeUTF("Files uploaded successfully.");
            socket.close();
        }
    }
}