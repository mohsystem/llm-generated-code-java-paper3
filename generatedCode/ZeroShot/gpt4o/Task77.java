package ZeroShot.openai;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Task77 {
    public static boolean downloadFile(String hostname, String username, String password, String remoteFilePath) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(hostname);
            if (!ftpClient.login(username, password)) {
                return false;
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String localFilePath = remoteFilePath.substring(remoteFilePath.lastIndexOf('/') + 1);
            try (FileOutputStream fos = new FileOutputStream(localFilePath)) {
                return ftpClient.retrieveFile(remoteFilePath, fos);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(downloadFile("ftp.example.com", "user", "pass", "/path/to/sensitive/file1"));
        System.out.println(downloadFile("ftp.example.com", "user", "pass", "/path/to/sensitive/file2"));
        System.out.println(downloadFile("ftp.example.com", "user", "pass", "/path/to/sensitive/file3"));
        System.out.println(downloadFile("ftp.example.com", "user", "pass", "/path/to/sensitive/file4"));
        System.out.println(downloadFile("ftp.example.com", "user", "pass", "/path/to/sensitive/file5"));
    }
}