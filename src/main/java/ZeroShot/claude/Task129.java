package ZeroShot.claude;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Task129 {
    public static String retrieveFile(String fileName, String serverUrl) {
        if (fileName == null || fileName.isEmpty() || serverUrl == null || serverUrl.isEmpty()) {
            return "Invalid input parameters";
        }

        // Validate filename to prevent directory traversal
        if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\\\")) {
            return "Invalid filename";
        }
        try {
            URL url = new URL(serverUrl + "/" + URLEncoder.encode(fileName, "UTF-8"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    return content.toString();
                }
            }
            return "File not found or server error: " + conn.getResponseCode();
        } catch (Exception e) {
            return "Error retrieving file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String serverUrl = "https://example.com/files";                // Test cases        System.out.println("Test 1: " + retrieveFile("test.txt", serverUrl));        System.out.println("Test 2: " + retrieveFile("../secret.txt", serverUrl)); // Should fail        System.out.println("Test 3: " + retrieveFile("", serverUrl)); // Should fail        System.out.println("Test 4: " + retrieveFile("document.pdf", serverUrl));        System.out.println("Test 5: " + retrieveFile("image.jpg", serverUrl));
    }
}
