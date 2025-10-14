package ourMethodv2.gpt4o;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetAddress address = InetAddress.getByName(host);
        SSLSocket socket = (SSLSocket) factory.createSocket(address, port);
        return socket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLSocket("example.com", 443);
            System.out.println("Connected to example.com:443");
            SSLSocket socket2 = createSSLSocket("ipv6.google.com", 443);
            System.out.println("Connected to ipv6.google.com:443");
            SSLSocket socket3 = createSSLSocket("www.example.org", 443);
            System.out.println("Connected to www.example.org:443");
            SSLSocket socket4 = createSSLSocket("www.example.net", 443);
            System.out.println("Connected to www.example.net:443");
            SSLSocket socket5 = createSSLSocket("www.example.edu", 443);
            System.out.println("Connected to www.example.edu:443");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}