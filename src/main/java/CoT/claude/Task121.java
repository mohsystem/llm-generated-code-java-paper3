package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Task121 {
    private static final String UPLOAD_DIR = "uploads/";
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB limit

    public static String uploadFile(String sourceFilePath) throws Exception {
        // Input validation
        if (sourceFilePath == null || sourceFilePath.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid file path");
        }

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            throw new IllegalArgumentException("File does not exist");
        }

        // Check file size
        if (sourceFile.length() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size exceeds limit");
        }

        // Create upload directory if it doesn't exist\n
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        // Generate unique filename using hash\n
        String fileName = sourceFile.getName();
        String fileExtension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fileExtension = fileName.substring(i);
        }
        String uniqueFileName = generateUniqueFileName(sourceFile) + fileExtension;
        Path destinationPath = Paths.get(UPLOAD_DIR + uniqueFileName);
        // Secure copy of file\n
        Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        return "File uploaded successfully: " + uniqueFileName;}
    private static String generateUniqueFileName(File file) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String uniqueData = file.getName() + System.currentTimeMillis();
        byte[] hash = md.digest(uniqueData.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        return hexString.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "test2.jpg",
            "test3.pdf",
            "test4.doc",
            "test5.zip"
        };

        for (String testFile : testFiles) {
            try {
                System.out.println("Testing file: " + testFile);
                String result = uploadFile(testFile);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("------------------------");
        }
    }
}
