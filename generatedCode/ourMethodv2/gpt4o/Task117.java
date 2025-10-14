import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Task117 {

    public static void extractZip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            if (!destDir.mkdirs()) {
                throw new IOException("Failed to create destination directory");
            }
        }

        try (ZipFile zipFile = new ZipFile(zipFilePath, StandardCharsets.UTF_8)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File file = new File(destDir, entry.getName());

                if (!file.toPath().normalize().startsWith(destDir.toPath())) {
                    throw new IOException("Entry is outside of the target dir: " + entry.getName());
                }

                if (entry.isDirectory()) {
                    if (!file.isDirectory() && !file.mkdirs()) {
                        throw new IOException("Failed to create directory " + file);
                    }
                } else {
                    File parent = file.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    try (var inputStream = zipFile.getInputStream(entry)) {
                        Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            extractZip("test1.zip", "output1");
            extractZip("test2.zip", "output2");
            extractZip("test3.zip", "output3");
            extractZip("test4.zip", "output4");
            extractZip("test5.zip", "output5");
            System.out.println("Extraction completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}