package CoT.llama31;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task77 {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            return;
        }
        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String filename = args[3];

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname, 21);
            if (!ftpClient.login(username, password)) {
                System.out.println("Login failed");
                return;
            }
            System.out.println("Login successful");

            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            File file = new File(filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            if (!ftpClient.retrieveFile(filename, outputStream)) {
                System.out.println("File download failed");
            } else {
                System.out.println("File downloaded successfully");
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                System.out.println("Error disconnecting: " + e.getMessage());
            }
        }
    }
}