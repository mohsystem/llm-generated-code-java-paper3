package ZeroShot.gemini;
import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Task105 {

    public static void establishSSLConnection(String urlString) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);


        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // Now you can access the secure connection
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);


        connection.disconnect();

    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        establishSSLConnection("https://www.google.com");
        establishSSLConnection("https://www.example.com");
        establishSSLConnection("https://www.amazon.com");
        establishSSLConnection("https://www.bing.com");
        establishSSLConnection("https://www.github.com");
    }
}