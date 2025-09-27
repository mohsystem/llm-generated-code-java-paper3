package CoT.codestral;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task86 {
    public static void main(String[] args) {
        String url = "http://example.com/program.exe";
        try {
            downloadAndExecute(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadAndExecute(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        Path targetPath = Paths.get("program.exe");

        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(targetPath.toFile())) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, lengthRead);
            }
        }

        // Ensure the file is executable
        Files.setPosixFilePermissions(targetPath, Files.getPosixFilePermissions(targetPath).add(java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE));

        // Execute the downloaded file
        Runtime.getRuntime().exec(targetPath.toString());
    }
}