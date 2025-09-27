package ZeroShot.claude;

import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class Task80 {
    public static SSLSocket createSecureSocket(String host, int port) throws Exception {
        // Create SSL context and initialize it with default settings
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);

        // Create SSL socket factory
        SSLSocketFactory factory = sslContext.getSocketFactory();

        // Create socket address for IPv6
        InetAddress addr = InetAddress.getByName(host);
        InetSocketAddress socketAddress = new InetSocketAddress(addr, port);

        // Create and connect the SSL socket
        SSLSocket socket = (SSLSocket) factory.createSocket();
        socket.connect(socketAddress);

        return socket;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Connect to localhost
            SSLSocket s1 = createSecureSocket("::1", 443);
            System.out.println("Test 1: Successfully connected to localhost");
            s1.close();

            // Test case 2: Connect to IPv6 Google
            SSLSocket s2 = createSecureSocket("2404:6800:4003:c04::64", 443);
            System.out.println("Test 2: Successfully connected to Google IPv6");
            s2.close();

            // Test case 3: Connect to localhost different port
            SSLSocket s3 = createSecureSocket("::1", 8443);
            System.out.println("Test 3: Successfully connected to localhost:8443");
            s3.close();

            // Test case 4: Connect to IPv6 Facebook
            SSLSocket s4 = createSecureSocket("2a03:2880:f003:c07:face:b00c:0:1", 443);
            System.out.println("Test 4: Successfully connected to Facebook IPv6");
            s4.close();

            // Test case 5: Connect to IPv6 Amazon
            SSLSocket s5 = createSecureSocket("2600:1f18:22:ce00:face:b00c:0:3", 443);
            System.out.println("Test 5: Successfully connected to Amazon IPv6");
            s5.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
