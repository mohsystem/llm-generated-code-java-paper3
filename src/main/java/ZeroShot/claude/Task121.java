package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Pattern;

public class Task121 {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
            Arrays.asList("txt", "pdf", "jpg", "jpeg", "png", "doc", "docx")
    );
    private static final String UPLOAD_DIRECTORY = "uploads";
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_\\\\-\\\\.]+$");

    public static class UploadResult {
        public boolean success;
        public String message;
        public String savedPath;

        public UploadResult(boolean success, String message, String savedPath) {
            this.success = success;
            this.message = message;
            this.savedPath = savedPath;
        }
    }

    public static UploadResult uploadFile(String filename, byte[] fileContent) {
        try {
            // Validate filename
            if (filename == null || filename.trim().isEmpty()) {
                return new UploadResult(false, "Invalid filename", null);
            }

            // Sanitize filename
            String sanitizedFilename = sanitizeFilename(filename);
            if (sanitizedFilename == null) {
                return new UploadResult(false, "Filename contains invalid characters", null);
            }

            // Check file extension
            String extension = getFileExtension(sanitizedFilename);
            if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
                return new UploadResult(false, "File type not allowed", null);
            }

            // Validate file size
            if (fileContent == null || fileContent.length == 0) {
                return new UploadResult(false, "Empty file", null);
            }
            if (fileContent.length > MAX_FILE_SIZE) {
                return new UploadResult(false, "File size exceeds maximum limit", null);
            }

            // Create upload directory if it doesn't exist            
            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }            // Generate unique filename to prevent overwriting
            String uniqueFilename = generateUniqueFilename(sanitizedFilename);
            Path filePath = uploadPath.resolve(uniqueFilename);
            // Prevent path traversal
            if (!filePath.normalize().startsWith(uploadPath.normalize())) {
                return new UploadResult(false, "Invalid file path", null);
            }
            // Write file
            Files.write(filePath, fileContent);
            return new UploadResult(true, "File uploaded successfully", filePath.toString());
        } catch (IOException e) {
            return new UploadResult(false, "Error uploading file: " + e.getMessage(), null);
        }
    }

    private static String sanitizeFilename(String filename) {        // Remove path components
        String baseName = new File(filename).getName();
        // Check if filename matches safe pattern
        if (!SAFE_FILENAME_PATTERN.matcher(baseName).matches()) {
            return null;
        }
        return baseName;
    }

    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0 && lastDot < filename.length() - 1) {
            return filename.substring(lastDot + 1);
        }
        return "";
    }

    private static String generateUniqueFilename(String originalFilename) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nameWithoutExt = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        String extension = getFileExtension(originalFilename);
        return nameWithoutExt + "_" + timestamp + "." + extension;
    }

    public static void main(String[] args) {
        System.out.println("=== File Upload Program - Test Cases ===\\n");

        // Test Case 1: Valid text file
        System.out.println("Test Case 1: Valid text file");
        byte[] content1 = "Hello, this is a test file.".getBytes();
        UploadResult result1 = uploadFile("test.txt", content1);
        System.out.println("Success: " + result1.success);
        System.out.println("Message: " + result1.message);
        System.out.println("Path: " + result1.savedPath + "\\n");

        // Test Case 2: Valid PDF file
        System.out.println("Test Case 2: Valid PDF file");
        byte[] content2 = new byte[1024];
        Arrays.fill(content2, (byte) 0x50);
        UploadResult result2 = uploadFile("document.pdf", content2);
        System.out.println("Success: " + result2.success);
        System.out.println("Message: " + result2.message);
        System.out.println("Path: " + result2.savedPath + "\\n");

        // Test Case 3: Invalid file extension
        System.out.println("Test Case 3: Invalid file extension");
        byte[] content3 = "Executable content".getBytes();
        UploadResult result3 = uploadFile("malicious.exe", content3);
        System.out.println("Success: " + result3.success);
        System.out.println("Message: " + result3.message + "\\n");

        // Test Case 4: File too large
        System.out.println("Test Case 4: File too large");
        byte[] content4 = new byte[(int) (MAX_FILE_SIZE + 1)];
        UploadResult result4 = uploadFile("large_file.txt", content4);
        System.out.println("Success: " + result4.success);
        System.out.println("Message: " + result4.message + "\\n");

        // Test Case 5: Path traversal attempt
        System.out.println("Test Case 5: Path traversal attempt");
        byte[] content5 = "Malicious content".getBytes();
        UploadResult result5 = uploadFile("../../etc/passwd.txt", content5);
        System.out.println("Success: " + result5.success);
        System.out.println("Message: " + result5.message + "\\n");
    }
}
