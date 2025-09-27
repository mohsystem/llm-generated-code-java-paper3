package ZeroShot.codestral;
import javax.net.ssl.*;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        SSLSocket sslSocket = createSSLSocket("example.com", 443);
        // Do something with the socket...
        sslSocket.close();
    }
}