package CoT.gemini;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class Task105 {

    public static void establishSSLConnection(String host, int port) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket(host, port)) {
            // Enable only strong cipher suites
            String[] enabledCipherSuites = getStrongCipherSuites(socket.getSupportedCipherSuites());
            socket.setEnabledCipherSuites(enabledCipherSuites);

            // Enable only TLSv1.2 or higher
            String[] enabledProtocols = getStrongProtocols(socket.getEnabledProtocols());

            if (enabledProtocols.length == 0) {
                throw new IOException("No strong protocols supported by the server.");
            }
            socket.setEnabledProtocols(enabledProtocols);


            // Perform handshake
            socket.startHandshake();

            // Connection established, you can now read/write data
            // ...
            System.out.println("Secure connection established with " + host + ":" + port);


        }
    }


    private static String[] getStrongCipherSuites(String[] supportedCipherSuites) {
        return supportedCipherSuites; // In real application filter for strong ciphers
    }

    private static String[] getStrongProtocols(String[] enabledProtocols) {
        return new String[]{"TLSv1.2", "TLSv1.3"}; // Example: Allow TLSv1.2 and TLSv1.3
    }

    public static void main(String[] args) {
        try {
            establishSSLConnection("www.google.com", 443);
            establishSSLConnection("www.example.com", 443);
            establishSSLConnection("www.amazon.com", 443);
            // Test with invalid host
            // establishSSLConnection("invalidhost.com", 443);
            establishSSLConnection("www.wikipedia.org", 443);


        } catch (IOException e) {
            System.err.println("Error establishing SSL connection: " + e.getMessage());
        }
    }
}