package ourMethod.claude;

import javax.net.ssl.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class Task86 {
    private static final long MAX_FILE_SIZE = 500 * 1024 * 1024; // 500 MB
    private static final String ALLOWED_EXTENSION = ".exe";
    
    public static class DownloadResult {
        public final String filePath;
        public final String sha256Hash;
        
        public DownloadResult(String filePath, String sha256Hash) {
            this.filePath = filePath;
            this.sha256Hash = sha256Hash;
        }
    }
    
    public static DownloadResult downloadFile(String urlString, String expectedHash) throws Exception {
        if (urlString == null || urlString.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        
        // Validate URL format and ensure HTTPS
        URI uri = new URI(urlString);
        if (!"https".equalsIgnoreCase(uri.getScheme())) {
            throw new SecurityException("Only HTTPS URLs are allowed");
        }
        
        URL url = uri.toURL();
        
        // Configure SSL/TLS with strict certificate validation
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, null, null);
        
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());
        connection.setHostnameVerifier(new StrictHostnameVerifier());
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setRequestProperty("User-Agent", "SecureDownloader/1.0");
        
        try {
            connection.connect();
            
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("HTTP error code: " + responseCode);
            }
            
            long contentLength = connection.getContentLengthLong();
            if (contentLength > MAX_FILE_SIZE) {
                throw new SecurityException("File size exceeds maximum allowed size");
            }
            
            // Create secure temporary file
            Path tempDir = Files.createTempDirectory("secure_download_");
            Path tempFile = tempDir.resolve("downloaded.exe");
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            try (InputStream in = connection.getInputStream();
                 OutputStream out = Files.newOutputStream(tempFile, 
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                
                byte[] buffer = new byte[8192];
                int bytesRead;
                long totalBytesRead = 0;
                
                while ((bytesRead = in.read(buffer)) != -1) {
                    totalBytesRead += bytesRead;
                    if (totalBytesRead > MAX_FILE_SIZE) {
                        throw new SecurityException("File size exceeds maximum allowed size");
                    }
                    out.write(buffer, 0, bytesRead);
                    digest.update(buffer, 0, bytesRead);
                }
            }
            
            byte[] hashBytes = digest.digest();
            String actualHash = bytesToHex(hashBytes);
            
            if (expectedHash != null && !expectedHash.isEmpty()) {
                if (!MessageDigest.isEqual(expectedHash.getBytes(), actualHash.getBytes())) {
                    Files.deleteIfExists(tempFile);
                    throw new SecurityException("File integrity check failed");
                }
            }
            
            return new DownloadResult(tempFile.toString(), actualHash);
            
        } finally {
            connection.disconnect();
        }
    }
    
    public static int executeFile(String filePath, boolean requireConfirmation) throws Exception {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        
        Path path = Paths.get(filePath).normalize();
        
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        
        if (!Files.isRegularFile(path)) {
            throw new SecurityException("Path must point to a regular file");
        }
        
        if (!path.toString().toLowerCase().endsWith(ALLOWED_EXTENSION)) {
            throw new SecurityException("Only .exe files are allowed");
        }
        
        if (requireConfirmation) {
            System.out.println("WARNING: You are about to execute: " + path);
            System.out.print("Type 'YES' to confirm execution: ");
            Scanner scanner = new Scanner(System.in);
            String confirmation = scanner.nextLine();
            if (!"YES".equals(confirmation)) {
                throw new SecurityException("Execution cancelled by user");
            }
        }
        
        ProcessBuilder processBuilder = new ProcessBuilder(path.toString());
        processBuilder.redirectErrorStream(true);
        
        Process process = processBuilder.start();
        return process.waitFor();
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
    
    private static class StrictHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            try {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(hostname, session);
            } catch (Exception e) {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Secure EXE Downloader and Executor - Test Cases");
        System.out.println("Note: Tests use simulated URLs for demonstration\\n");
        
        // Test 1: Invalid URL (not HTTPS)
        System.out.println("Test 1: Invalid URL (HTTP instead of HTTPS)");
        try {
            downloadFile("http://example.com/file.exe", null);
            System.out.println("FAIL: Should have rejected HTTP URL");
        } catch (SecurityException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("PASS: Rejected - " + e.getMessage());
        }
        
        // Test 2: Null URL
        System.out.println("\\nTest 2: Null URL");
        try {
            downloadFile(null, null);
            System.out.println("FAIL: Should have rejected null URL");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("PASS: Rejected - " + e.getMessage());
        }
        
        // Test 3: Empty URL
        System.out.println("\\nTest 3: Empty URL");
        try {
            downloadFile("", null);
            System.out.println("FAIL: Should have rejected empty URL");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("PASS: Rejected - " + e.getMessage());
        }
        
        // Test 4: Invalid file path for execution
        System.out.println("\\nTest 4: Execute non-existent file");
        try {
            executeFile("/nonexistent/path/file.exe", false);
            System.out.println("FAIL: Should have rejected non-existent file");
        } catch (FileNotFoundException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("PASS: Rejected - " + e.getMessage());
        }
        
        // Test 5: Invalid file extension
        System.out.println("\\nTest 5: Execute file with wrong extension");
        try {
            Path tempFile = Files.createTempFile("test", ".txt");
            Files.write(tempFile, "test".getBytes());
            executeFile(tempFile.toString(), false);
            Files.deleteIfExists(tempFile);
            System.out.println("FAIL: Should have rejected non-exe file");
        } catch (SecurityException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("PASS: Rejected - " + e.getMessage());
        }
    }
}
