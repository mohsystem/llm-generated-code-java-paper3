package ourMethod.codestral;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;
import java.net.Socket;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(InetAddress.getByName(host), port);
        socket.startHandshake();
        return socket;
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket = createSSLSocket("example.com", 443);
            // Use the socket here
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}