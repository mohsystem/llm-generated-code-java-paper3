package ourMethod.codestral;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class Task7 {
    // ...
    // Server-side code to handle client connections and authentication
    // ...

    // Client-side code to capture user credentials, construct login request, and send it to the server
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4444);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Hash the password for secure transmission and storage
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        String hashedPassword = Base64.getEncoder().encodeToString(hash);

        // Send the login request to the server
        out.println(username + ":" + hashedPassword);
    }
}