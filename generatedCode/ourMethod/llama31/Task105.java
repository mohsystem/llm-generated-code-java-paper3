package ourMethod.llama31;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;

public class Task105 {
    public static void main(String[] args) {
        String host = "example.com";
        int port = 443;

        try {
            // Load trust store
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            // Create trust manager factory
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Create SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Establish connection
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);

            // Start handshake
            sslSocket.startHandshake();

            // Verify certificate
            if (!sslSocket.getSession().getPeerPrincipal().getName().equals("CN=example.com")) {
                throw new RuntimeException("Certificate verification failed");
            }

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close socket
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}