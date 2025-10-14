package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Pattern;

public class Task121 {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
        Arrays.asList(".txt", ".pdf", ".jpg", ".jpeg", ".png", ".gif", ".doc", ".docx")
    );
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_\\\\-\\\\.]+$");
    private static final String UPLOAD_BASE_DIR = "uploads";
    
    public static class UploadResult {
        public final boolean success;
        public final String message;
        public final String savedPath;
        
        public UploadResult(boolean success, String message, String savedPath) {
            this.success = success;
            this.message = message;
            this.savedPath = savedPath;
        }
    }
    
    public static UploadResult uploadFile(String originalFilename, byte[] fileContent) {
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            return new UploadResult(false, "Filename cannot be empty", null);
        }
        
        if (fileContent == null || fileContent.length == 0) {
            return new UploadResult(false, "File content cannot be empty", null);
        }
        
        if (fileContent.length > MAX_FILE_SIZE) {
            return new UploadResult(false, "File size exceeds maximum allowed size", null);
        }
        
        String sanitizedFilename = sanitizeFilename(originalFilename);
        if (sanitizedFilename == null) {
            return new UploadResult(false, "Invalid filename format", null);
        }
        
        String extension = getFileExtension(sanitizedFilename);
        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            return new UploadResult(false, "File type not allowed", null);
        }
        
        try {
            Path baseDir = Paths.get(UPLOAD_BASE_DIR).toAbsolutePath().normalize();
            Files.createDirectories(baseDir);
            
            String uniqueFilename = generateUniqueFilename(sanitizedFilename);
            Path targetPath = baseDir.resolve(uniqueFilename).normalize();
            
            if (!targetPath.startsWith(baseDir)) {
                return new UploadResult(false, "Invalid file path", null);
            }
            
            if (Files.exists(targetPath)) {
                return new UploadResult(false, "File already exists", null);
            }
            
            Path tempFile = Files.createTempFile(baseDir, "upload_", ".tmp");
            try {
                Files.write(tempFile, fileContent);
                Files.move(tempFile, targetPath, StandardCopyOption.ATOMIC_MOVE);
                
                Set<PosixFilePermission> perms = new HashSet<>();
                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_WRITE);
                try {
                    Files.setPosixFilePermissions(targetPath, perms);
                } catch (UnsupportedOperationException e) {
                    // Windows doesn't support POSIX permissions\n
                    }
                return new UploadResult(true, "File uploaded successfully", targetPath.toString());
            } catch (Exception e) {
                Files.deleteIfExists(tempFile);
                throw e;
            }
        } catch (Exception e) {
            return new UploadResult(false, "Upload failed: " + e.getMessage(), null);
        }
    }
    private static String sanitizeFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        String name = new File(filename).getName();
        name = name.replaceAll("[^a-zA-Z0-9_\\\\-\\\\.]", "_");
        if (name.length() > 255) {
            name = name.substring(0, 255);
        }
        if (!SAFE_FILENAME_PATTERN.matcher(name).matches()) {
            return null;
        }
        return name;
    }
    private static String getFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "";
        }
        return filename.substring(lastDot);
    }
    
    private static String generateUniqueFilename(String originalFilename) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] randomBytes = new byte[16];
            random.nextBytes(randomBytes);
            
            StringBuilder sb = new StringBuilder();
            for (byte b : randomBytes) {
                sb.append(String.format("%02x", b));
            }
            
            String extension = getFileExtension(originalFilename);
            String baseName = originalFilename.substring(0, originalFilename.length() - extension.length());
            
            return baseName + "_" + sb.toString() + extension;
        } catch (Exception e) {
            return System.currentTimeMillis() + "_" + originalFilename;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("File Upload System Test Cases\\n");
        
        // Test case 1: Valid text file
        byte[] content1 = "Hello, World!".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        UploadResult result1 = uploadFile("test_document.txt", content1);
        System.out.println("Test 1 - Valid text file: " + result1.success + " - " + result1.message);
        
        // Test case 2: Invalid extension
        byte[] content2 = "Some content".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        UploadResult result2 = uploadFile("malicious.exe", content2);
        System.out.println("Test 2 - Invalid extension: " + result2.success + " - " + result2.message);
        
        // Test case 3: Empty filename
        byte[] content3 = "Content".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        UploadResult result3 = uploadFile("", content3);
        System.out.println("Test 3 - Empty filename: " + result3.success + " - " + result3.message);
        
        // Test case 4: Path traversal attempt
        byte[] content4 = "Malicious".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        UploadResult result4 = uploadFile("../../etc/passwd.txt", content4);
        System.out.println("Test 4 - Path traversal attempt: " + result4.success + " - " + result4.message);
        
        // Test case 5: Valid image file
        byte[] content5 = new byte[1024];
        new SecureRandom().nextBytes(content5);
        UploadResult result5 = uploadFile("photo_2024.jpg", content5);
        System.out.println("Test 5 - Valid image file: " + result5.success + " - " + result5.message);
    }
}
