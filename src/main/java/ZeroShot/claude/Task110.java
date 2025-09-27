package ZeroShot.claude;

import java.util.regex.Pattern;

public class Task110 {
    public static boolean validateURL(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }
        
        // URL validation pattern
        String urlPattern = "^(https?:\\\\/\\\\/)?([\\\\w\\\\-]+(\\\\.[\\\\w\\\\-]+)*\\\\.[a-z]{2,})(:\\\\d+)?(\\\\/[\\\\w\\\\-\\\\.\\\\/?\\\\&=@]*)?$";
        
        try {
            return Pattern.matches(urlPattern, url.toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] urls = {
            "https://www.example.com",
            "http://subdomain.example.co.uk/path?param=1",
            "invalid url",
            "ftp://invalid.com",
            "https://valid-url.com:8080/path"
        };
        
        for (String url : urls) {
            System.out.println("URL: " + url + " is " + (validateURL(url) ? "valid" : "invalid"));
        }
    }
}
