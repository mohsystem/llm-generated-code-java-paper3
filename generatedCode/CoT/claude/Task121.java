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

        // Create upload directory if it doesn't exist\n        File uploadDir = new File(UPLOAD_DIR);\n        if (!uploadDir.exists()) {\n            uploadDir.mkdirs();\n        }\n\n        // Generate unique filename using hash\n        String fileName = sourceFile.getName();\n        String fileExtension = "";\n        int i = fileName.lastIndexOf('.');\n        if (i > 0) {\n            fileExtension = fileName.substring(i);\n        }\n        \n        String uniqueFileName = generateUniqueFileName(sourceFile) + fileExtension;\n        Path destinationPath = Paths.get(UPLOAD_DIR + uniqueFileName);\n\n        // Secure copy of file\n        Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);\n        \n        return "File uploaded successfully: " + uniqueFileName;\n    }\n\n    private static String generateUniqueFileName(File file) throws Exception {\n        MessageDigest md = MessageDigest.getInstance("SHA-256");\n        String uniqueData = file.getName() + System.currentTimeMillis();\n        byte[] hash = md.digest(uniqueData.getBytes());\n        StringBuilder hexString = new StringBuilder();\n        \n        for (byte b : hash) {\n            String hex = Integer.toHexString(0xff & b);\n            if (hex.length() == 1) hexString.append('0');
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
