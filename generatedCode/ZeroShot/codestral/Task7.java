package ZeroShot.codestral;
import java.io.*;
import java.net.*;

public class Task7 {
    public static void main(String[] args) {
        // TODO: Implement
    }

    public static void login(String username, String password) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("{\"type\": \"LOGIN\", \"username\": \"" + username + "\", \"password\": \"" + password + "\"}");
        // TODO: Handle response
    }
}