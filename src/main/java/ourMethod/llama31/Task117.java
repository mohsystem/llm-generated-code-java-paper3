package ourMethod.llama31;
import java.io.*;
import java.util.zip.*;

public class Task117 {
    public static void main(String[] args) {
        // Test cases
        String[] zipFiles = {"test1.zip", "test2.zip"};
        for (String zipFile : zipFiles) {
            extractZip(zipFile);
        }
    }

    public static void extractZip(String zipFile) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    // Ensure directory path is safe to avoid path traversal
                    String safeDir = entry.getName().replaceAll("\\.\\./", "").replaceAll("/", File.separator);
                    new File(safeDir).mkdirs();
                } else {
                    // Ensure file path is safe to avoid path traversal
                    String safeFile = entry.getName().replaceAll("\\.\\./", "").replaceAll("/", File.separator);
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(safeFile))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error extracting ZIP file: " + e.getMessage());
        }
    }

    // For TAR files, you would need an external library like Apache Commons Compress
    // public static void extractTar(String tarFile) { ... }
}