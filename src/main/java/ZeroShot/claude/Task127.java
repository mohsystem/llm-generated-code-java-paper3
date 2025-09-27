package ZeroShot.claude;

import java.io.*;

public class Task127 {
    public static boolean copyFile(String sourcePath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);
            
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file does not exist");
            }
            
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            
            byte[] buffer = new byte[1024];
            int length;
            
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            return true;
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Error while copying file: " + e.getMessage());
            return false;
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        String tempDir = System.getProperty("java.io.tmpdir");
        
        // Test 1: Normal copy
        System.out.println("Test 1: " + copyFile("test.txt", tempDir + "/test1.txt"));
        
        // Test 2: Source file doesn't exist
        System.out.println("Test 2: " + copyFile("nonexistent.txt", tempDir + "/test2.txt"));
        
        // Test 3: Invalid source path
        System.out.println("Test 3: " + copyFile("", tempDir + "/test3.txt"));
        
        // Test 4: Invalid destination path
        System.out.println("Test 4: " + copyFile("test.txt", ""));
        
        // Test 5: No write permission (might vary based on system)
        System.out.println("Test 5: " + copyFile("test.txt", "/root/test5.txt"));
    }
}
