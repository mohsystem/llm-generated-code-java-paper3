package ZeroShot.codestral;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Task117 {
    private static final int BUFFER_SIZE = 4096;

    public static void extractZipFile(String zipFilePath, String destDir) throws IOException {
        File destDirFile = new File(destDir);

        if (!destDirFile.exists()) {
            destDirFile.mkdir();
        }

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();

        while (entry != null) {
            String filePath = destDir + File.separator + entry.getName();

            if (!entry.isDirectory()) {
                extractFile(zipIn, filePath);
            } else {
                File dir = new File(filePath);
                dir.mkdirs();
            }

            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }

        zipIn.close();
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;

        while ((read = zipIn.read(bytesIn)) != -1) {
            fos.write(bytesIn, 0, read);
        }

        fos.close();
    }

    public static void main(String[] args) {
        try {
            extractZipFile("path_to_your_file.zip", "destination_directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}