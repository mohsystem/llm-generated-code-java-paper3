package ZeroShot.gemini;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Task80 {

    public static SSLSocket createSSLSocketIPv6(String host, int port) throws IOException {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            InetAddress[] addresses = InetAddress.getAllByName(host);
            InetAddress ipv6Address = null;
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address) {
                    ipv6Address = address;
                    break;
                }
            }

            if (ipv6Address == null) {
                throw new IOException("No IPv6 address found for host: " + host);
            }

            SSLSocket socket = (SSLSocket) factory.createSocket(ipv6Address, port);

            return socket;
        } catch (UnknownHostException e) {
            throw new IOException("Invalid host: " + host, e);
        }
    }

    public static void main(String[] args) {
        try {
            SSLSocket socket1 = createSSLSocketIPv6("google.com", 443);
            System.out.println("Socket 1 connected: " + socket1.isConnected());
            socket1.close();

            SSLSocket socket2 = createSSLSocketIPv6("ipv6.google.com", 443);
            System.out.println("Socket 2 connected: " + socket2.isConnected());
            socket2.close();


            // Test cases with potential exceptions
            try {
                createSSLSocketIPv6("invalid-host-name", 443);
            } catch (IOException e) {
                System.out.println("Caught expected exception for invalid host: " + e.getMessage());
            }

             try {
                createSSLSocketIPv6("localhost", 443); //localhost might not have ipv6
            } catch (IOException e) {
                System.out.println("Caught expected exception for no ipv6 : " + e.getMessage());
            }


            SSLSocket socket3 = createSSLSocketIPv6("facebook.com", 443);
            System.out.println("Socket 3 connected: " + socket3.isConnected());
            socket3.close();


            SSLSocket socket4 = createSSLSocketIPv6("twitter.com", 443);
            System.out.println("Socket 4 connected: " + socket4.isConnected());
            socket4.close();


        } catch (IOException e) {
            System.err.println("Error creating socket: " + e.getMessage());
        }
    }
}