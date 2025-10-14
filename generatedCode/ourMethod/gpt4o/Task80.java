package ourMethod.openai;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws IOException {
        InetAddress address = Inet6Address.getByName(host);
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) factory.createSocket(address, port);
        sslSocket.startHandshake();
        return sslSocket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLSocket("localhost", 443);
            SSLSocket socket2 = createSSLSocket("example.com", 443);
            SSLSocket socket3 = createSSLSocket("ipv6.google.com", 443);
            SSLSocket socket4 = createSSLSocket("ipv6.test-ipv6.com", 443);
            SSLSocket socket5 = createSSLSocket("ipv6.facebook.com", 443);

            System.out.println("Connected to: " + socket1.getInetAddress());
            System.out.println("Connected to: " + socket2.getInetAddress());
            System.out.println("Connected to: " + socket3.getInetAddress());
            System.out.println("Connected to: " + socket4.getInetAddress());
            System.out.println("Connected to: " + socket5.getInetAddress());

            socket1.close();
            socket2.close();
            socket3.close();
            socket4.close();
            socket5.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}