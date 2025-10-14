package Vanilla.openai;
import java.io.*;
import java.util.zip.*;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

public class Task117 {
    public static List<String> extractZip(String zipFilePath, String destDir) throws IOException {
        List<String> extractedFiles = new ArrayList<>();
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = zis.getNextEntry();
        while (ze != null) {
            String filePath = destDir + File.separator + ze.getName();
            if (!ze.isDirectory()) {
                extractedFiles.add(filePath);
                extractFile(zis, filePath);
            } else {
                File dirZip = new File(filePath);
                dirZip.mkdirs();
            }
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
        zis.close();
        fis.close();
        return extractedFiles;
    }

    private static void extractFile(ZipInputStream zis, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read;
        while ((read = zis.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        List<String> files1 = extractZip("test1.zip", "output1");
        List<String> files2 = extractZip("test2.zip", "output2");
        List<String> files3 = extractZip("test3.zip", "output3");
        List<String> files4 = extractZip("test4.zip", "output4");
        List<String> files5 = extractZip("test5.zip", "output5");
        
        System.out.println(files1);
        System.out.println(files2);
        System.out.println(files3);
        System.out.println(files4);
        System.out.println(files5);
    }
}