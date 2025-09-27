package CoT.llama31;
import java.io.*;
import java.util.zip.*;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class Task117 {
    public static void extractZip(String zipFile, String outputFolder) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File outputFile = new File(outputFolder, entry.getName());
            if (entry.isDirectory()) {
                outputFile.mkdirs();
            } else {
                outputFile.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(outputFile);
                IOUtils.copy(zis, fos);
                fos.close();
            }
        }
        zis.close();
    }

    public static void extractTar(String tarFile, String outputFolder) throws IOException {
        TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(tarFile));
        TarArchiveEntry entry;
        while ((entry = tais.getNextEntry()) != null) {
            File outputFile = new File(outputFolder, entry.getName());
            if (entry.isDirectory()) {
                outputFile.mkdirs();
            } else {
                outputFile.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(outputFile);
                IOUtils.copy(tais, fos);
                fos.close();
            }
        }
        tais.close();
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        extractZip("path/to/your/zipfile.zip", "path/to/output/folder");
        extractTar("path/to/your/tarfile.tar", "path/to/output/folder");
    }
}