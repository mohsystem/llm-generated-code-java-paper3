package ZeroShot.claude;

import java.io.*;
import java.util.zip.*;

public class Task117 {
    public static void extractZipFile(String zipFilePath, String destDirectory) {
        try {
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
        } catch (IOException e) {
            System.err.println("Error extracting zip file: " + e.getMessage());
        }
    }
    
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        File outputFile = new File(filePath);
        File parent = outputFile.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    public static void main(String[] args) {
        // Test cases
        String destDir = "extracted_files";
        
        // Test case 1: Extract a simple zip file
        extractZipFile("test1.zip", destDir);
        
        // Test case 2: Extract zip with nested directories
        extractZipFile("test2.zip", destDir);
        
        // Test case 3: Extract zip with large files
        extractZipFile("test3.zip", destDir);
        
        // Test case 4: Extract empty zip file
        extractZipFile("test4.zip", destDir);
        
        // Test case 5: Extract zip with special characters in filenames
        extractZipFile("test5.zip", destDir);
    }
}
