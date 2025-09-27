package ZeroShot.codestral;
import java.io.*;

public class Task127 {
    public static void copyFile(String source, String destination) {
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(destination);

            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        copyFile("source_file.txt", "temp_file.txt");
        copyFile("non_existent_file.txt", "temp_file.txt");
        copyFile("source_file.txt", "/non_writable_directory/temp_file.txt");
        copyFile("source_file.txt", "temp_file.txt");
        copyFile("source_file.txt", "another_temp_file.txt");
    }
}