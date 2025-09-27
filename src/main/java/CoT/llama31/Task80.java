package CoT.llama31;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        String host = "your_host";
        int port = 443; // Replace with your port

        SSLSocket sslSocket = createSSLSocket(host, port);
        System.out.println("Connected to " + host + ":" + port);
    }
}