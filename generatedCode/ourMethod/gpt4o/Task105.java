package ourMethod.openai;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class Task105 {

    public static void main(String[] args) {
        // Example Test Cases
        establishSecureConnection("www.example.com", 443);
        establishSecureConnection("www.google.com", 443);
        establishSecureConnection("www.yahoo.com", 443);
        establishSecureConnection("www.bing.com", 443);
        establishSecureConnection("www.github.com", 443);
    }

    public static void establishSecureConnection(String host, int port) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            try (SSLSocket socket = (SSLSocket) factory.createSocket(host, port)) {
                socket.startHandshake();
                try (OutputStream out = socket.getOutputStream();
                     InputStream in = socket.getInputStream()) {
                    // Send a simple HTTP GET request
                    String request = "GET / HTTP/1.1\r\nHost: " + host + "\r\n\r\n";
                    out.write(request.getBytes());
                    out.flush();

                    // Read the response
                    byte[] buffer = new byte[1024];
                    int bytesRead = in.read(buffer);
                    System.out.println("Response from " + host + ": " + new String(buffer, 0, bytesRead));
                }
            }
        } catch (IOException e) {
            System.out.println("Error establishing connection to " + host + ": " + e.getMessage());
        }
    }
}