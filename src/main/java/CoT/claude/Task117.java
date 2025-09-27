package CoT.claude;

import java.io.*;
import java.util.zip.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Task117 {
    public static boolean extractZipFile(String zipFilePath, String destDirectory) {
        try {
            // Validate inputs
            if (zipFilePath == null || destDirectory == null) {
                return false;
            }
            
             //Create destination directory if it doesn't exist\n
            File destDir = new File(destDirectory);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            //Open ZIP file\n
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry entry = zipIn.getNextEntry();
            byte[] buffer = new byte[4096];
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                File newFile = new File(filePath);
                // Validate file path to prevent zip slip\n
                String canonicalDestinationDirPath = destDir.getCanonicalPath();
                String canonicalDestinationFile = newFile.getCanonicalPath();
                if (!canonicalDestinationFile.startsWith(canonicalDestinationDirPath + File.separator)) {
                    throw new SecurityException("Entry is outside of target directory");
                }
                if (!entry.isDirectory()) {
                    // Create parent directories if they don't exist
                    new File(newFile.getParent()).mkdirs();
                    
                    // Extract file
                    FileOutputStream fos = new FileOutputStream(newFile);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int len;
                    while ((len = zipIn.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                    bos.close();
                }
                entry = zipIn.getNextEntry();
            }
            zipIn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testZips = {
            "test1.zip",
            "test2.zip",
            "test3.zip",
            "test4.zip",
            "test5.zip"
        };
        
        String destDir = "extracted_files";
        
        for (String zipFile : testZips) {
            boolean result = extractZipFile(zipFile, destDir);
            System.out.println("Extracting " + zipFile + ": " + (result ? "Success" : "Failed"));
        }
    }
}
