package Vanilla.codestral;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;
import java.net.Socket;

public class Task80 {
    public static SSLSocket createSSLClientSocket(String host, int port) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName(host), port);
        sslSocket.startHandshake();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        SSLSocket socket1 = createSSLClientSocket("example.com", 443);
        System.out.println("Socket 1 connected: " + socket1.isConnected());
        // Repeat for other test cases
    }
}