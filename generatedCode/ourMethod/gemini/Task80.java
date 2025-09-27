package ourMethod.gemini;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Task80 {

    public static SSLSocket createSSLClientSocketIPv6(String host, int port) throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket();
        sslSocket.connect(new InetSocketAddress(host, port));
        return sslSocket;
    }


    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLClientSocketIPv6("google.com", 443);
            System.out.println("Socket 1 connected: " + socket1.isConnected());
            socket1.close();

            SSLSocket socket2 = createSSLClientSocketIPv6("ipv6.google.com", 443);
            System.out.println("Socket 2 connected: " + socket2.isConnected());
            socket2.close();


            // Test cases with invalid inputs
            try {
                createSSLClientSocketIPv6("invalidhost", 443);
            } catch (IOException e) {
                System.out.println("Test case with invalid host: expected exception caught");
            }


            try {
                createSSLClientSocketIPv6("google.com", -1);
            } catch (IllegalArgumentException | IOException e) {
                System.out.println("Test case with invalid port: expected exception caught");

            }

             try {
                createSSLClientSocketIPv6(null, 443);
            } catch (IOException e) {
                System.out.println("Test case with null host: expected exception caught");
            }


        } catch (IOException e) {
            System.err.println("Error creating or connecting SSL socket: " + e.getMessage());
        }
    }
}