package ZeroShot.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Task121 {
    public static String uploadFile(String sourcePath, String destinationDir) {
        try {
            // Validate input paths
            if (sourcePath == null || destinationDir == null) {
                throw new IllegalArgumentException("Source or destination path cannot be null");
            }

            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file does not exist");
            }

            // Create destination directory if it doesn't exist\n            File destDir = new File(destinationDir);\n            if (!destDir.exists()) {\n                destDir.mkdirs();\n            }\n\n            // Validate file size (limit to 10MB)\n            long maxSize = 10 * 1024 * 1024; // 10MB\n            if (sourceFile.length() > maxSize) {\n                throw new IllegalArgumentException("File size exceeds limit of 10MB");\n            }\n\n            // Generate unique filename using hash\n            String fileName = sourceFile.getName();\n            String fileExtension = "";\n            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                fileExtension = fileName.substring(i);
                fileName = fileName.substring(0, i);
            }
            
            String timestamp = String.valueOf(System.currentTimeMillis());
            String uniqueFileName = fileName + "_" + timestamp + fileExtension;
            
            // Create destination path
            Path destinationPath = Paths.get(destinationDir, uniqueFileName);

            // Copy file using NIO
            Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            // Verify file integrity using checksum
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] sourceChecksum = getFileChecksum(md, sourceFile);
            byte[] destChecksum = getFileChecksum(md, destinationPath.toFile());

            if (!MessageDigest.isEqual(sourceChecksum, destChecksum)) {
                Files.delete(destinationPath);
                throw new IOException("File integrity check failed");
            }

            return "File uploaded successfully to: " + destinationPath;

        } catch (Exception e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    private static byte[] getFileChecksum(MessageDigest digest, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }
        
        fis.close();
        return digest.digest();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: Upload text file");
        System.out.println(uploadFile("test.txt", "./uploads"));

        System.out.println("\\nTest Case 2: Upload non-existent file");
        System.out.println(uploadFile("nonexistent.txt", "./uploads"));

        System.out.println("\\nTest Case 3: Upload with null paths");
        System.out.println(uploadFile(null, null));

        System.out.println("\\nTest Case 4: Upload image file");
        System.out.println(uploadFile("test.jpg", "./uploads"));

        System.out.println("\\nTest Case 5: Upload to invalid directory");
        System.out.println(uploadFile("test.txt", "/invalid/path"));
    }
}
