package Vanilla.claude;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Task121 {
    public boolean uploadFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destinationPath);
        
        if (!sourceFile.exists()) {
            return false;
        }

        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            FileChannel source = fis.getChannel();
            FileChannel destination = fos.getChannel();
            destination.transferFrom(source, 0, source.size());
            
            source.close();
            destination.close();
            fis.close();
            fos.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Task121 uploader = new Task121();
        
        // Test cases
        System.out.println("Test 1: " + uploader.uploadFile("test1.txt", "upload/test1.txt"));
        System.out.println("Test 2: " + uploader.uploadFile("image.jpg", "upload/image.jpg"));
        System.out.println("Test 3: " + uploader.uploadFile("doc.pdf", "upload/doc.pdf"));
        System.out.println("Test 4: " + uploader.uploadFile("nonexistent.txt", "upload/test.txt"));
        System.out.println("Test 5: " + uploader.uploadFile("data.csv", "upload/data.csv"));
    }
}
