package Vanilla.gemini;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Task80 {

    public static Socket createSSLSocketIPv6(String host, int port) throws IOException {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsocketfactory.createSocket();

        InetAddress[] addresses = InetAddress.getAllByName(host);
        for (InetAddress address : addresses) {
            if (address instanceof Inet6Address) {
                InetSocketAddress sockaddr = new InetSocketAddress(address, port);
                sslSocket.connect(sockaddr);
                return sslSocket;
            }
        }

        throw new IOException("No IPv6 address found for host " + host);

    }

    public static void main(String[] args) throws IOException {
        // Replace with your test host and port. These examples are unlikely to work.
        testConnection("google.com", 443); // Standard HTTPS port
        testConnection("ipv6.google.com", 443); // Google's IPv6 address for testing
        testConnection("www.facebook.com", 443); // Another common HTTPS site

        // These two tests demonstrate error handling when using specific IPv6 literal and unavailable port
        try {
            testConnection("[::1]", 443); // Localhost IPv6 - might work if you have an HTTPS server running locally
        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }
        try {
            testConnection("google.com", 8080); // Unlikely port for HTTPS
        } catch (IOException e) {
            System.err.println("Test case failed: " + e.getMessage());
        }
    }

    private static void testConnection(String host, int port) throws IOException {
        try (Socket socket = createSSLSocketIPv6(host, port)) {
            System.out.println("Successfully connected to " + host + ":" + port + " using IPv6.");
        }
    }
}