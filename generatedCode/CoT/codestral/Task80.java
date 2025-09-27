package CoT.codestral;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetSocketAddress;

public class Task80 {
    public static SSLSocket createSSLClientSocket(String host, int port) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket();
        sslSocket.connect(new InetSocketAddress(host, port));
        return sslSocket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLClientSocket("example1.com", 443);
            // Test case 1
            System.out.println("Connected to: " + socket1.getInetAddress());

            SSLSocket socket2 = createSSLClientSocket("example2.com", 8443);
            // Test case 2
            System.out.println("Connected to: " + socket2.getInetAddress());

            // Add more test cases as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}