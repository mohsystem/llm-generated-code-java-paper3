package ZeroShot.gpt4o;
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Task105 {

    public static void establishSecureConnection(String host, int port) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }}, new java.security.SecureRandom());

            SSLSocketFactory factory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
            socket.startHandshake();

            System.out.println("Secure connection established with " + host + ":" + port);
            socket.close();
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        establishSecureConnection("www.example.com", 443);
        establishSecureConnection("www.google.com", 443);
        establishSecureConnection("www.amazon.com", 443);
        establishSecureConnection("www.facebook.com", 443);
        establishSecureConnection("www.github.com", 443);
    }
}