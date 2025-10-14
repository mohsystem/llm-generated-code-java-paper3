package CoT.openai;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetAddress address = InetAddress.getByName(host);
        SSLSocket socket = (SSLSocket) factory.createSocket(address, port);
        socket.setUseClientMode(true);
        return socket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLSocket("localhost", 443);
            System.out.println("Socket1 connected: " + socket1.isConnected());

            SSLSocket socket2 = createSSLSocket("ipv6.google.com", 443);
            System.out.println("Socket2 connected: " + socket2.isConnected());

            SSLSocket socket3 = createSSLSocket("example.com", 443);
            System.out.println("Socket3 connected: " + socket3.isConnected());

            SSLSocket socket4 = createSSLSocket("ipv6.example.com", 443);
            System.out.println("Socket4 connected: " + socket4.isConnected());

            SSLSocket socket5 = createSSLSocket("test-ipv6.com", 443);
            System.out.println("Socket5 connected: " + socket5.isConnected());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}