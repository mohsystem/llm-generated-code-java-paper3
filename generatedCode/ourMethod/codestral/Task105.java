package ourMethod.codestral;
import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Task105 {
    public static void main(String[] args) throws Exception {
        String urlString = "https://example.com";
        URL url = new URL(urlString);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[] {new TrustAllCertificates()}, new java.security.SecureRandom());
        conn.setSSLSocketFactory(sslContext.getSocketFactory());

        conn.setHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    private static class TrustAllCertificates implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
    }
}