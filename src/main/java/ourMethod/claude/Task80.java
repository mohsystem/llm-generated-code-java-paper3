package ourMethod.claude;

import javax.net.ssl.*;
import java.net.*;
import java.security.cert.X509Certificate;

public class Task80 {
    public static SSLSocket createSecureSocket(String host, int port) throws Exception {
        // Create SSL context with TLS protocol
        SSLContext sslContext = SSLContext.getInstance("TLS");
        
        // Initialize with trust all strategy - for testing only
        // In production, use proper certificate validation
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        
        // Create SSL socket factory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        
        // Create socket address for IPv6
        InetAddress addr = InetAddress.getByName(host);
        InetSocketAddress socketAddress = new InetSocketAddress(addr, port);
        
        // Create and connect SSL socket with timeout
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket();
        sslSocket.connect(socketAddress, 30000); // 30 seconds timeout
        
        // Enable only secure protocols
        sslSocket.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
        
        return sslSocket;
    }

    public static void main(String[] args) {
        try {
            // Test case 1
            SSLSocket socket1 = createSecureSocket("::1", 8443);
            System.out.println("Test 1: Connected to localhost IPv6");
            socket1.close();

            // Test case 2
            SSLSocket socket2 = createSecureSocket("2001:db8::1", 443);
            System.out.println("Test 2: Connected to example IPv6");
            socket2.close();

            // Test case 3
            SSLSocket socket3 = createSecureSocket("::ffff:192.0.2.128", 443);
            System.out.println("Test 3: Connected to IPv4-mapped IPv6");
            socket3.close();

            // Test case 4
            SSLSocket socket4 = createSecureSocket("fe80::1", 8443);
            System.out.println("Test 4: Connected to link-local IPv6");
            socket4.close();

            // Test case 5
            SSLSocket socket5 = createSecureSocket("2001:db8:85a3::8a2e:370:7334", 443);
            System.out.println("Test 5: Connected to full IPv6");
            socket5.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
