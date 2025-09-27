package ZeroShot.llama31;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Task77 {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            return;
        }
        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String filename = args[3];

        downloadFile(hostname, username, password, filename);
    }

    public static void downloadFile(String hostname, String username, String password, String filename) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            ftpClient.login(username, password);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            try (OutputStream outputStream = new FileOutputStream(filename)) {
                if (!ftpClient.retrieveFile(filename, outputStream)) {
                    System.out.println("Failed to download the file.");
                    return;
                }
                System.out.println("File downloaded successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                System.out.println("Error disconnecting from FTP server: " + e.getMessage());
            }
        }
    }
}