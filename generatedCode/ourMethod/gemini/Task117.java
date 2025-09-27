package ourMethod.gemini;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;


public class Task117 {

    public static void extractArchive(String archivePath, String destPath) throws IOException {

        if (archivePath.endsWith(".zip")) {
            extractZip(archivePath, destPath);
        } else if (archivePath.endsWith(".tar.gz") || archivePath.endsWith(".tgz")) {
            extractTarGz(archivePath, destPath);
        } else if (archivePath.endsWith(".tar")) {
            extractTar(archivePath, destPath);
        } else {
            throw new IllegalArgumentException("Unsupported archive format.");
        }
    }


    private static void extractZip(String archivePath, String destPath) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(archivePath)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String filePath = destPath + "/" + entry.getName();
                if (!entry.isDirectory()) {
                    Files.createDirectories(Paths.get(filePath).getParent());
                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                } else {
                    Files.createDirectories(Paths.get(filePath));
                }
                zis.closeEntry();
            }
        }
    }

    private static void extractTarGz(String archivePath, String destPath) throws IOException {
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new GzipCompressorInputStream(new BufferedInputStream(new FileInputStream(archivePath))))) {
            extractTarInternal(tais, destPath);
        }
    }

    private static void extractTar(String archivePath, String destPath) throws IOException {
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new BufferedInputStream(new FileInputStream(archivePath)))) {
            extractTarInternal(tais, destPath);
        }
    }

    private static void extractTarInternal(TarArchiveInputStream tais, String destPath) throws IOException {
        TarArchiveEntry entry;
        while ((entry = tais.getNextTarEntry()) != null) {
            String filePath = destPath + "/" + entry.getName();
            if (!entry.isDirectory()) {
                Files.createDirectories(Paths.get(filePath).getParent());
                try (FileOutputStream fos = new FileOutputStream(filePath)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = tais.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            } else {
                Files.createDirectories(Paths.get(filePath));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String dest = "extracted_files";

        extractArchive("test.zip", dest); // Test case 1: ZIP file
        extractArchive("test.tar.gz", dest); // Test case 2: TAR.GZ file
        extractArchive("test.tgz", dest); // Test case 3: TGZ file
        extractArchive("test.tar", dest); // Test case 4: TAR file

        // Test case 5: Invalid format
        try {
            extractArchive("invalid.txt", dest);
        } catch (IllegalArgumentException e) {
            System.out.println("Test case 5 (invalid format) passed: " + e.getMessage());
        }

        Files.deleteIfExists(Paths.get("test.zip"));
        Files.deleteIfExists(Paths.get("test.tar.gz"));
        Files.deleteIfExists(Paths.get("test.tgz"));
        Files.deleteIfExists(Paths.get("test.tar"));
        Files.deleteIfExists(Paths.get("invalid.txt"));
    }
}