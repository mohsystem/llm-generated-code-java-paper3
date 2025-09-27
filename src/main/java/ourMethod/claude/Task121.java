package ourMethod.claude;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task121 {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final String UPLOAD_DIR = "uploads";
    private static final String[] ALLOWED_EXTENSIONS = {".txt", ".pdf", ".doc", ".docx"};
    
    public boolean uploadFile(String fileName, byte[] fileContent) {
        try {
            // Validate file name
            if (fileName == null || fileName.trim().isEmpty()) {
                throw new IllegalArgumentException("File name cannot be empty");
            }
            
            // Validate file size
            if (fileContent == null || fileContent.length > MAX_FILE_SIZE) {
                throw new IllegalArgumentException("File size exceeds limit or is empty");
            }
            
            // Sanitize and validate file name
            String safeName = sanitizeFileName(fileName);
            if (!isValidExtension(safeName)) {
                throw new IllegalArgumentException("Invalid file extension");
            }
            
            // Create upload directory if it doesn't exist\n
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists() && !uploadDir.mkdirs()) {
                throw new IOException("Could not create upload directory");
            }
            // Create file path and ensure it's within upload directory
            File file = new File(uploadDir, safeName);
            String canonicalUploadPath = uploadDir.getCanonicalPath();
            String canonicalFilePath = file.getCanonicalPath();
            
            if (!canonicalFilePath.startsWith(canonicalUploadPath)) {
                throw new SecurityException("Invalid file path");
            }
            
            // Write file
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileContent);
            }
            
            return true;
        } catch (Exception e) {
            System.err.println("Error uploading file: " + e.getMessage());
            return false;
        }
    }
    
    private String sanitizeFileName(String fileName) {
        // Remove path traversal characters and invalid chars
        String name = new File(fileName).getName();
        return name.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
    
    private boolean isValidExtension(String fileName) {
        String lowerFileName = fileName.toLowerCase();
        for (String ext : ALLOWED_EXTENSIONS) {
            if (lowerFileName.endsWith(ext.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    // Test cases
    public static void main(String[] args) {
        Task121 uploader = new Task121();
        
        // Test case 1: Valid file upload
        System.out.println("Test 1: " + uploader.uploadFile(
            "test.txt", "Hello World".getBytes()));
        
        // Test case 2: Invalid extension
        System.out.println("Test 2: " + uploader.uploadFile(
            "malicious.exe", "data".getBytes()));
        
        // Test case 3: Path traversal attempt
        System.out.println("Test 3: " + uploader.uploadFile(
            "../../../etc/passwd", "data".getBytes()));
        
        // Test case 4: Empty file
        System.out.println("Test 4: " + uploader.uploadFile(
            "empty.txt", new byte[0]));
        
        // Test case 5: Null filename
        System.out.println("Test 5: " + uploader.uploadFile(
            null, "data".getBytes()));
    }
}
