package CoT.gemini;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Task77 {

    public static void downloadFile(String hostname, int port, String username, String password, String remoteFile, String localFile) throws SocketException, IOException {
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(hostname, port);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.err.println("FTP connection failed: " + replyCode);
                return;
            }

            if (!ftpClient.login(username, password)) {
                System.err.println("FTP login failed");
                return;
            }

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode(); // Use passive mode for firewall compatibility

            try (FileOutputStream fos = new FileOutputStream(localFile)) {
                if (!ftpClient.retrieveFile(remoteFile, fos)) {
                    System.err.println("Failed to download file: " + remoteFile);
                }
            }

        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        try {
             downloadFile("test.rebex.net", 21, "demo", "password", "/pub/example.txt", "downloaded_example.txt");
             downloadFile("test.rebex.net", 21, "demo", "password", "/pub/readme.txt", "downloaded_readme.txt");
             downloadFile("speedtest.tele2.net", 21, "anonymous", "", "/1KB.zip", "1KB.zip");
             // Test with incorrect credentials
             downloadFile("test.rebex.net", 21, "invaliduser", "wrongpassword", "/pub/example.txt", "invalid_download.txt");
             // Test with non-existing file
             downloadFile("test.rebex.net", 21, "demo", "password", "/pub/nonexistent.txt", "nonexistent_download.txt");
         } catch (IOException e) {
            e.printStackTrace();
        }

    }

}