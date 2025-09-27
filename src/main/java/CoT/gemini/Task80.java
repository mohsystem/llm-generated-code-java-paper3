package CoT.gemini;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;

public class Task80 {

    public static Socket createSSLSocket(String host, int port) throws IOException {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        Socket socket = sslsocketfactory.createSocket();
        InetAddress inetAddress = InetAddress.getByName(host);
        InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, port);
        socket.connect(socketAddress);

        return socket;

    }


    public static void main(String[] args) {
        try {
            Socket socket1 = createSSLSocket("google.com", 443);
            System.out.println("Socket 1 connected: " + socket1.isConnected());
            socket1.close();

            Socket socket2 = createSSLSocket("yahoo.com", 443);
            System.out.println("Socket 2 connected: " + socket2.isConnected());
            socket2.close();

            Socket socket3 = createSSLSocket("example.com", 443);
            System.out.println("Socket 3 connected: " + socket3.isConnected());
            socket3.close();

            Socket socket4 = createSSLSocket("wikipedia.org", 443);
            System.out.println("Socket 4 connected: " + socket4.isConnected());
            socket4.close();

            Socket socket5 = createSSLSocket("github.com", 443);
            System.out.println("Socket 5 connected: " + socket5.isConnected());
            socket5.close();


        } catch (IOException e) {
            System.err.println("Error creating SSL socket: " + e.getMessage());
        }
    }
}