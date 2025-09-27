package ourMethod.gemini;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Task105 {

    public static SSLSocket createSecureSocket(String host, int port) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException, CertificateException {
        // Create a trust manager that does not validate certificate chains
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//todo no suitable method found for init(CertificateException)
//method TrustManagerFactory.init(KeyStore) is not applicable
//(argument mismatch; CertificateException cannot be converted to KeyStore)
//method TrustManagerFactory.init(ManagerFactoryParameters) is not applicable
//(argument mismatch; CertificateException cannot be converted to ManagerFactoryParameters)
        //        trustManagerFactory.init((javax.security.cert.CertificateException) null); // Use null to accept all certificates


        // Create SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);


        // Create SSL socket factory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create SSL socket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);

        // Enable only strong cipher suites and TLS protocols
        String[] enabledCipherSuites = sslSocket.getSupportedCipherSuites();
        String[] enabledProtocols =  {"TLSv1.2", "TLSv1.3"}; //  Specify strong and up-to-date protocols
        sslSocket.setEnabledCipherSuites(enabledCipherSuites);
        sslSocket.setEnabledProtocols(enabledProtocols);



        return sslSocket;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException, CertificateException {
        String[] hosts = {"www.google.com", "www.example.com", "www.amazon.com", "www.wikipedia.org", "www.github.com"};
        int[] ports = {443, 443, 443, 443, 443};

        for (int i = 0; i < hosts.length; i++) {
            SSLSocket sslSocket = createSecureSocket(hosts[i], ports[i]);
            System.out.println("Connected to " + hosts[i] + ":" + ports[i] + " using " + sslSocket.getSession().getProtocol());
            sslSocket.close();
        }
    }
}