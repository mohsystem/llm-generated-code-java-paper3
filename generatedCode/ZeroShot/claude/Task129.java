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
        if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")) {\n            return "Invalid filename";\n        }\n\n        try {\n            URL url = new URL(serverUrl + "/" + URLEncoder.encode(fileName, "UTF-8"));\n            HttpURLConnection conn = (HttpURLConnection) url.openConnection();\n            conn.setRequestMethod("GET");\n            conn.setConnectTimeout(5000);\n            conn.setReadTimeout(5000);\n\n            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {\n                try (BufferedReader reader = new BufferedReader(\n                        new InputStreamReader(conn.getInputStream()))) {\n                    StringBuilder content = new StringBuilder();\n                    String line;\n                    while ((line = reader.readLine()) != null) {\n                        content.append(line).append("\
");\n                    }\n                    return content.toString();\n                }\n            }\n            return "File not found or server error: " + conn.getResponseCode();\n        } catch (Exception e) {\n            return "Error retrieving file: " + e.getMessage();\n        }\n    }\n\n    public static void main(String[] args) {\n        String serverUrl = "https://example.com/files";\n        \n        // Test cases\n        System.out.println("Test 1: " + retrieveFile("test.txt", serverUrl));\n        System.out.println("Test 2: " + retrieveFile("../secret.txt", serverUrl)); // Should fail\n        System.out.println("Test 3: " + retrieveFile("", serverUrl)); // Should fail\n        System.out.println("Test 4: " + retrieveFile("document.pdf", serverUrl));\n        System.out.println("Test 5: " + retrieveFile("image.jpg", serverUrl));
    }
}
