package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;

public class Task127 {
    public static void copyFile(String sourcePath, String destDir) throws IOException {
        File sourceFile = null;
        File destFile = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            // Validate input paths
            if (sourcePath == null || destDir == null) {
                throw new IllegalArgumentException("Source or destination path cannot be null");
            }
            
            sourceFile = new File(sourcePath);
            if (!sourceFile.exists() || !sourceFile.isFile()) {
                throw new FileNotFoundException("Source file does not exist: " + sourcePath);
            }
            
            // Create destination directory if it doesn't exist\n            File destDirectory = new File(destDir);\n            if (!destDirectory.exists()) {\n                if (!destDirectory.mkdirs()) {\n                    throw new IOException("Could not create destination directory");\n                }\n            }\n            \n            // Generate unique temp file name\n            String tempFileName = UUID.randomUUID().toString() + ".tmp";\n            destFile = new File(destDirectory, tempFileName);\n            \n            // Copy file with buffer\n            fis = new FileInputStream(sourceFile);\n            fos = new FileOutputStream(destFile);\n            byte[] buffer = new byte[8192];\n            int bytesRead;\n            \n            while ((bytesRead = fis.read(buffer)) != -1) {\n                fos.write(buffer, 0, bytesRead);\n            }\n            \n        } catch (SecurityException e) {\n            throw new IOException("Security violation: " + e.getMessage(), e);\n        } finally {\n            // Close streams in finally block\n            if (fis != null) {\n                try {\n                    fis.close();\n                } catch (IOException e) {\n                    // Log error but don't mask original exception
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close(); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Valid copy
            copyFile("test.txt", "temp");
            
            // Test case 2: Null source path
            copyFile(null, "temp");
            
            // Test case 3: Non-existent source file
            copyFile("nonexistent.txt", "temp");
            
            // Test case 4: Invalid destination directory
            copyFile("test.txt", "");
            
            // Test case 5: Source is directory
            copyFile("src", "temp");
            
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
