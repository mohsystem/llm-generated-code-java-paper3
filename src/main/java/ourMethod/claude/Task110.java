package ourMethod.claude;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class Task110 {
    // Validate URL using multiple checks
    public static boolean isValidURL(String urlStr) {
        if (urlStr == null || urlStr.isEmpty()) {
            return false;
        }

        // Check for malicious characters
        if (containsMaliciousChars(urlStr)) {
            return false;
        }

        // Check URL format using regex
        String urlRegex = "^(https?://)?([\\\\w\\\\d.-]+)\\\\.([a-zA-Z]{2,})(:\\\\d{2,5})?(/[\\\\w\\\\d./?=#&-]*)?$";
        if (!Pattern.matches(urlRegex, urlStr)) {
            return false;
        }

        // Validate URL using Java URL class
        try {
            URL url = new URL(urlStr);
            url.toURI(); // Additional validation
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Check for malicious characters
    private static boolean containsMaliciousChars(String url) {
        String[] maliciousChars = {"<", ">", "'", "\"", ";", "(", ")", "{", "}", "|", "\\\\"};

         for (String c : maliciousChars) {
             if (url.contains(c)) {
                 return true;
             }
         }
         return false;
    }
//    public static void main(String[] args) {\n        // Test cases\n        String[] testUrls = {\n            "https://www.example.com",\n            "http://subdomain.example.co.uk/path?param=value",\n            "ftp://invalid.com", // Invalid protocol\n            "https://invalid<>.com", // Contains malicious chars\n            "not_a_url",\n            "https://example.com:8080/path"\n        };\n\n        for (String url : testUrls) {\n            System.out.println("URL: " + url + " is " + (isValidURL(url) ? "valid" : "invalid"));
//        }
//    }
}
