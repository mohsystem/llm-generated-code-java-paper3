package CoT.gpt4o;
import java.io.*;
import java.util.zip.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.compress.archivers.tar.*;

public class Task117 {

    public static void extractZip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    public static void extractTar(String tarFilePath, String destDirectory) throws IOException {
        try (TarArchiveInputStream tarIn = new TarArchiveInputStream(new FileInputStream(tarFilePath))) {
            TarArchiveEntry entry;
            while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (entry.isDirectory()) {
                    File dir = new File(filePath);
                    dir.mkdirs();
                } else {
                    extractFile(tarIn, filePath);
                }
            }
        }
    }

    private static void extractFile(TarArchiveInputStream tarIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = tarIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    public static void main(String[] args) {
        try {
            extractZip("example.zip", "outputDir");
            extractTar("example.tar", "outputDir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}