package CoT.claude;

import java.net.URL;
import java.util.regex.Pattern;

public class Task110 {
    public static boolean validateURL(String urlStr) {
        if (urlStr == null || urlStr.trim().isEmpty()) {
            return false;
        }
        
        // Check length to prevent DoS
        if (urlStr.length() > 2048) {
            return false;
        }
        
        // Regex pattern for URL validation
        String urlPattern = "^(https?://)?([\\\\w\\\\d-]+\\\\.)*[\\\\w\\\\d-]+\\\\.[a-zA-Z]{2,}(/[\\\\w\\\\d-./?%&=]*)?$";
        
        try {
            // Basic format check using regex
            if (!Pattern.matches(urlPattern, urlStr)) {
                return false;
            }
            
            // Validate URL syntax and components
            URL url = new URL(urlStr.startsWith("http") ? urlStr : "http://" + urlStr);
            
            // Additional checks
            if (url.getHost().isEmpty()) {
                return false;
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://www.example.com",
            "http://subdomain.example.co.uk/path?param=value",
            "invalid.url",
            "https://malicious<script>alert(1)</script>.com",
            "https://example.com/path?valid=true"
        };
        
        for (String url : testUrls) {
            System.out.println("URL: " + url + " is " + (validateURL(url) ? "valid" : "invalid"));
        }
    }
}
