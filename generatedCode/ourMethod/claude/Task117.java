package ourMethod.claude;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Task117 {
    public static void extractArchive(String archivePath, String destPath) throws IOException {
        // Validate input paths
        if (archivePath == null || destPath == null) {
            throw new IllegalArgumentException("Archive path and destination path cannot be null");
        }

        // Convert to canonical paths to prevent path traversal
        File archiveFile = new File(archivePath).getCanonicalFile();
        File destDir = new File(destPath).getCanonicalFile();

        // Verify archive exists and is a file
        if (!archiveFile.exists() || !archiveFile.isFile()) {
            throw new IllegalArgumentException("Archive file does not exist or is not a file");
        }

        // Create destination directory if it doesn't exist
        if (!destDir.exists() && !destDir.mkdirs()) {
            throw new IOException("Could not create destination directory");
        }

        // Verify destination is a directory
        if (!destDir.isDirectory()) {
            throw new IllegalArgumentException("Destination path must be a directory");
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(archiveFile))) {
            ZipEntry entry;
            byte[] buffer = new byte[1024];

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();

                // Validate zip entry path to prevent zip slip
                Path destPath1 = Paths.get(destDir.getPath(), fileName).normalize();
                if (!destPath1.startsWith(destDir.toPath())) {
                    throw new IOException("Bad zip entry: " + fileName);
                }

                File newFile = destPath1.toFile();

                // Create parent directories if needed
                File parent = newFile.getParentFile();
                if (parent != null && !parent.exists() && !parent.mkdirs()) {
                    throw new IOException("Could not create directory: " + parent);
                }

                // Extract file
                if (!entry.isDirectory()) {
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Extract valid zip file
            extractArchive("test1.zip", "output1/");

            // Test case 2: Extract zip with nested directories
            extractArchive("test2.zip", "output2/");

            // Test case 3: Extract empty zip file  
            extractArchive("test3.zip", "output3/");

            // Test case 4: Invalid archive path
            extractArchive("nonexistent.zip", "output4/");

            // Test case 5: Invalid destination path
            extractArchive("test5.zip", "/invalid/path/");

        } catch (IOException e) {
            System.err.println("Error extracting archive: " + e.getMessage());
        }
    }
}
