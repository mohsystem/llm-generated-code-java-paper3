package Vanilla.claude;

import javax.net.ssl.*;
import java.io.*;

public class Task105 {
    public static SSLSocket createSSLConnection(String host, int port) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {}
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }
        }}, new java.security.SecureRandom());
        
        SSLSocketFactory factory = sslContext.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.startHandshake();
        return socket;
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"google.com", "443"},
            {"github.com", "443"}, 
            {"microsoft.com", "443"},
            {"amazon.com", "443"},
            {"facebook.com", "443"}
        };

        for(String[] test : testCases) {
            try {
                System.out.println("Connecting to: " + test[0]);
                SSLSocket socket = createSSLConnection(test[0], Integer.parseInt(test[1]));
                System.out.println("Successfully connected to " + test[0]);
                socket.close();
            } catch(Exception e) {
                System.out.println("Failed to connect to " + test[0] + ": " + e.getMessage());
            }
        }
    }
}
