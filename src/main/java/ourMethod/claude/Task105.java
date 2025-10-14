package ourMethod.claude;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.cert.*;
import java.util.*;

public class Task105 {
    private static final int CONNECT_TIMEOUT_MS = 10000;
    private static final int READ_TIMEOUT_MS = 10000;
    private static final Set<String> ALLOWED_PROTOCOLS = new HashSet<>(Arrays.asList("TLSv1.2", "TLSv1.3"));
    
    public static String connectSecurely(String urlString) {
        if (urlString == null || urlString.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        
        if (!urlString.startsWith("https://")) {
            throw new IllegalArgumentException("Only HTTPS URLs are allowed");
        }
        
        StringBuilder response = new StringBuilder();
        HttpsURLConnection conn = null;
        
        try {
            URL url = new URL(urlString);
            
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, null);
            
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sslContext.getSocketFactory());
            conn.setHostnameVerifier(new StrictHostnameVerifier());
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(false);
            
            Optional<SSLSession> session = conn.getSSLSession();
            if (session.isEmpty() || !session.get().isValid()) {
                throw new SSLException("Invalid SSL session");
            }
            
            Certificate[] serverCerts = session.get().getPeerCertificates();
            if (serverCerts == null || serverCerts.length == 0) {
                throw new SSLException("No server certificates found");
            }
            
            for (Certificate cert : serverCerts) {
                if (cert instanceof X509Certificate) {
                    X509Certificate x509 = (X509Certificate) cert;
                    x509.checkValidity();
                }
            }
            
            int responseCode = conn.getResponseCode();
            
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), java.nio.charset.StandardCharsets.UTF_8))) {
                String line;
                int maxLines = 100;
                int lineCount = 0;
                while ((line = reader.readLine()) != null && lineCount < maxLines) {
                    response.append(line).append("\\n");
                    lineCount++;
                }
            }
            
            return "Response Code: " + responseCode + "\\n" + response.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Secure connection failed: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
    
    private static class StrictHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            if (hostname == null || hostname.trim().isEmpty()) {
                return false;
            }
            
            try {
                Certificate[] certs = session.getPeerCertificates();
                if (certs == null || certs.length == 0) {
                    return false;
                }
                
                X509Certificate x509 = (X509Certificate) certs[0];
                
                Collection<List<?>> subjectAltNames = x509.getSubjectAlternativeNames();
                if (subjectAltNames != null) {
                    for (List<?> entry : subjectAltNames) {
                        if (entry.size() >= 2) {
                            Integer type = (Integer) entry.get(0);
                            if (type == 2) {
                                String dnsName = (String) entry.get(1);
                                if (hostname.equalsIgnoreCase(dnsName)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                
                String dn = x509.getSubjectX500Principal().getName();
                String cn = extractCN(dn);
                if (cn != null && hostname.equalsIgnoreCase(cn)) {
                    return true;
                }
                
            } catch (Exception e) {
                return false;
            }
            
            return false;
        }
        
        private String extractCN(String dn) {
            if (dn == null) return null;
            String[] parts = dn.split(",");
            for (String part : parts) {
                String trimmed = part.trim();
                if (trimmed.startsWith("CN=")) {
                    return trimmed.substring(3);
                }
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        String[] testUrls = {
            "https://www.google.com",
            "https://www.github.com",
            "https://www.wikipedia.org",
            "https://www.cloudflare.com",
            "https://www.mozilla.org"
        };
        
        for (String url : testUrls) {
            try {
                System.out.println("Testing connection to: " + url);
                String result = connectSecurely(url);
                System.out.println("Success: " + result.substring(0, Math.min(100, result.length())) + "...\\n");
            } catch (Exception e) {
                System.out.println("Failed: " + e.getMessage() + "\\n");
            }
        }
    }
}
