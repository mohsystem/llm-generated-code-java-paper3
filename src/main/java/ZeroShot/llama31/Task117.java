package ZeroShot.llama31;
import java.io.*;
import java.util.zip.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;

public class Task117 {
    public static void extractZip(String zipFilePath, String extractTo) throws IOException {
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry;
        while ((entry = zipIn.getNextEntry()) != null) {
            File filePath = new File(extractTo, entry.getName());
            if (entry.isDirectory()) {
                filePath.mkdirs();
            } else {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                byte[] bytesIn = new byte[4096];
                int read = 0;
                while ((read = zipIn.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }
                bos.close();
            }
        }
        zipIn.close();
    }

    public static void extractTar(String tarFilePath, String extractTo) throws IOException {
        TarArchiveInputStream tarIn = new TarArchiveInputStream(new FileInputStream(tarFilePath));
        TarArchiveEntry entry;
        while ((entry = tarIn.getNextEntry()) != null) {
            File filePath = new File(extractTo, entry.getName());
            if (entry.isDirectory()) {
                filePath.mkdirs();
            } else {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                byte[] bytesIn = new byte[4096];
                int read = 0;
                while ((read = tarIn.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }
                bos.close();
            }
        }
        tarIn.close();
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        extractZip("path/to/sample.zip", "extract/to/directory");
        extractTar("path/to/sample.tar", "extract/to/directory");
    }
}