package ZeroShot.gpt4o;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;

public class Task80 {
    public static SSLSocket createSSLClientSocket(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        InetAddress inetAddress = InetAddress.getByName(host);
        return (SSLSocket) factory.createSocket(inetAddress, port);
    }
    
    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLClientSocket("example.com", 443);
            System.out.println("Socket1 connected to: " + socket1.getInetAddress());
            
            SSLSocket socket2 = createSSLClientSocket("ipv6.google.com", 443);
            System.out.println("Socket2 connected to: " + socket2.getInetAddress());
            
            SSLSocket socket3 = createSSLClientSocket("www.facebook.com", 443);
            System.out.println("Socket3 connected to: " + socket3.getInetAddress());
            
            SSLSocket socket4 = createSSLClientSocket("ipv6.test-ipv6.com", 443);
            System.out.println("Socket4 connected to: " + socket4.getInetAddress());
            
            SSLSocket socket5 = createSSLClientSocket("ipv6.twitter.com", 443);
            System.out.println("Socket5 connected to: " + socket5.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}