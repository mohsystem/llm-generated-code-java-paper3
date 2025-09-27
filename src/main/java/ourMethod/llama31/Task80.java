package ourMethod.llama31;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName(host), port);
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket();
        sslSocket.connect(address);
        // Ensure the SSL handshake is completed
        sslSocket.startHandshake();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        String host = "your_host_here";
        int port = 443; // Example port
        SSLSocket sslSocket = createSSLSocket(host, port);
        System.out.println("Connected to " + host + ":" + port);
    }
}