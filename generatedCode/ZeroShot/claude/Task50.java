package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Task50 {
    private static final String UPLOAD_DIR = "uploads/";
    private static final long MAX_FILE_SIZE = 10485760; // 10MB
    private static final String[] ALLOWED_EXTENSIONS = {".txt", ".pdf", ".doc", ".docx"}; 

    public static String uploadFile(String fileName, byte[] fileContent) {
        try {
            // Create upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Validate file size
            if (fileContent.length > MAX_FILE_SIZE) {
                return "Error: File size exceeds maximum limit of 10MB";
            }

            // Validate file extension
            String extension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            boolean isAllowed = false;
            for (String allowedExt : ALLOWED_EXTENSIONS) {
                if (extension.equals(allowedExt)) {
                    isAllowed = true;
                    break;
                }
            }
            if (!isAllowed) {
                return "Error: File type not allowed";
            }

            // Generate unique filename using hash
            String uniqueFileName = generateUniqueFileName(fileName);
            Path path = Paths.get(UPLOAD_DIR + uniqueFileName);

            // Write file securely
            Files.write(path, fileContent, StandardOpenOption.CREATE_NEW);
            
            return "File uploaded successfully: " + uniqueFileName;

        } catch (IOException e) {
            return "Error: Failed to upload file - " + e.getMessage();
        }
    }

    private static String generateUniqueFileName(String originalFileName) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String toHash = originalFileName + timeStamp;
            byte[] hash = md.digest(toHash.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            return hexString.toString().substring(0, 32) + extension;
        } catch (Exception e) {
            throw new IOException("Failed to generate unique filename");
        }
    }

    public static void main(String[] args) {
        // Test cases
        byte[] testContent1 = "Test content 1".getBytes();
        byte[] testContent2 = "Test content 2".getBytes();
        byte[] largeContent = new byte[MAX_FILE_SIZE + 1];
        
        // Test case 1: Valid txt file
        System.out.println(uploadFile("test1.txt", testContent1));
        
        // Test case 2: Valid pdf file
        System.out.println(uploadFile("test2.pdf", testContent2));
        
        // Test case 3: Invalid extension
        System.out.println(uploadFile("test3.exe", testContent1));
        
        // Test case 4: File too large
        System.out.println(uploadFile("large.txt", largeContent));
        
        // Test case 5: Duplicate upload attempt
        System.out.println(uploadFile("test1.txt", testContent1));
    }
}
