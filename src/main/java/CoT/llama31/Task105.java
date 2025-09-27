package CoT.llama31;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

public class Task105 {
    public static void main(String[] args) throws Exception {
        String[] testCases = {"localhost", "example.com", "google.com", "facebook.com", "github.com"};
        for (String testCase : testCases) {
            establishSSLConnection(testCase, 443);
        }
    }

    public static void establishSSLConnection(String host, int port) throws Exception {
        SSLContext sslContext = SSLContext.getDefault();
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);

        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

        out.println("GET / HTTP/1.1");
        out.println("Host: " + host);
        out.println("Connection: close");
        out.println();

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        sslSocket.close();
    }
}