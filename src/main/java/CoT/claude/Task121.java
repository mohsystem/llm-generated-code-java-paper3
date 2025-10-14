package CoT.claude;

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
    private static final String UPLOAD_DIR = "uploads";
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

    public static UploadResult uploadFile(String originalFilename, byte[] fileContent) {
        try {
            // Validate filename is not null or empty
            if (originalFilename == null || originalFilename.trim().isEmpty()) {
                return new UploadResult(false, "Filename cannot be empty", null);
            }

            // Validate file content is not null
            if (fileContent == null || fileContent.length == 0) {
                return new UploadResult(false, "File content cannot be empty", null);
            }

            // Check file size
            if (fileContent.length > MAX_FILE_SIZE) {
                return new UploadResult(false, "File size exceeds maximum limit of 10MB", null);
            }

            // Sanitize filename - remove path traversal attempts
            String sanitizedFilename = new File(originalFilename).getName();

            // Validate filename pattern
            if (!SAFE_FILENAME_PATTERN.matcher(sanitizedFilename).matches()) {
                return new UploadResult(false, "Invalid filename. Use only alphanumeric characters, hyphens, underscores, and dots", null);
            }

            // Validate file extension
            String extension = getFileExtension(sanitizedFilename).toLowerCase();
            if (!ALLOWED_EXTENSIONS.contains(extension)) {
                return new UploadResult(false, "File type not allowed. Allowed types: " + ALLOWED_EXTENSIONS, null);
            }

            // Create upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            // Generate unique filename using timestamp and hash
            String uniqueFilename = generateUniqueFilename(sanitizedFilename);
            // Construct safe file path
            Path uploadPath = Paths.get(UPLOAD_DIR, uniqueFilename).normalize();
            // Verify the path is within upload directory (prevent path traversal)
            if (!uploadPath.startsWith(Paths.get(UPLOAD_DIR).toAbsolutePath().normalize())) {
                return new UploadResult(false, "Invalid upload path", null);
            }
            // Write file securely
            Files.write(uploadPath, fileContent, StandardOpenOption.CREATE_NEW);
            // Set file permissions (read/write for owner only)
            File uploadedFile = uploadPath.toFile();
            uploadedFile.setReadable(true, true);
            uploadedFile.setWritable(true, true);
            uploadedFile.setExecutable(false);
            return new UploadResult(true, "File uploaded successfully", uploadPath.toString());
        } catch (FileAlreadyExistsException e) {
            return new UploadResult(false, "File already exists", null);
        } catch (IOException e) {
            return new UploadResult(false, "Error writing file: " + e.getMessage(), null);
        } catch (Exception e) {
            return new UploadResult(false, "Unexpected error: " + e.getMessage(), null);
        }
    }

    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "";
        }
        return filename.substring(lastDot + 1);
    }

    private static String generateUniqueFilename(String originalFilename) {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            String baseName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
            String extension = getFileExtension(originalFilename);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest((baseName + timestamp).getBytes());
            String hashStr = bytesToHex(hash).substring(0, 8);
            return baseName + "_" + timestamp + "_" + hashStr + "." + extension;
        } catch (Exception e) {
            return originalFilename.replaceFirst("\\.", "_" + System.currentTimeMillis() + ".");
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== File Upload Program Test Cases ===\\n");
        // Test Case 1: Valid text file upload
        System.out.println("Test 1: Valid text file upload");
        byte[] content1 = "Hello, this is a test file content.".getBytes();
        UploadResult result1 = uploadFile("test_document.txt", content1);
        System.out.println("Success: " + result1.success);
        System.out.println("Message: " + result1.message);
        System.out.println("Path: " + result1.savedPath + "\\n");
        // Test Case 2: Invalid file extension
        System.out.println("Test 2: Invalid file extension (.exe)");
        byte[] content2 = "Malicious content".getBytes();
        UploadResult result2 = uploadFile("malware.exe", content2);
        System.out.println("Success: " + result2.success);
        System.out.println("Message: " + result2.message + "\\n");
        // Test Case 3: Path traversal attempt
        System.out.println("Test 3: Path traversal attempt");
        byte[] content3 = "Attack content".getBytes();
        UploadResult result3 = uploadFile("../../etc/passwd.txt", content3);
        System.out.println("Success: " + result3.success);
        System.out.println("Message: " + result3.message + "\\n");
        // Test Case 4: Empty filename
        System.out.println("Test 4: Empty filename");
        byte[] content4 = "Some content".getBytes();
        UploadResult result4 = uploadFile("", content4);
        System.out.println("Success: " + result4.success);
        System.out.println("Message: " + result4.message + "\\n");
        // Test Case 5: File size exceeds limit
        System.out.println("Test 5: File size exceeds limit");
        byte[] content5 = new byte[(int) (MAX_FILE_SIZE + 1)];
        Arrays.fill(content5, (byte) 'A');
        UploadResult result5 = uploadFile("large_file.txt", content5);
        System.out.println("Success: " + result5.success);
        System.out.println("Message: " + result5.message + "\\n");
    }
}
