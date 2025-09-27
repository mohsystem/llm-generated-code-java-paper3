package CoT.claude;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Task105 {
    public static void establishSecureConnection(String host, int port) {
        try {
            // Create SSL context with TLS
            SSLContext sslContext = SSLContext.getInstance("TLS");
            
            // Initialize the SSL context with trust manager
            TrustManager[] trustManagers = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            
            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            
            // Create SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);
            
            // Enable only secure protocols
            sslSocket.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
            
            // Enable session creation
            sslSocket.setEnableSessionCreation(true);
            
            // Start SSL handshake
            sslSocket.startHandshake();
            
            System.out.println("Secure connection established with " + host);
            
            // Close the connection
            sslSocket.close();
            
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
            System.err.println("Error establishing secure connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: Google");
        establishSecureConnection("google.com", 443);
        
        System.out.println("\\nTest Case 2: GitHub");
        establishSecureConnection("github.com", 443);
        
        System.out.println("\\nTest Case 3: Amazon");
        establishSecureConnection("amazon.com", 443);
        
        System.out.println("\\nTest Case 4: Microsoft");
        establishSecureConnection("microsoft.com", 443);
        
        System.out.println("\\nTest Case 5: Invalid host");
        establishSecureConnection("invalid.domain.com", 443);
    }
}
