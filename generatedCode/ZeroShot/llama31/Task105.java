package ZeroShot.llama31;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SSLContext;
import java.security.SSLException;
import java.security.SSLSession;
import java.security.SSLSocket;
import java.security.TrustManagerFactory;

public class Task105 {
    public static void main(String[] args) throws Exception {
        String[] hosts = {"example.com", "www.google.com", "www.facebook.com"};
        int port = 443;

        for (String host : hosts) {
            establishSSLConnection(host, port);
        }
    }

    public static void establishSSLConnection(String host, int port) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }}, new java.security.SecureRandom());

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        out.println("GET / HTTP/1.1");
        out.println("Host: " + host);
        out.println("Connection: Close");
        out.println();

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        sslSocket.close();
    }
}