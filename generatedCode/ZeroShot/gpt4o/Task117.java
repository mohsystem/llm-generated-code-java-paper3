package ZeroShot.openai;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task117 {
    public static void extractZip(String zipFilePath, String destDir) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = zis.getNextEntry();
        byte[] buffer = new byte[1024];
        while (ze != null) {
            File newFile = new File(destDir, ze.getName());
            if (ze.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();
                Files.copy(zis, newFile.toPath());
            }
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        fis.close();
    }

    public static void main(String[] args) {
        try {
            extractZip("example.zip", "outputDir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}