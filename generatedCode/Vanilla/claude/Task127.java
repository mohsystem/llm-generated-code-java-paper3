package Vanilla.claude;

import java.io.*;

public class Task127 {
    public static void copyFile(String sourcePath, String destPath) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(destPath);
            
            byte[] buffer = new byte[1024];
            int length;
            
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            
        } catch (FileNotFoundException e) {
            throw new IOException("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            throw new IOException("Error copying file: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new IOException("Error closing streams: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"./source1.txt", "./dest1.txt"},
            {"./nonexistent.txt", "./dest2.txt"},
            {"./source3.txt", "./dest3.txt"},
            {"./source4.txt", "./dest4.txt"},
            {"./source5.txt", "./dest5.txt"}
        };

        for (int i = 0; i < testCases.length; i++) {
            try {
                System.out.println("Test case " + (i + 1) + ":");
                copyFile(testCases[i][0], testCases[i][1]);
                System.out.println("File copied successfully!");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
