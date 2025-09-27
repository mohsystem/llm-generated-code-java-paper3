package Vanilla.gemini;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class Task105 {

    public static void establishSSLConnection(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

        // Example: Print supported cipher suites
        String[] cipherSuites = socket.getSupportedCipherSuites();
        System.out.println("Supported Cipher Suites:");
        for (String cipherSuite : cipherSuites) {
            System.out.println(cipherSuite);
        }

        socket.close();
    }

    public static void main(String[] args) throws IOException {
        establishSSLConnection("www.google.com", 443);
        establishSSLConnection("www.example.com", 443);
        establishSSLConnection("www.amazon.com", 443);
        establishSSLConnection("www.github.com", 443);
        establishSSLConnection("www.yahoo.com", 443);

    }

}