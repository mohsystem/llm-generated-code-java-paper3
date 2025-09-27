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
            
            // Create destination directory if it doesn't exist\n
            File destDirectory = new File(destDir);
            if (!destDirectory.exists()) {
                if (!destDirectory.mkdirs()) {
                    throw new IOException("Could not create destination directory");
                }
            }
            // Generate unique temp file name\n
            String tempFileName = UUID.randomUUID().toString() + ".tmp";
            destFile = new File(destDirectory, tempFileName);
            // Copy file with buffer\n
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (SecurityException e) {
            throw new IOException("Security violation: " + e.getMessage(), e);
        } finally {
            // Close streams in finally block\n
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // Log error but don't mask original exception
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
}
