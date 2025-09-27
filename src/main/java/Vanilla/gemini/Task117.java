package Vanilla.gemini;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Task117 {

    public static void extractArchive(String archivePath, String outputDir) throws IOException {
        if (archivePath.endsWith(".zip")) {
            extractZip(archivePath, outputDir);
        } else if (archivePath.endsWith(".tar")) {
            extractTar(archivePath, outputDir);
        } else {
            throw new IllegalArgumentException("Unsupported archive format");
        }
    }


    private static void extractZip(String zipFilePath, String destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFilePath)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String filePath = destDir + "/" + entry.getName();
                if (entry.isDirectory()) {
                    Files.createDirectories(Paths.get(filePath));
                } else {
                    Files.createDirectories(Paths.get(filePath).getParent()); // Create parent directories
                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
            }
        }
    }

    private static void extractTar(String tarFilePath, String destDir) throws IOException {
        // Implementation for tar extraction (using a library like Apache Commons Compress)
        System.err.println("TAR extraction not fully implemented in this example.");
        // In a real application, use a library for tar extraction.
    }



    public static void main(String[] args) {
        try {
            extractArchive("test1.zip", "output1");
            extractArchive("test2.zip", "output2");
            // Test case for a tar file (using a dummy file, replace with an actual tar)
            extractArchive("test.tar", "output3");
            extractArchive("test3.zip", "output3");
            extractArchive("test4.zip", "output4");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}