package CoT.claude;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

public class Task110 {
    private static final int MAX_URL_LENGTH = 2048;
    private static final Pattern VALID_SCHEME = Pattern.compile("^(https?|ftp)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_HOST = Pattern.compile("^[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(\\\\.[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    private static final Pattern IP_ADDRESS = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

    public static boolean validateURL(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }

        url = url.trim();

        if (url.length() > MAX_URL_LENGTH) {
            return false;
        }

        if (url.contains(" ") || url.contains("\n") || url.contains("\r") || url.contains("\\t")) {
            return false;
        }

        try {
            URI uri = new URI(url);

            String scheme = uri.getScheme();
            if (scheme == null || !VALID_SCHEME.matcher(scheme).matches()) {
                return false;
            }

            String host = uri.getHost();
            if (host == null || host.isEmpty()) {
                return false;
            }

            host = host.toLowerCase();

            if (!IP_ADDRESS.matcher(host).matches() && !VALID_HOST.matcher(host).matches()) {
                return false;
            }

            int port = uri.getPort();
            if (port < -1 || port > 65535) {
                return false;
            }

            String path = uri.getPath();
            if (path != null && (path.contains("..") || path.contains("//") || path.contains("\\"))) {
                return false;
            }
            String userInfo = uri.getUserInfo();
            if (userInfo != null && !userInfo.isEmpty()) {
                return false;
            }
            return true;
        } catch (URISyntaxException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testCases = {"https://www.example.com", "http://192.168.1.1:8080/path/to/resource", "ftp://files.example.org/downloads", "javascript:alert('XSS')", "https://example.com/path/../../../etc/passwd"};
        System.out.println("URL Validation Results:");
        for (int i = 0; i < testCases.length; i++) {
            boolean isValid = validateURL(testCases[i]);
            System.out.println("Test " + (i + 1) + ": " + testCases[i]);
            System.out.println("Valid: " + isValid);
            System.out.println();
        }
    }
}
