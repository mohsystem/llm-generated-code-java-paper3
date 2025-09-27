package ourMethod.codestral;
import java.io.*;
import java.net.*;

public class Task108 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket clientSocket = serverSocket.accept();
        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

        // object manipulation logic here
    }
}