package ourMethod.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Task160 {
    private static final int MAX_URL_LENGTH = 2048;
    private static final int TIMEOUT_MS = 5000;
    private static final Set<String> ALLOWED_SCHEMES = new HashSet<>(Arrays.asList("http", "https"));
    private static final Pattern URL_PATTERN = Pattern.compile(
        "^(https?)://([a-zA-Z0-9.-]+)(:[0-9]{1,5})?(/[^\\\\s]*)?$"
    );
    
    public static String makeHttpRequest(String urlString) {
        if (urlString == null || urlString.trim().isEmpty()) {
            return "Error: URL cannot be null or empty";
        }
        
        urlString = urlString.trim();
        
        if (urlString.length() > MAX_URL_LENGTH) {
            return "Error: URL exceeds maximum length";
        }
        
        if (!URL_PATTERN.matcher(urlString).matches()) {
            return "Error: Invalid URL format";
        }
        
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        
        try {
            URI uri = new URI(urlString);
            String scheme = uri.getScheme();
            
            if (scheme == null || !ALLOWED_SCHEMES.contains(scheme.toLowerCase())) {
                return "Error: Only HTTP and HTTPS schemes are allowed";
            }
            
            String host = uri.getHost();
            if (host == null || host.isEmpty()) {
                return "Error: Invalid host";
            }
            
            host = host.toLowerCase();
            if (host.equals("localhost") || host.equals("127.0.0.1") || 
                host.startsWith("192.168.") || host.startsWith("10.") || 
                host.startsWith("172.16.") || host.equals("0.0.0.0")) {
                return "Error: Access to local/private network addresses is not allowed";
            }
            
            URL url = uri.toURL();
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(TIMEOUT_MS);
            conn.setReadTimeout(TIMEOUT_MS);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("User-Agent", "SecureHttpClient/1.0");
            
            int responseCode = conn.getResponseCode();
            
            if (responseCode >= 200 && responseCode < 300) {
                reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
                );
                
                StringBuilder response = new StringBuilder();
                String line;
                int maxLines = 1000;
                int lineCount = 0;
                
                while ((line = reader.readLine()) != null && lineCount < maxLines) {
                    response.append(line).append("\\n");
                    lineCount++;
                }
                
                return "Response Code: " + responseCode + "\\n" + response.toString();
            } else {
                return "Error: HTTP response code " + responseCode;
            }
            
        } catch (java.net.URISyntaxException e) {
            return "Error: Invalid URL syntax";
        } catch (java.net.MalformedURLException e) {
            return "Error: Malformed URL";
        } catch (java.net.UnknownHostException e) {
            return "Error: Unknown host";
        } catch (java.net.SocketTimeoutException e) {
            return "Error: Connection timeout";
        } catch (Exception e) {
            return "Error: " + e.getClass().getSimpleName();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (Exception ignored) {}
            if (conn != null) conn.disconnect();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1 - Valid HTTPS URL:");
        System.out.println(makeHttpRequest("https://www.example.com"));
        System.out.println();
        
        System.out.println("Test 2 - Invalid scheme:");
        System.out.println(makeHttpRequest("ftp://example.com"));
        System.out.println();
        
        System.out.println("Test 3 - Localhost blocked:");
        System.out.println(makeHttpRequest("http://localhost:8080"));
        System.out.println();
        
        System.out.println("Test 4 - Empty URL:");
        System.out.println(makeHttpRequest(""));
        System.out.println();
        
        System.out.println("Test 5 - Invalid format:");
        System.out.println(makeHttpRequest("not a valid url"));
    }
}
