package Vanilla.claude;

import java.io.*;
import java.util.zip.*;

public class Task117 {
    public static void extractZipFile(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zipIn, filePath);
            } else {
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Extract a simple ZIP file
            extractZipFile("test1.zip", "output1");
            
            // Test case 2: Extract ZIP with nested directories
            extractZipFile("test2.zip", "output2");
            
            // Test case 3: Extract ZIP with single file
            extractZipFile("test3.zip", "output3");
            
            // Test case 4: Extract large ZIP file
            extractZipFile("test4.zip", "output4");
            
            // Test case 5: Extract ZIP with mixed content
            extractZipFile("test5.zip", "output5");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
