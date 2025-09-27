package ZeroShot.gemini;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Task77 {

    public static void downloadFile(String hostname, String username, String password, String remoteFilePath, String localFilePath) throws SocketException, IOException {
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(hostname);
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
            ftpClient.enterLocalPassiveMode(); 

            try (FileOutputStream fos = new FileOutputStream(localFilePath)) {
                if (!ftpClient.retrieveFile(remoteFilePath, fos)) {
                    System.err.println("Failed to download file");
                }
            }

        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    // Handle disconnect exception if needed
                }
            }
        }
    }


    public static void main(String[] args) {
         if (args.length != 4) {
                System.err.println("Usage: java Task77 <hostname> <username> <password> <remoteFile>");
                return;
            }

            String hostname = args[0];
            String username = args[1];
            String password = args[2];
            String remoteFile = args[3];
            String localFile = "downloaded_" + remoteFile; // Save with a prefix

        try {
            downloadFile(hostname, username, password, remoteFile, localFile);
            System.out.println("File downloaded successfully to: " + localFile);

        } catch (IOException e) {
            System.err.println("Error during FTP transfer: " + e.getMessage());
        }
    }
}