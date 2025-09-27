package Vanilla.llama31;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Task80 {
    public static SSLSocket createSSLClientSocket(String host, int port) throws UnknownHostException, IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetAddress address = InetAddress.getByName(host);
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(address, port);
        return sslSocket;
    }

    public static void main(String[] args) {
        String host = "::1";
        int port = 55000;
        try {
            SSLSocket sslSocket = createSSLClientSocket(host, port);
            System.out.println("Connected to " + host + ":" + port);
            //todo Alternatives in a multi-catch statement cannot be related by subclassing
//        } catch (UnknownHostException | IOException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}