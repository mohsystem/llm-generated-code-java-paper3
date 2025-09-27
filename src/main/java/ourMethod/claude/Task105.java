package ourMethod.claude;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

public class Task105 {
    private SSLSocket sslSocket;
    private final String host;
    private final int port;
    
    public Task105(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void establishSecureConnection() throws Exception {
        try {
            // Create SSL context with TLS
            SSLContext sslContext = SSLContext.getInstance("TLS");
            
            // Create trust manager that validates certificate chains
            TrustManager[] trustManagers = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        try {
                            for(X509Certificate cert : certs) {
                                cert.checkValidity(); // Verify certificate is currently valid
                            }
                        } catch(Exception e) {
                            throw new RuntimeException("Certificate validation failed", e);
                        }
                    }
                }
            };
            
            sslContext.init(null, trustManagers, null);
            
            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            
            // Create SSL socket
            sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);
            
            // Enable only secure protocols
            sslSocket.setEnabledProtocols(new String[] {"TLSv1.2", "TLSv1.3"});
            
            // Enable session creation
            sslSocket.setEnableSessionCreation(true);
            
            // Require client authentication
            sslSocket.setNeedClientAuth(true);
            
            // Start SSL handshake
            sslSocket.startHandshake();
            
            System.out.println("Secure connection established successfully");
        } catch (Exception e) {
            throw new Exception("Failed to establish secure connection: " + e.getMessage());
        }
    }
    
    public void closeConnection() {
        try {
            if(sslSocket != null && !sslSocket.isClosed()) {
                sslSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"localhost", "8443"},
            {"example.com", "443"},
            {"securetestserver.com", "443"},
            {"localhost", "9443"},
            {"testssl.com", "443"}
        };
        
        for(String[] test : testCases) {
            Task105 client = new Task105(test[0], Integer.parseInt(test[1]));
            try {
                client.establishSecureConnection();
                System.out.println("Test successful for " + test[0] + ":" + test[1]);
            } catch (Exception e) {
                System.err.println("Test failed for " + test[0] + ":" + test[1] + " - " + e.getMessage());
            } finally {
                client.closeConnection();
            }
        }
    }
}
