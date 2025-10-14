package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Pattern;

public class Task50 {
    private static final String UPLOAD_DIR = "uploads";
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
            Arrays.asList("txt", "pdf", "jpg", "jpeg", "png", "gif", "doc", "docx")
    );
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+$");

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

            // Sanitize filename - remove path components
            String sanitizedFilename = Paths.get(filename).getFileName().toString();

            // Additional filename validation
            if (!SAFE_FILENAME_PATTERN.matcher(sanitizedFilename).matches()) {
                sanitizedFilename = sanitizedFilename.replaceAll("[^a-zA-Z0-9._-]", "_");
            }

            // Validate file extension
            String extension = getFileExtension(sanitizedFilename);
            if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
                return new UploadResult(false, "File type not allowed: " + extension, null);
            }

            // Validate file size
            if (fileContent == null || fileContent.length == 0) {
                return new UploadResult(false, "Empty file content", null);
            }
            if (fileContent.length > MAX_FILE_SIZE) {
                return new UploadResult(false, "File size exceeds maximum limit", null);
            }

            // Create upload directory if it doesn't exist            
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            // Generate unique filename to prevent overwriting
            String uniqueFilename = generateUniqueFilename(sanitizedFilename);
            Path targetPath = uploadPath.resolve(uniqueFilename);
            // Ensure the resolved path is within the upload directory (prevent path traversal)
            if (!targetPath.normalize().startsWith(uploadPath.normalize())) {
                return new UploadResult(false, "Invalid file path detected", null);
            }            // Write file securely
            Files.write(targetPath, fileContent,
                    StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
//                     Set file permissions (read/write for owner only)
            if (!System.getProperty("os.name").toLowerCase().contains("win")) {
                Files.setPosixFilePermissions(targetPath,
                        PosixFilePermissions.fromString("rw-------"));
            }
            return new UploadResult(true, "File uploaded successfully: " + uniqueFilename,
                    targetPath.toString());
        } catch (IOException e) {
            return new UploadResult(false,
                    "Upload failed: " + e.getMessage(), null);
        }
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
        String nameWithoutExt = originalFilename.substring(0,
                originalFilename.lastIndexOf('.') > 0 ?
                        originalFilename.lastIndexOf('.') : originalFilename.length());
        String extension = getFileExtension(originalFilename);
        return nameWithoutExt + "_" + timestamp + (extension.isEmpty() ? "" : "." + extension);
    }

    public static void main(String[] args) {
        System.out.println("=== Secure File Upload Server - Test Cases ===\\n");
        // Test Case 1: Valid text file upload
        String testContent1 = "This is a test file content.";
        UploadResult result1 = uploadFile("test_document.txt", testContent1.getBytes());
        System.out.println("Test 1 - Valid text file:");
        System.out.println("Success: " + result1.success);
        System.out.println("Message: " + result1.message);
        System.out.println();
        // Test Case 2: Valid PDF file upload
        byte[] testContent2 = new byte[1024];
        Arrays.fill(testContent2, (byte) 'A');
        UploadResult result2 = uploadFile("report.pdf", testContent2);
        System.out.println("Test 2 - Valid PDF file:");
        System.out.println("Success: " + result2.success);
        System.out.println("Message: " + result2.message);
        System.out.println();

        // Test Case 3: Invalid file extension
        UploadResult result3 = uploadFile("malicious.exe", "malware".getBytes());
        System.out.println("Test 3 - Invalid extension (.exe):");
        System.out.println("Success: " + result3.success);
        System.out.println("Message: " + result3.message);
        System.out.println();

        // Test Case 4: Path traversal attempt
        UploadResult result4 = uploadFile("../../etc/passwd.txt", "hack".getBytes());
        System.out.println("Test 4 - Path traversal attempt:");
        System.out.println("Success: " + result4.success);
        System.out.println("Message: " + result4.message);
        System.out.println();

        // Test Case 5: Empty file
        UploadResult result5 = uploadFile("empty.txt", new byte[0]);
        System.out.println("Test 5 - Empty file:");
        System.out.println("Success: " + result5.success);
        System.out.println("Message: " + result5.message);
        System.out.println();
    }
}
