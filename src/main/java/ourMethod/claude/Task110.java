package ourMethod.claude;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

public class Task110 {
    private static final int MAX_URL_LENGTH = 2048;
    private static final Pattern VALID_SCHEME = Pattern.compile("^(https?|ftp)$");
    private static final Pattern VALID_HOST = Pattern.compile("^[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(\\\\.[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");

    public static boolean validateURL(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }

        if (url.length() > MAX_URL_LENGTH) {
            return false;
        }

        String trimmedUrl = url.trim();
        if (trimmedUrl.isEmpty()) {
            return false;
        }

        try {
            URI uri = new URI(trimmedUrl);

            String scheme = uri.getScheme();
            if (scheme == null || !VALID_SCHEME.matcher(scheme.toLowerCase()).matches()) {
                return false;
            }

            String host = uri.getHost();
            if (host == null || host.isEmpty()) {
                return false;
            }

            if (!VALID_HOST.matcher(host).matches()) {
                try {
                    java.net.InetAddress.getByName(host);
                } catch (Exception e) {
                    return false;
                }
            }

            int port = uri.getPort();
            if (port < -1 || port > 65535) {
                return false;
            }

            String path = uri.getPath();
            if (path != null && (path.contains("..") || path.contains("//") || path.contains("\\"))) {
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
        String[] testCases = {"https://www.example.com", "http://example.com/path/to/resource", "ftp://ftp.example.com:21/file.txt", "javascript:alert('xss')", "http://.invalid..domain/path"};
        for (String testUrl : testCases) {
            boolean result = validateURL(testUrl);
            System.out.println("URL: " + testUrl + " -> Valid: " + result);
        }
    }
}
