package CoT.gemini;
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

    public static void extract(String archivePath, String destPath) throws IOException {
        if (archivePath.toLowerCase().endsWith(".zip")) {
            extractZip(archivePath, destPath);
        } else if (archivePath.toLowerCase().endsWith(".tar") || archivePath.toLowerCase().endsWith(".tar.gz") || archivePath.toLowerCase().endsWith(".tgz")) {
            extractTar(archivePath, destPath);
        } else {
            throw new IllegalArgumentException("Unsupported archive format: " + archivePath);
        }
    }


    private static void extractZip(String archivePath, String destPath) throws IOException {

        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(archivePath)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                java.nio.file.Path filePath = Paths.get(destPath, fileName);

                if (!filePath.normalize().startsWith(Paths.get(destPath).normalize())) {
                    throw new IOException("Invalid zip entry: " + fileName);
                }

                if (entry.isDirectory()) {
                    Files.createDirectories(filePath);
                } else {
                    Files.createDirectories(filePath.getParent());
                    try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {

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



    private static void extractTar(String archivePath, String destPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             TarArchiveInputStream tais = archivePath.toLowerCase().endsWith(".gz") || archivePath.toLowerCase().endsWith(".tgz") ?
                     new TarArchiveInputStream(new GzipCompressorInputStream(bis)) : new TarArchiveInputStream(bis)) {

            TarArchiveEntry entry;
            while ((entry = tais.getNextTarEntry()) != null) {
                String fileName = entry.getName();
                java.nio.file.Path filePath = Paths.get(destPath, fileName);


                if (!filePath.normalize().startsWith(Paths.get(destPath).normalize())) {
                    throw new IOException("Invalid tar entry: " + fileName);
                }


                if (entry.isDirectory()) {
                    Files.createDirectories(filePath);
                } else {
                    Files.createDirectories(filePath.getParent());
                    try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = tais.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
            }

        }

    }



    public static void main(String[] args) throws IOException {
        String destPath = "extracted";

        extract("test.zip", destPath);
        extract("test.tar", destPath);
        extract("test.tar.gz", destPath);
        extract("test.tgz", destPath);
        extract("test2.zip", destPath);


    }
}