package CoT.claude;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Task80 {
    public static SSLSocket createSSLSocket(String host, int port) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // Create SSL Context with TLS
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, null, null);
        
        // Create SSL Socket Factory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        
        // Get IPv6 address
        InetAddress[] addresses = InetAddress.getAllByName(host);
        Inet6Address ipv6Address = null;
        
        for (InetAddress addr : addresses) {
            if (addr instanceof Inet6Address) {
                ipv6Address = (Inet6Address) addr;
                break;
            }
        }
        
        if (ipv6Address == null) {
            throw new IOException("No IPv6 address found for host");
        }
        
        // Create SSL Socket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(ipv6Address, port);
        
        // Enable only secure protocols and cipher suites
        sslSocket.setEnabledProtocols(new String[] {"TLSv1.3"});
        
        return sslSocket;
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"ipv6.google.com", "443"},
            {"2001:4860:4860::8888", "443"},
            {"ipv6.test-ipv6.com", "443"},
            {"[2606:4700:4700::1111]", "443"},
            {"ipv6.l.google.com", "443"}
        };

        for (String[] test : testCases) {
            try {
                SSLSocket socket = createSSLSocket(test[0], Integer.parseInt(test[1]));
                System.out.println("Successfully connected to: " + test[0]);
                socket.close();
            } catch (Exception e) {
                System.out.println("Failed to connect to " + test[0] + ": " + e.getMessage());
            }
        }
    }
}
