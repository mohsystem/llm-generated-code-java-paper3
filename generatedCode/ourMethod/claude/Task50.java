package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task50 {
    private static final String UPLOAD_DIR = "uploads/";
    private static final long MAX_FILE_SIZE = 10485760; // 10MB
    private static final String[] ALLOWED_EXTENSIONS = {".txt", ".pdf", ".doc", ".docx"}; 
    
    public String uploadFile(String fileName, byte[] fileContent) {
        try {
            // Validate inputs
            if (fileName == null || fileName.trim().isEmpty() || fileContent == null) {
                return "Invalid input parameters";
            }

            // Validate file size
            if (fileContent.length > MAX_FILE_SIZE) {
                return "File size exceeds maximum allowed size of 10MB";
            }

            // Validate file extension
            String extension = getFileExtension(fileName);
            if (!isAllowedExtension(extension)) {
                return "File type not allowed";
            }

            // Create upload directory if it doesn't exist\n            Path uploadPath = Paths.get(UPLOAD_DIR);\n            if (!Files.exists(uploadPath)) {\n                Files.createDirectories(uploadPath);\n            }\n\n            // Generate unique file name using hash\n            String uniqueFileName = generateUniqueFileName(fileName);\n            Path filePath = uploadPath.resolve(uniqueFileName);\n\n            // Write file using NIO\n            Files.write(filePath, fileContent);\n\n            return "File uploaded successfully: " + uniqueFileName;\n\n        } catch (IOException e) {\n            return "Error uploading file: " + e.getMessage();\n        }\n    }\n\n    private String getFileExtension(String fileName) {\n        int lastDot = fileName.lastIndexOf('.');
        if (lastDot == -1) {
            return "";
        }
        return fileName.substring(lastDot).toLowerCase();
    }

    private boolean isAllowedExtension(String extension) {
        for (String allowed : ALLOWED_EXTENSIONS) {
            if (allowed.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    private String generateUniqueFileName(String originalFileName) {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            String toHash = originalFileName + timestamp;
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toHash.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            
            String extension = getFileExtension(originalFileName);
            return hexString.toString() + extension;
            
        } catch (NoSuchAlgorithmException e) {
            return System.currentTimeMillis() + "_" + originalFileName;
        }
    }

    public static void main(String[] args) {
        Task50 uploader = new Task50();
        
        // Test case 1: Valid file upload
        System.out.println(uploader.uploadFile("test.txt", "Hello World".getBytes()));
        
        // Test case 2: Invalid extension
        System.out.println(uploader.uploadFile("test.exe", "Malicious".getBytes()));
        
        // Test case 3: Empty file name
        System.out.println(uploader.uploadFile("", "Empty".getBytes()));
        
        // Test case 4: Null content
        System.out.println(uploader.uploadFile("test.txt", null));
        
        // Test case 5: Large file
        byte[] largeContent = new byte[20_000_000];
        System.out.println(uploader.uploadFile("large.txt", largeContent));
    }
}
