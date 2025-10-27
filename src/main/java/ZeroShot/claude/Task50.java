package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Pattern;

public class Task50 {
    private static final String UPLOAD_DIR = "uploads";
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
            Arrays.asList("txt", "pdf", "jpg", "jpeg", "png", "doc", "docx")
    );

    public static String uploadFile(String filename, byte[] fileContent) {
        try {
            // Validate filename
            if (!isValidFilename(filename)) {
                return "Error: Invalid filename";
            }

            // Check file size
            if (fileContent.length > MAX_FILE_SIZE) {
                return "Error: File size exceeds maximum allowed size (10MB)";
            }

            // Check file extension
            String extension = getFileExtension(filename);
            if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
                return "Error: File type not allowed";
            }

            // Create upload directory if it doesn't exist    
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            // Sanitize filename and create unique name
            String sanitizedName = sanitizeFilename(filename);
            String uniqueFilename = generateUniqueFilename(sanitizedName);
            String filepath = UPLOAD_DIR + File.separator + uniqueFilename;
            // Write file
            Files.write(Paths.get(filepath), fileContent);
            //Calculate checksum
            String checksum = calculateChecksum(fileContent);
            return "Success: File uploaded successfully. Filename: " + uniqueFilename +
                    ", Size: " + fileContent.length + " bytes, Checksum: " + checksum;
        } catch (Exception e) {
            return "Error: Failed to upload file - " + e.getMessage();
        }
    }

    private static boolean isValidFilename(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }
        // Check for path traversal attempts
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            return false;
        }
        //Check for valid characters
        Pattern validPattern = Pattern.compile("^[a-zA-Z0-9._-]+$");
        return validPattern.matcher(filename).matches();
    }

    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0 && lastDot < filename.length() - 1) {
            return filename.substring(lastDot + 1);
        }
        return "";
    }

    private static String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    private static String generateUniqueFilename(String filename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String name = filename.substring(0, filename.lastIndexOf('.'));
        String extension = getFileExtension(filename);
        return name + "_" + timestamp + "." + extension;
    }

    private static String calculateChecksum(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(data);
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.substring(0, 16);
    }

    public static void main(String[] args) {
        System.out.println("File Upload Server - Test Cases\\n");

        // Test Case 1: Valid text file
        String result1 = uploadFile("test1.txt", "Hello World!".getBytes());
        System.out.println("Test 1: " + result1 + "\n");

        // Test Case 2: Valid PDF file (simulated)
        String result2 = uploadFile("document.pdf", "PDF content simulation".getBytes());
        System.out.println("Test 2: " + result2 + "\n");

        // Test Case 3: Invalid filename with path traversal
        String result3 = uploadFile("../../../etc/passwd", "malicious content".getBytes());
        System.out.println("Test 3: " + result3 + "\n");

        // Test Case 4: Disallowed file extension
        String result4 = uploadFile("script.exe", "executable content".getBytes());
        System.out.println("Test 4: " + result4 + "\n");

        // Test Case 5: Valid image file
        String result5 = uploadFile("photo.jpg", "JPEG image data".getBytes());
        System.out.println("Test 5: " + result5 + "\n");
    }
}
