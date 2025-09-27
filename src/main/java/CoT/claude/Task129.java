package CoT.claude;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.security.*;

public class Task129 {
    public static String retrieveFile(String fileName, String serverUrl) {
        if (fileName == null || fileName.isEmpty() || serverUrl == null || serverUrl.isEmpty()) {
            return "Invalid input parameters";
        }

        // Validate filename for security
        if (!isValidFileName(fileName)) {
            return "Invalid filename";
        }

        try {
            // Create URL with validated parameters
            URL url = new URL(serverUrl + URLEncoder.encode(fileName, "UTF-8"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Set secure connection parameters
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // Verify server certificate
            //todo missing import.
            if (conn instanceof HttpsURLConnection) {
                ((HttpsURLConnection) conn).setHostnameVerifier((hostname, session) -> hostname.equals(session.getPeerHost()));
            }

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "Server returned error: " + responseCode;
            }

            // Read response securely
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            return response.toString();

        } catch (Exception e) {
            return "Error retrieving file: " + e.getMessage();
        }
    }

    private static boolean isValidFileName(String fileName) {
        // Check for path traversal attempts
        if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\\\")) {
            return false;
        }
        // Allow only alphanumeric characters and some special chars\n
        return fileName.matches("^[a-zA-Z0-9._-]+$");
    }
//    public static void main(String[] args) {\n        // Test cases\n        String serverUrl = "https://example.com/files/";\n        \n        System.out.println("Test 1: " + retrieveFile("document.txt", serverUrl));\n        System.out.println("Test 2: " + retrieveFile("../sensitive.txt", serverUrl)); // Should fail\n        System.out.println("Test 3: " + retrieveFile("", serverUrl)); // Should fail\n        System.out.println("Test 4: " + retrieveFile("malicious;rm -rf.txt", serverUrl)); // Should fail\n        System.out.println("Test 5: " + retrieveFile("valid-document.pdf", serverUrl));
//    }
}
