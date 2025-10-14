package ourMethodv2.gpt4o;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Task105 {
    public static String connectToServer(String host, int port, String message) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.startHandshake();

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(message);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = input.readLine();

            socket.close();
            return response;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(connectToServer("www.example.com", 443, "GET / HTTP/1.1\nHost: www.example.com\n\n"));
        // Additional test cases
        System.out.println(connectToServer("www.google.com", 443, "GET / HTTP/1.1\nHost: www.google.com\n\n"));
        System.out.println(connectToServer("www.facebook.com", 443, "GET / HTTP/1.1\nHost: www.facebook.com\n\n"));
        System.out.println(connectToServer("www.twitter.com", 443, "GET / HTTP/1.1\nHost: www.twitter.com\n\n"));
        System.out.println(connectToServer("www.github.com", 443, "GET / HTTP/1.1\nHost: www.github.com\n\n"));
    }
}