package ZeroShot.gemini;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;


public class Task117 {

    public static void extractArchive(String archivePath, String destPath) throws IOException {
        File archiveFile = new File(archivePath);
        if (!archiveFile.exists()) {
            throw new IOException("Archive file not found: " + archivePath);
        }

        if (archivePath.endsWith(".zip")) {
            extractZip(archivePath, destPath);
        } else if (archivePath.endsWith(".tar.gz") || archivePath.endsWith(".tgz")) {
            extractTarGz(archivePath, destPath);
        } else if (archivePath.endsWith(".tar.bz2") || archivePath.endsWith(".tbz")) {
            extractTarBz2(archivePath, destPath);
        } else if (archivePath.endsWith(".tar")) {
            extractTar(archivePath, destPath);
        } else {
            throw new IOException("Unsupported archive format: " + archivePath);
        }

    }


    private static void extractZip(String archivePath, String destPath) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(archivePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                File newFile = newFile(new File(destPath), entry);
                if (entry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    extractFile(zis, newFile);
                }
            }
        }
    }

    private static void extractTar(String archivePath, String destPath) throws IOException {
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(archivePath))) {
            extractTarGeneric(tais, destPath);

        }
    }

    private static void extractTarGz(String archivePath, String destPath) throws IOException {

        try (TarArchiveInputStream tais = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream(archivePath)))) {
            extractTarGeneric(tais, destPath);
        }
    }


    private static void extractTarBz2(String archivePath, String destPath) throws IOException {
        try (TarArchiveInputStream tais = new TarArchiveInputStream(new BZip2CompressorInputStream(new FileInputStream(archivePath)))) {
            extractTarGeneric(tais, destPath);
        }
    }


    private static void extractTarGeneric(TarArchiveInputStream tais, String destPath) throws IOException {
        TarArchiveEntry entry;
        while ((entry = tais.getNextTarEntry()) != null) {
            File newFile = newFile(new File(destPath), entry);

            if (entry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                extractFile(tais, newFile);
            }
        }
    }

    private static void extractFile(BufferedInputStream inputStream, File outputFile) throws IOException {
        File parent = outputFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IOException("Failed to create directory " + parent);
        }

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

    }


    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    private static File newFile(File destinationDir, TarArchiveEntry tarEntry) throws IOException {
        File destFile = new File(destinationDir, tarEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + tarEntry.getName());
        }

        return destFile;
    }



    public static void main(String[] args) throws IOException {
        String tempDir = Files.createTempDirectory("test").toString();
        extractArchive("test.zip", tempDir + "/test1");
        extractArchive("test.tar", tempDir + "/test2");
        extractArchive("test.tar.gz", tempDir + "/test3");
        extractArchive("test.tar.bz2", tempDir + "/test4");
        extractArchive("test.tgz", tempDir + "/test5");
    }
}