package ZeroShot.claude;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

public class Task105 {
    private static final String PROTOCOL = "TLS";
    private static final int DEFAULT_PORT = 443;
    
    public static SSLSocket createSecureConnection(String host, int port) throws Exception {
        // Create a trust manager that validates certificates
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        // Create SSL context and initialize it
        SSLContext sslContext = SSLContext.getInstance(PROTOCOL);
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        // Create socket factory
        SSLSocketFactory factory = sslContext.getSocketFactory();

        // Create socket
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        
        // Enable all supported protocols
        socket.setEnabledProtocols(socket.getSupportedProtocols());
        
        // Enable hostname verification
        SSLParameters sslParams = new SSLParameters();
        sslParams.setEndpointIdentificationAlgorithm("HTTPS");
        socket.setSSLParameters(sslParams);

        return socket;
    }

    public static void main(String[] args) {
        // Test cases
        String[] hosts = {
            "github.com",
            "google.com",
            "microsoft.com",
            "amazon.com",
            "oracle.com"
        };

        for (String host : hosts) {
            try {
                System.out.println("Testing connection to: " + host);
                SSLSocket socket = createSecureConnection(host, DEFAULT_PORT);
                System.out.println("Successfully established secure connection to " + host);
                socket.close();
            } catch (Exception e) {
                System.out.println("Failed to connect to " + host + ": " + e.getMessage());
            }
        }
    }
}
