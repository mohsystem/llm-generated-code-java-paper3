package Vanilla.openai;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;

public class Task80 {
    public static SSLSocket createSSLClientSocket(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetAddress address = InetAddress.getByName(host);
        if (address instanceof InetAddress && address.isReachable(2000)) {
            SSLSocket socket = (SSLSocket) factory.createSocket(address, port);
            return socket;
        }
        throw new IOException("Unable to reach host: " + host);
    }
    
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                // Example host and port (replace with actual test cases)
                String host = "example.com";
                int port = 443;
                SSLSocket socket = createSSLClientSocket(host, port);
                System.out.println("Connected to " + host + " on port " + port);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}