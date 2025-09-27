package ourMethod.gpt4o;
import java.io.*;
import java.util.zip.*;
import java.nio.file.*;
import java.util.*;
import org.apache.commons.compress.archivers.*;
import org.apache.commons.compress.archivers.tar.*;

public class Task117 {

    public static void extractZip(String zipFilePath, String destDir) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();

        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                File newFile = new File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    new File(newFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                entry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    public static void extractTar(String tarFilePath, String destDir) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();

        try (FileInputStream fis = new FileInputStream(tarFilePath);
             TarArchiveInputStream tais = new TarArchiveInputStream(new BufferedInputStream(fis))) {
            ArchiveEntry entry = tais.getNextEntry();
            while (entry != null) {
                File newFile = new File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    new File(newFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = tais.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                entry = tais.getNextEntry();
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Test cases
            extractZip("test1.zip", "output1");
            extractZip("test2.zip", "output2");
            extractTar("test3.tar", "output3");
            extractTar("test4.tar", "output4");
            extractZip("test5.zip", "output5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}