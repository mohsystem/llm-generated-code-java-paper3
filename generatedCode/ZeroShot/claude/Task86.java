package ZeroShot.claude;

import java.io.*;
import java.net.*;
import java.security.*;
import java.nio.file.*;
import javax.net.ssl.*;

public class Task86 {
    public static boolean downloadAndExecute(String urlStr) {
        if (!isValidUrl(urlStr) || !urlStr.toLowerCase().endsWith(".exe")) {
            return false;
        }
        
        try {
            // Create secure connection
            URL url = new URL(urlStr);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            // Generate unique temp filename
            String tempDir = System.getProperty("java.io.tmpdir");
            String fileName = "download_" + System.currentTimeMillis() + ".exe";
            Path filePath = Paths.get(tempDir, fileName);
            
            // Download with size limit (100MB)
            try (InputStream in = new BufferedInputStream(conn.getInputStream());
                 OutputStream out = new BufferedOutputStream(Files.newOutputStream(filePath))) {
                
                byte[] buffer = new byte[8192];
                int bytesRead;
                long totalBytes = 0;
                long maxSize = 100 * 1024 * 1024; // 100MB limit
                
                while ((bytesRead = in.read(buffer)) != -1) {
                    totalBytes += bytesRead;
                    if (totalBytes > maxSize) {
                        Files.deleteIfExists(filePath);
                        return false;
                    }
                    out.write(buffer, 0, bytesRead);
                }
            }
            
            // Execute the file
            ProcessBuilder pb = new ProcessBuilder(filePath.toString());
            pb.start();
            
            // Clean up after execution
            Files.deleteIfExists(filePath);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isValidUrl(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return url.getProtocol().equalsIgnoreCase("https");
        } catch (MalformedURLException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testUrls = {
            "https://example.com/valid.exe",
            "http://unsecure.com/file.exe",
            "https://example.com/notexe.txt",
            "invalid_url",
            "https://example.com/toolarge.exe"
        };
        
        for (String url : testUrls) {
            System.out.println("Testing URL: " + url);
            boolean result = downloadAndExecute(url);
            System.out.println("Result: " + result);
        }
    }
}
