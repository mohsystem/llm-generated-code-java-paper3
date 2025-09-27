package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Task50 {
    private static final String UPLOAD_DIR = "uploads/";
    private static final long MAX_FILE_SIZE = 10485760; // 10MB limit
    
    public static String uploadFile(String fileName, byte[] fileData) {
        try {
            // Create upload directory if it doesn't exist
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Validate file size
            if (fileData.length > MAX_FILE_SIZE) {
                return "Error: File size exceeds limit of 10MB";
            }

            // Validate file name and sanitize
            fileName = fileName.replaceAll("[^a-zA-Z0-9.-]", "_");
            
            // Generate unique file name using hash
            String uniqueFileName = generateUniqueFileName(fileName);
            Path filePath = Paths.get(UPLOAD_DIR + uniqueFileName);

            // Write file with proper permissions
            Files.write(filePath, fileData, StandardOpenOption.CREATE_NEW);
            Files.setPosixFilePermissions(filePath, 
                PosixFilePermissions.fromString("rw-r--r--"));

            return "File uploaded successfully: " + uniqueFileName;
            
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    private static String generateUniqueFileName(String originalName) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String timeStamp = String.valueOf(System.currentTimeMillis());
            byte[] hash = md.digest((originalName + timeStamp).getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString() + "_" + originalName;
        } catch (Exception e) {
            throw new IOException("Error generating unique filename");
        }
    }

    public static void main(String[] args) {
        // Test cases
        byte[] testFile1 = "Test content 1".getBytes();
        byte[] testFile2 = "Test content 2".getBytes();
        byte[] testFile3 = new byte[MAX_FILE_SIZE + 1]; // Oversized file
        byte[] testFile4 = "Test content 4".getBytes();
        byte[] testFile5 = "Test content 5".getBytes();

        System.out.println(uploadFile("test1.txt", testFile1));
        System.out.println(uploadFile("test2.doc", testFile2));
        System.out.println(uploadFile("test3.pdf", testFile3));
        System.out.println(uploadFile("test4<script>.txt", testFile4));
        System.out.println(uploadFile("../test5.txt", testFile5));
    }
}
