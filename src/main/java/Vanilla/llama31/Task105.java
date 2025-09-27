package Vanilla.llama31;
import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
//import java.security.SSLHandshakeException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Task105 {
    public static void main(String[] args) {
        String[] testCases = {"www.example.com", "www.google.com", "www.ssl.com", "www.acunetix.com", "www.geeksforgeeks.org"};
        for (String testCase : testCases) {
            try {
                establishSSLConnection(testCase, 443);
            } catch (Exception e) {
                System.out.println("Error connecting to " + testCase + ": " + e.getMessage());
            }
        }
    }

    public static void establishSSLConnection(String host, int port) throws IOException, NoSuchAlgorithmException, KeyManagementException, SSLHandshakeException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, null);

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName(host), port);

        System.out.println("Connected to " + host + ":" + port);

        try (PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()))) {

            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println();
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}