package ZeroShot.llama31;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        return socket;
    }

    public static void main(String[] args) throws Exception {
        String[] hosts = {"::1", "ipv6.example.com"};
        int[] ports = {443, 443};

        for (int i = 0; i < hosts.length; i++) {
            SSLSocket socket = createSSLSocket(hosts[i], ports[i]);
            System.out.println("Connected to " + hosts[i] + ":" + ports[i]);
            socket.close();
        }
    }
}